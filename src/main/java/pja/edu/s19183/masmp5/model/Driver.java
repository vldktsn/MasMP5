package pja.edu.s19183.masmp5.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.annotation.security.DenyAll;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You should specify the first name of the Driver!")
    @Size(min = 2, max = 30)
    private String firstName;

    @NotBlank(message = "You should specify the last name of the Driver!")
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Min(200)
    private double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;
}
