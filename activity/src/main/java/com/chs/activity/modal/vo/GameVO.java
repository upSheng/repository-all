package com.chs.activity.modal.vo;

import com.chs.activity.modal.bean.heybox.GameInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 10:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GameVO {

    private Integer id;
    private String name;
    private String nameEn;
    private String appId;
    private Integer price;
    private Integer oriPrice;
    private String steamUrl;
    private String steamImg;
    private GameInfo gameInfo;

}
