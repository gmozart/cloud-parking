package one.digitalinovation.parking.service;


import lombok.RequiredArgsConstructor;
import one.digitalinovation.parking.dto.ParkingDTO;
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


@Service
@RequiredArgsConstructor
public class ParkingService {

    public final ParkingRepository parkingRepository;

    @Transactional
    public void save(ParkingDTO parkingDTO){
        parkingDTO.setEntryDate(LocalDateTime.now());
        parkingDTO.setExitDate(null);
        parkingRepository.save(ParkingDTO.of(parkingDTO));
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<ParkingDTO> findById(Long id){
        return ParkingDTO.of(parkingRepository.findById(id));
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<List<ParkingDTO>> findAll(){
        return Optional.of(ParkingDTO.of(parkingRepository.findAll()));
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<ParkingDTO> findAll(Integer page, Integer size){
        return new PageImpl<>(ParkingDTO.of(parkingRepository.findAll()), PageRequest.of(page,size),size);
    }

    @Transactional
    public Optional<ParkingDTO> update(Long id, ParkingDTO parkingDTO){
        parkingDTO.setId(id);
        return  Optional.of(ParkingDTO.of(parkingRepository.save(ParkingDTO.of(parkingDTO))));
    }

    @Transactional
    public void delete(Long id){
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Optional<ParkingDTO> checkOut(Long id, ParkingDTO parkingDTO){
       parkingDTO.setId(id);
       findById(id);
       parkingDTO.setExitDate(LocalDateTime.now());
       parkingDTO.setBill(ParckingCheckOut.getBill(parkingDTO));

        return  Optional.of(ParkingDTO.of(parkingRepository.save(ParkingDTO.of(parkingDTO))));
    }


}
