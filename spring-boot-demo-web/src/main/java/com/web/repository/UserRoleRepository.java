package com.web.repository;

import com.web.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/29<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/29            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,String> {

}
