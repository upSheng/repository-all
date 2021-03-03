package com.chs.activity.repository;

import com.chs.activity.modal.entity.FundEntity;
import com.chs.activity.modal.entity.NetWorthTrendEntity;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/26 15:38
 */
public interface IFundRepository {


    List<FundEntity> saveAll(List<FundEntity> fundEntityList);

    FundEntity findByCode(String code);

}
