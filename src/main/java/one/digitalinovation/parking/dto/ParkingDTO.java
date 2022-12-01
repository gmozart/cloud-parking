package one.digitalinovation.parking.dto;

import lombok.Builder;
import lombok.Data;
import one.digitalinovation.parking.model.Parking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class ParkingDTO {

    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;

    public static ParkingDTO of(Parking parking){
        return ParkingDTO.builder()
                .id(parking.getId())
                .license(parking.getLicense())
                .state(parking.getState())
                .model(parking.getModel())
                .color(parking.getColor())
                .entryDate(parking.getEntryDate())
                .exitDate(parking.getExitDate())
                .build();
    }

    public static Parking of(ParkingDTO parkingDTO){
        return Parking.builder()
                .id(parkingDTO.getId())
                .license(parkingDTO.getLicense())
                .state(parkingDTO.getState())
                .model(parkingDTO.getModel())
                .color(parkingDTO.getColor())
                .entryDate(parkingDTO.getEntryDate())
                .exitDate(parkingDTO.getExitDate())
                .build();
    }

    public Optional<ParkingDTO> of(Optional<Parking> parking){
        return parking.stream().map(ParkingDTO::of).findAny();
    }

    public static List<ParkingDTO> of(List<Parking> parkingList){
        return  parkingList.stream().map(ParkingDTO::of).collect(Collectors.toList());
    }
}
