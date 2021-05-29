package pja.edu.s19183.masmp5.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepoTest {

    @Autowired
    private CompanyRepo companyRepo;

    @Test
    public void testRequiredDependencies(){
        assertNotNull(companyRepo);
    }

    @Test
    public void testFetchRepositories(){
        
    }
}