package com.poc.controller;

import com.poc.domainobject.Car;
import com.poc.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "cars")
public class CarRestController {

    private final CarService carService;

    @GetMapping("/price")
    public List<Car> getCarsWithPriceFilter(
            @RequestParam(name = "min", required = true) double min,
            @RequestParam(name = "max", required = true) double max) {
        return carService.getCarsWithPriceFilter(min, max);
    }

    @GetMapping("/brand")
    public List<Car> getCarsWithBrandFilter(
            @RequestParam(name = "brand", required = true) String brand) {
        return carService.getCarsWithBrandFilter(brand);
    }

}
