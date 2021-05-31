package pja.edu.s19183.masmp5.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pja.edu.s19183.masmp5.model.Company;
import pja.edu.s19183.masmp5.model.Driver;
import pja.edu.s19183.masmp5.model.FoodDeliveryDriver;
import pja.edu.s19183.masmp5.model.TaxiDriver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DriverRepoTest {

    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private TaxiDriverRepo taxiDriverRepo;
    @Autowired
    private FoodDeliveryDriverRepo foodDeliveryDriverRepo;

    @PersistenceContext
    private EntityManager entityManager;

    TaxiDriver taxiDriver1, taxiDriver2;

    FoodDeliveryDriver foodDeliveryDriver1;


    @BeforeEach
    public void initData(){
        taxiDriver1 = TaxiDriver
                .builder()
                .firstName("Dmytro")
                .lastName("Borovych")
                .salary(4000)
                .licenseID("F192837VS")
                .plateNumber("WAW2385")
                .build();
        taxiDriver2 = TaxiDriver
                .builder()
                .firstName("Vladyslav")
                .lastName("Kutsenko")
                .salary(5000)
                .licenseID("H1238976GS")
                .plateNumber("GDN1524")
                .build();
        foodDeliveryDriver1 = FoodDeliveryDriver
                .builder()
                .firstName("Radyslav")
                .lastName("Burylko")
                .salary(6000)
                .typeOfTransport("Legs")
                .build();
    }


    @Test
    public void testRequiredDepencencies(){
        assertNotNull(driverRepo);
        assertNotNull(taxiDriverRepo);
        assertNotNull(foodDeliveryDriverRepo);
    }


    @Test
    public void testSaveAll(){
        foodDeliveryDriverRepo.save(foodDeliveryDriver1);
        taxiDriverRepo.saveAll(Arrays.asList(taxiDriver1,taxiDriver2));
        entityManager.flush();
        assertEquals(3, driverRepo.count());
    }

}