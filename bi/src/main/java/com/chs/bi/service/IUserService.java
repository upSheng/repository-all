package com.chs.bi.service;

import com.chs.bi.base.response.EasyPage;
import com.chs.bi.model.entity.User;
import com.chs.bi.model.vo.UserQuery;

public interface IUserService {

    User insert(User entity);

    EasyPage<User> selectPage(UserQuery userQuery);
}
