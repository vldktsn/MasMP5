package pja.edu.s19183.masmp5.repo;

import org.springframework.data.repository.CrudRepository;
import pja.edu.s19183.masmp5.model.Company;

import java.util.List;

public interface CompanyRepo extends CrudRepository<Company, Long> {
    public List<Company> findByCity(String city);
    public List<Company> findByNameAndCity(String name, String city);

}
