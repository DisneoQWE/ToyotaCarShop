package com.example.demo.cars;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer carPrice;
    @Column
    private String carModel;

    public Car(Integer carPrice, String carModel) {
        this.carPrice = carPrice;
        this.carModel = carModel;
    }

    public Car() {

    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carPrice=" + carPrice +
                ", carModel='" + carModel + '\'' +
                '}';
    }
}
