package pja.edu.s19183.masmp5.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pja.edu.s19183.masmp5.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo extends CrudRepository<Company, Long> {
    public List<Company> findByCity(String city);
    public List<Company> findByNameAndCity(String name, String city);


    @Query("from Company as c left join fetch c.drivers where c.id =:id")
    public Optional<Company> findById(@Param("id") Long id);

}
