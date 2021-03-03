package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.bean.NetWorthTrend;
import com.chs.activity.modal.entity.FundEntity;
import com.chs.activity.modal.entity.NetWorthTrendEntity;
import com.chs.activity.repository.IFundRepository;
import com.chs.activity.repository.INetWorthTrendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/26 10:17
 */
@Slf4j
@Service
public class FundService {

    @Resource
    INetWorthTrendRepository netWorthTrendRepository;

    @Resource
    IFundRepository fundRepository;


    /**
     * 基金净值
     *
     * @param code 基金代码
     * @return 基金净值
     */
    public List<NetWorthTrend> netWorthTrendList(String code) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://fund.eastmoney.com/pingzhongdata/" + code + ".js"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String str = response.body();
            int a = str.indexOf("Data_netWorthTrend");
            int b = str.indexOf("]", a);
            JSONArray objects = JSON.parseArray(str.substring(a + 21, b + 1));
            List<NetWorthTrend> netWorthTrendEntityList = objects.toJavaList(NetWorthTrend.class);

            a = str.indexOf("Data_ACWorthTrend");
            b = str.indexOf(";", a);
            objects = JSON.parseArray(str.substring(a + 20, b));
            for (int i = 0; i < netWorthTrendEntityList.size(); i++) {
                netWorthTrendEntityList.get(i).setSumY(objects.getJSONArray(i).getDouble(1));
            }

            log.info("拉取基金{}净值数据", code);
            return netWorthTrendEntityList;
        } catch (Exception ex) {
            log.error("{}", ex.getMessage());
        }
        return Collections.emptyList();
    }

    public List<FundEntity> fund() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://fund.eastmoney.com/js/fundcode_search.js"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String str = response.body();

            System.out.println(str.substring(9));
            JSONArray objects = JSON.parseArray(str.substring(9, str.length() - 1));
            List<FundEntity> res = new ArrayList<>();
            for (int i = 0; i < objects.size(); i++) {
                FundEntity fundEntity = new FundEntity();
                fundEntity.setCode(objects.getJSONArray(i).getString(0));
                fundEntity.setName(objects.getJSONArray(i).getString(2));
                fundEntity.setType(objects.getJSONArray(i).getString(3));
                res.add(fundEntity);
            }

            return res;
        } catch (Exception ex) {
            log.error("{}", ex.getMessage());
        }
        return Collections.emptyList();
    }

    public List<NetWorthTrendEntity> saveNetWorthTrendList(String code) {
        List<NetWorthTrend> netWorthTrendList = netWorthTrendList(code);

        List<NetWorthTrendEntity> dateList = netWorthTrendList.stream()
                .map(x -> new NetWorthTrendEntity()
                        .setCode(code)
                        .setX(LocalDate.ofInstant(Instant.ofEpochMilli(x.getX()), ZoneId.systemDefault()))
                        .setY(x.getY())
                        .setSumY(x.getSumY())
                        .setEquityReturn(x.getEquityReturn())
                        .setUnitMoney(x.getUnitMoney()))
                .collect(Collectors.toList());

        return netWorthTrendRepository.saveAll(dateList, MongoConstants.TABLE_NET_WORTH_TREND + code);
    }

    public void saveFund() {
        List<FundEntity> fundEntityList = fund();
        if (!CollectionUtils.isEmpty(fundEntityList)) {
            fundRepository.saveAll(fundEntityList);
        }
    }

    public Map<String, Object> data(String code) {

        List<NetWorthTrendEntity> all = netWorthTrendRepository.findAll(MongoConstants.TABLE_NET_WORTH_TREND + code);

        if (CollectionUtils.isEmpty(all)) {
            all = saveNetWorthTrendList(code);
        }
        List<List<Object>> equityReturn = new ArrayList<>();

        for (NetWorthTrendEntity entity : all) {
            List<Object> list = new ArrayList<>();
            list.add(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(entity.getX()));
            list.add(entity.getEquityReturn());
            equityReturn.add(list);
        }

        List<List<Object>> y = new ArrayList<>();
        for (NetWorthTrendEntity entity : all) {
            List<Object> list = new ArrayList<>();
            list.add(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(entity.getX()));
            list.add(entity.getY());
            y.add(list);
        }

        FundEntity fund = fundRepository.findByCode(code);
        Map<String, Object> res = new HashMap<>();
        res.put("equityReturn", equityReturn);
        res.put("y", y);
        res.put("name", fund.getName());
        return res;
    }

    public void exportCsv(String code) {
        FundEntity fund = fundRepository.findByCode(code);

        List<NetWorthTrendEntity> data = netWorthTrendRepository.findAll(MongoConstants.TABLE_NET_WORTH_TREND + code);
        String name = fund.getName();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name + System.currentTimeMillis() + ".csv", StandardCharsets.UTF_8));

        try {
            ServletOutputStream outputStream = response.getOutputStream();

            for (NetWorthTrendEntity entity : data) {
                StringBuilder sb = new StringBuilder();
                sb.append(entity.getX()).append(",");
                sb.append(entity.getCode()).append(",");
                sb.append(entity.getY()).append(",");
                sb.append(entity.getSumY()).append(",");
                sb.append(entity.getEquityReturn()).append(",");
                sb.append(entity.getUnitMoney()).append(",");
                outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }

            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
            log.error("导出失败");
        }


    }

}
