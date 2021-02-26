package com.chs.activity.modal.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/26 14:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetWorthTrend {
    private Long x;
    private Double y;
    private String unitMoney;
    private Double equityReturn;

}
