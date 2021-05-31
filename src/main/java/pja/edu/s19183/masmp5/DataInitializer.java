package pja.edu.s19183.masmp5;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pja.edu.s19183.masmp5.model.Company;
import pja.edu.s19183.masmp5.model.Driver;
import pja.edu.s19183.masmp5.repo.CompanyRepo;
import pja.edu.s19183.masmp5.repo.DriverRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CompanyRepo companyRepo;
    private final DriverRepo driverRepo;

    @EventListener
    public void atStart(ContextRefreshedEvent event){
        System.out.println("Context refreshed");
        Iterable<Company> all = companyRepo.findAll();
        Iterable<Driver> allDrivers = driverRepo.findAll();
        System.out.println(all);
        System.out.println(allDrivers);



    }

}
