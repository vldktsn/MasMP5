package pja.edu.s19183.masmp5.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You should specify the name of the company!")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "You should specify the city where the company is located!")
    @Size(min = 2, max = 30)
    private String city;


    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Driver> drivers = new HashSet<>();

}
