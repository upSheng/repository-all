package com.chs.cloud.order.feign;

import com.chs.api.user.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 16:30
 */
@FeignClient(name = "user")
public interface UserFeign extends UserApi {


}
