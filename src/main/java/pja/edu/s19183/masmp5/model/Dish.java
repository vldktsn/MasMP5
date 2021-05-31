package pja.edu.s19183.masmp5.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "foodOrder_id", nullable = false, updatable = false)
    private FoodOrder foodOrder;


    @NotBlank(message = "You should specify dishes!")
    @Size(min = 2, max = 30)
    private String dish;

    @NotBlank
    @Min(5)
    private Double price;

}
