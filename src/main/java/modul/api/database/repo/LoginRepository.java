package modul.api.database.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import modul.api.service.exception.ModulException;
import modul.api.service.hibbean.LoginHIBBean;

@Repository
public interface LoginRepository extends CrudRepository<LoginHIBBean, Long>{
	
	@Transactional
	@Query(value ="select user.role from user user where user.username = ?1 AND user.password = ?2", nativeQuery=true)
	String loginByUsernameAndPassword(String username, String password) throws ModulException;

}
