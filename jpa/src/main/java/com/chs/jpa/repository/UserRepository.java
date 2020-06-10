package com.chs.jpa.repository;

import com.chs.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * jpa单表crud大全
 */
public interface UserRepository extends JpaRepository<User,Integer> {


    User findByAge(Integer age);

    @Query(value = "select * from user where age = ?1",nativeQuery = true)
    User findByAgeQuery(Integer age);

    @Query(value = "select * from user where age = :#{#user.age} ",nativeQuery = true)
    User findByAgeQuery1(User user);

}
