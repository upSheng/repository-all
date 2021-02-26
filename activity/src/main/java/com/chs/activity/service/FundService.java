package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.bean.NetWorthTrend;
import com.chs.activity.modal.entity.NetWorthTrendEntity;
import com.chs.activity.repository.INetWorthTrendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
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

    public List<NetWorthTrend> netWorthTrendList(String code) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://fund.eastmoney.com/pingzhongdata/" + code + ".js"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String str = response.body();
            int a = str.indexOf("Data_netWorthTrend");
            int b = str.indexOf("]", a);

            JSONArray objects = JSON.parseArray(str.substring(a + 21, b + 1));
            List<NetWorthTrend> netWorthTrendEntityList = objects.toJavaList(NetWorthTrend.class);
            return netWorthTrendEntityList;
        } catch (Exception ex) {
            log.error("{}", ex.getMessage());
        }
        return Collections.emptyList();
    }

    public void saveNetWorthTrendList(String code) {
        List<NetWorthTrend> netWorthTrendList = netWorthTrendList(code);

        List<NetWorthTrendEntity> dateList = netWorthTrendList.stream()
                .map(x -> new NetWorthTrendEntity()
                        .setCode(code)
                        .setX(LocalDate.ofInstant(Instant.ofEpochMilli(x.getX()), ZoneId.systemDefault()))
                        .setY(x.getY())
                        .setEquityReturn(x.getEquityReturn())
                        .setUnitMoney(x.getUnitMoney()))
                .collect(Collectors.toList());

        netWorthTrendRepository.saveAll(dateList, MongoConstants.TABLE_NET_WORTH_TREND + code);
    }

}
