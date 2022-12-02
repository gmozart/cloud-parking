package one.digitalinovation.parking.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;



}
