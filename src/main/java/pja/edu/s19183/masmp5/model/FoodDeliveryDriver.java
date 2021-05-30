package pja.edu.s19183.masmp5.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//@Table(name = "delivery")
public class FoodDeliveryDriver extends Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String typeOfTransport;


    @OneToMany(mappedBy = "foodDeliveryDriver", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderInfo> orderInfos;

}
