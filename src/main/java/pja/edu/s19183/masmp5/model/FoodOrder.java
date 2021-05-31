package pja.edu.s19183.masmp5.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "FoodOrder")
public class FoodOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "You should specify the Delivery Address!")
    @Size(min = 2, max = 30)
    private String street;

    @NotBlank(message = "You should specify the Client's first name!")
    @Size(min = 2, max = 30)
    private String clientName;

    @NotBlank(message = "You should specify the Client's phone number!")
    @Size(min = 2, max = 30)
    private String clientPhoneNumber;

    @NotBlank
    @Min(50)
    private Double price;


    @OneToMany(mappedBy = "foodOrder", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderInfo> orderInfos;


    @OneToMany(mappedBy = "foodOrder", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Dish> dishes;


}
