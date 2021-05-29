package pja.edu.s19183.masmp5.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.annotation.security.DenyAll;
import javax.persistence.*;

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

    private String firstName;
    private String lastName;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;
}
