package com.vehicleRental.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thabomoopa on 2017/10/26.
 */

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String make;
    private String model;
    private int year;
    private int quantity;

    @ManyToOne
    private Category category;

    private Car(){

    }

    public Car(Builder builder) {
        this.id = builder.id;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.quantity = builder.quantity;
        this.category = builder.category;
    }

    public static class Builder{
        private long id;
        private String make;
        private String model;
        private int year;
        private int quantity;
        private Category category;

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder make(String value)
        {
            this.make = value;
            return this;
        }
        public Builder model(String value)
        {
            this.model = value;
            return this;
        }
        public Builder year(int value)
        {
            this.year = value;
            return this;
        }
        public Builder quantity(int value)
        {
            this.quantity = value;
            return this;
        }
        public Builder category(Category value)
        {
            this.category = value;
            return this;
        }
        public Car build()
        {
            return new Car(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
