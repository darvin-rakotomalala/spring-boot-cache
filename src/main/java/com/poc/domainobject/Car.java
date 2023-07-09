package com.poc.domainobject;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Car {
    private long id;
    private String model;
    private String brand;
    private int horses;
    private double price;
}
