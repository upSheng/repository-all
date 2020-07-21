package com.web.repository;


import com.web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByName(String name);

}
