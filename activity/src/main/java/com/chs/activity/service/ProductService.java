package com.chs.activity.service;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.modal.bean.GameAccount;
import com.chs.activity.modal.bean.ProductQuery;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.modal.enums.LabelEnum;
import com.chs.activity.modal.vo.ProductVO;
import com.chs.activity.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:15
 */
@Service
public class ProductService {

    @Resource
    OrderService orderService;

    @Resource
    IProductRepository productRepository;

    public EasyPage<ProductVO> search(ProductQuery productQuery) {

        // 如果携带userId 判断是否已拥有
        HashSet<String> productIdSet = new HashSet<>() ;
        if (productQuery.getUserId() != null){
            productIdSet.addAll(orderService.userProduct(productQuery.getUserId()));
        }
        productQuery.setProductIdSet(productIdSet);

        EasyPage<ProductEntity> search = productRepository.list(productQuery);
        List<ProductEntity> content = search.getContent();
        if (StringUtils.isEmpty(content)) {
            return new EasyPage<>(null, search.getCount());
        }

        List<ProductVO> productVOList = content.stream().map(x -> ProductVO.builder()
                .id(x.getId())
                .createTime(x.getCreateTime())
                .describe(x.getDescribe())
                .img(x.getImg())
                .name(x.getName())
                .price(x.getPrice())
                .oriPrice(x.getOriPrice())
                .weight(x.getWeight())
                .quantity(x.getQuantity())
                .tagList(x.getTagList())
                .steamUrl(x.getSteamUrl())
                .video(x.getVideo())
                .label(x.getLabel())
                .own(productIdSet.contains(x.getId())?1:0)
                .updateTime(x.getUpdateTime())
                .build()).collect(Collectors.toList());
        return new EasyPage<>(productVOList, search.getCount());
    }

    public GameAccount searchGameAccount(String id, String userId) {
        ProductEntity productEntity = productRepository.findById(id);

        if (productEntity == null) {
            return null;
        }
        if (LabelEnum.FREE.getLabel().equals(productEntity.getLabel())){

            return productEntity.getGameAccountList().get(0);
        }

        Set<String> productSet = orderService.userProduct(userId);
        if (productSet.contains(id)){
            return productEntity.getGameAccountList().get(0);
        }
        return null;
    }

    public ProductEntity save(ProductEntity productEntity) {
        if (productEntity.getId() == null) {
            productEntity.setCreateTime(LocalDateTime.now());
        } else {
            productEntity.setUpdateTime(LocalDateTime.now());
        }
        return productRepository.save(productEntity);
    }

    public EasyPage<ProductEntity> list(ProductQuery productQuery) {
        return productRepository.list(productQuery);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
