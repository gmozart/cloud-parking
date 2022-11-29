package one.digitalinovation.parking.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Parking {

    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;


    public Parking(String id, String s, String sc, String celta, String preto) {
    }


}
