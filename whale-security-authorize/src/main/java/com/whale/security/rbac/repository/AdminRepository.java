/**
 * 
 */
package com.whale.security.rbac.repository;

import org.springframework.stereotype.Repository;
import com.whale.security.rbac.domain.Admin;

/**
 * @author zhailiang
 *
 */
@Repository
public interface AdminRepository extends ImoocRepository<Admin> {

	Admin findByUsername(String username);

}
