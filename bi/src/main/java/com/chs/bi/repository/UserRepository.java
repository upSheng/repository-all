package com.chs.bi.repository;

import com.chs.bi.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,String> {

}
