package pja.edu.s19183.masmp5.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"foodOrder_id", "foodDeliveryDriver_id"})})
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "foodOrder_id", nullable = false)
    @NotNull
    private FoodOrder foodOrder;


    @ManyToOne
    @JoinColumn(name = "foodDeliveryDriver_id", nullable = false)
    @NotNull
    private FoodDeliveryDriver foodDeliveryDriver;


    @NotNull
    private LocalDate orderReceived;


    @NotNull
    private LocalDate orderDelivered;


}
