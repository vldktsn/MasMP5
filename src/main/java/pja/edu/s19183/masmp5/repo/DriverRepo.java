package pja.edu.s19183.masmp5.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pja.edu.s19183.masmp5.model.Company;
import pja.edu.s19183.masmp5.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepo extends CrudRepository<Driver, Long> {


}
