package com.poc.service;

import com.poc.domainobject.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>(
            List.of(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d),
                    new Car(4L, "Golf", "VW", 120, 19000d),
                    new Car(5L, "Gallardo", "Lamborghini", 400, 100_000d)
            ));

    @Cacheable(value = "priceCacheManager", cacheManager = "priceFilterCacheManager")
    @Override
    public List<Car> getCarsWithPriceFilter(double min, double max) {
        return cars.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

    @Cacheable(value = "brandCacheManager", cacheManager = "brandFilterCacheManager")
    @Override
    public List<Car> getCarsWithBrandFilter(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }

}
