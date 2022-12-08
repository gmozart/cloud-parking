package one.digitalinovation.parking.controller;

import lombok.RequiredArgsConstructor;

import one.digitalinovation.parking.dto.ParkingDTO;
import one.digitalinovation.parking.exception.CdpNotFoundException;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.service.ParkingService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping
    public ResponseEntity<ParkingDTO> save(@RequestBody ParkingDTO parkingDTO){
        parkingService.save(parkingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(parkingService.findById(id).orElseThrow(CdpNotFoundException::new));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        return ResponseEntity.ok(parkingService.findAll().orElseThrow(CdpNotFoundException::new));
    }

    @GetMapping("/")
    public ResponseEntity<Page<ParkingDTO>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(parkingService.findAll(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable Long id, @RequestBody ParkingDTO parkingDTO){
        return ResponseEntity.ok(parkingService.update(id, parkingDTO).orElseThrow(CdpNotFoundException::new));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/checkout/{id}")
    public ResponseEntity<Void> checkout(@PathVariable Long id){
        parkingService.checkOut(id);
        return  ResponseEntity.noContent().build();
    }


}
