package pja.edu.s19183.masmp5;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pja.edu.s19183.masmp5.model.Company;
import pja.edu.s19183.masmp5.repo.CompanyRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CompanyRepo companyRepo;

    @EventListener
    public void atStart(ContextRefreshedEvent event){
        System.out.println("Context refreshed");
        Iterable<Company> all = companyRepo.findAll();
        System.out.println(all);



    }

}
