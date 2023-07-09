package com.poc.service;

import com.poc.domainobject.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarsWithPriceFilter(double min, double max);
    List<Car> getCarsWithBrandFilter(String brand);
}
