package modul.api.database.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import modul.api.service.hibbean.ProjectHIBBean;

/**
 * CRUD Repo for project, save style for database connection
 * 
 * M183: Project collector
 * 
 * @author Kristina Klincov, Stefanija Gojkovic
 * @version 1.1
 */
@Repository
public interface ProjectRepository extends CrudRepository<ProjectHIBBean, Long>{

}
