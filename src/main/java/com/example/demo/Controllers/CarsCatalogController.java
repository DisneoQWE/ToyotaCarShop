package com.example.demo.Controllers;

import com.example.demo.cars.Car;
import com.google.common.collect.Sets;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cars-catalog")
public class CarsCatalogController {
    private static final Set<Car> cars  = Sets.newHashSet(
            new Car(124, "Corolla"),
            new Car(400, "Camry"),
            new Car(200, "RAV4")
    );

    @GetMapping
    public Set<Car> mainPageCatalog(){
        return cars;
    }

    @PostMapping
    public void choseYourOwnCar(@RequestBody Car car){
        System.out.println(car.toString());
    }
}
