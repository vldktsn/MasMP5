package pja.edu.s19183.masmp5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxiDriver extends Driver{

    @NotBlank
    private String licenseID;



}
