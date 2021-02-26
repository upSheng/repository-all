package com.chs.activity.repository;

import com.chs.activity.modal.entity.NetWorthTrendEntity;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/26 15:38
 */
public interface INetWorthTrendRepository {

    NetWorthTrendEntity save(NetWorthTrendEntity netWorthTrendEntity, String collectionName);

    List<NetWorthTrendEntity> saveAll(List<NetWorthTrendEntity> netWorthTrendEntityList, String collectionName);

}
