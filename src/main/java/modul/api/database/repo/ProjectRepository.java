package modul.api.database.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import modul.api.service.hibbean.ProjectHIBBean;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectHIBBean, Long>{

}