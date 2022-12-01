package one.digitalinovation.parking.controller;

import lombok.RequiredArgsConstructor;

import one.digitalinovation.parking.dto.ParkingDTO;
import one.digitalinovation.parking.exception.MtpNotFoundException;
import one.digitalinovation.parking.service.ParkingService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping
    public ResponseEntity<ParkingDTO> save(@RequestBody ParkingDTO parkingDTO){
        parkingService.save(parkingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(parkingService.findById(id).orElseThrow(MtpNotFoundException::new));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        return ResponseEntity.ok(parkingService.findAll().orElseThrow(MtpNotFoundException::new));
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<ParkingDTO>> findAll(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(parkingService.findAll(page, size));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable Long id, @RequestBody ParkingDTO parkingDTO){
        return ResponseEntity.ok(parkingService.update(id, parkingDTO).orElseThrow(MtpNotFoundException::new));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
