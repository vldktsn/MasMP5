package pja.edu.s19183.masmp5.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pja.edu.s19183.masmp5.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepoTest {

    @Autowired
    private CompanyRepo companyRepo;


    @PersistenceContext
    private EntityManager entityManager;

    Company c1;

    @BeforeEach
    public void initData(){
        c1 = Company.builder()
                .name("Bolt")
                .city("Warsaw")
                .build();
    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(companyRepo);
    }

    @Test
    public void testSaveCompany(){
        companyRepo.save(c1);
        entityManager.flush();
        long count = companyRepo.count();
        assertEquals(3,count);
    }

    @Test
    public void testFetchCompanies(){
        Iterable<Company> all = companyRepo.findAll();
        for(Company c: all){
            System.out.println(c);
        }
    }

    @Test
    public void testFindByCity(){
        List<Company> warsaw = companyRepo.findByCity("Warsaw");
        System.out.println(warsaw);
        assertEquals(1, warsaw.size());
    }

    @Test
    public void testFindByNameAndCity(){
        List<Company> company = companyRepo.findByNameAndCity("Uber", "Warsaw");
        System.out.println(company);
        assertEquals(1, company.size());
    }
}