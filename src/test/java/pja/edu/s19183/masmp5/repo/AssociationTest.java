package pja.edu.s19183.masmp5.repo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pja.edu.s19183.masmp5.model.Company;
import pja.edu.s19183.masmp5.model.FoodDeliveryDriver;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.Optional;


@DataJpaTest
class AssociationTest {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private FoodDeliveryDriverRepo foodDeliveryDriverRepo;

    @PersistenceContext
    private EntityManager entityManager;

    Company c1;
    FoodDeliveryDriver fdd1;

    @BeforeEach
    public void initData(){
        c1 = Company
                .builder()
                .name("Uklon")
                .city("Kyiv")
                .build();

        fdd1 = FoodDeliveryDriver
                .builder()
                .firstName("John")
                .lastName("Smith")
                .salary(1500)
                .typeOfTransport("Bicycle")
                .build();
    }


    @Test
    public void testSave(){
        c1.getDrivers().add(fdd1);
        companyRepo.save(c1);
        fdd1.setCompany(c1);
        foodDeliveryDriverRepo.save(fdd1);

        Optional<Company> byId = companyRepo.findById(c1.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getDrivers());
        assertEquals(1, byId.get().getDrivers().size());

    }

    @Test
    public void testRequiredDependencies(){
        assertNotNull(companyRepo);
        assertNotNull(foodDeliveryDriverRepo);
    }


}
