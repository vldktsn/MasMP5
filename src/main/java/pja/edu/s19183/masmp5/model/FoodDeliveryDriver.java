package pja.edu.s19183.masmp5.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FoodDeliveryDriver extends Driver{
    private String typeOfTransport;


}
