package one.digitalinovation.parking.service;


import lombok.RequiredArgsConstructor;
import one.digitalinovation.parking.dto.ParkingDTO;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.repository.ParkingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@Service
@RequiredArgsConstructor
public class ParkingService {

    public final ParkingRepository parkingRepository;


    public void save(ParkingDTO parkingDTO){
        parkingDTO.setEntryDate(LocalDateTime.now());
        parkingDTO.setExitDate(null);
        parkingRepository.save(ParkingDTO.of(parkingDTO));
    }

    public Optional<ParkingDTO> findById(Long id){
        return ParkingDTO.of(parkingRepository.findById(id));
    }


    public Optional<List<ParkingDTO>> findAll(){
        return Optional.of(ParkingDTO.of(parkingRepository.findAll()));
    }


    public Page<ParkingDTO> findAll(Integer page, Integer size){
        return new PageImpl<>(ParkingDTO.of(parkingRepository.findAll()), PageRequest.of(page,size),size);
    }


    public Optional<ParkingDTO> update(Long id, ParkingDTO parkingDTO){
        parkingDTO.setId(id);
        return  Optional.of(ParkingDTO.of(parkingRepository.save(ParkingDTO.of(parkingDTO))));
    }


    public void delete(Long id){
        parkingRepository.deleteById(id);
    }


    public void checkOut(Long id){
        Optional<Parking> parking = parkingRepository.findById(id);
        parking.ifPresent(park -> {
            park.setExitDate(LocalDateTime.now());
            park.setBill(ParckingCheckOut.getBill(Optional.of(park)));
            parkingRepository.save(park);
        });

    }




}
