package one.digitalinovation.parking.controller;

import lombok.RequiredArgsConstructor;

import one.digitalinovation.parking.service.ParkingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/parking")
public class ParkingController {

    private final ParkingService parkingService;






}
