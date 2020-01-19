package modul.api.database.repo;

import org.springframework.data.repository.CrudRepository;

import modul.api.service.hibbean.TeamHIBBean;

public interface TeamRepository extends CrudRepository<TeamHIBBean, Long>{

}
