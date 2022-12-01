package one.digitalinovation.parking.service;

import one.digitalinovation.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
         var id = getUUID();
        var id1 = getUUID();
        Parking parking =  new Parking(id, "DMS-1111","SC","CELTA","PRETO");
        Parking parking1 =  new Parking(id1, "WAS-2312","PE","UNO","MARROM");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking);
    }

    private static String getUUID() {

        return UUID.randomUUID().toString().replace("-","");
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id){return parkingMap.get(id);}





}
