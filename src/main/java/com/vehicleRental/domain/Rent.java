package com.vehicleRental.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.persistence.criteria.Order;

@Entity
public class Rent implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rentDate;
    private String returntDate;
    private BigDecimal totalPrice;
    private  int quantity;

    @OneToOne
    @JoinColumn(name = "carID")
    private Car car;

    @ManyToOne
    private Orders order;

    public Long getId() {
        return id;
    }
    public String getRentDate() {
        return rentDate;
    }
    public String getReturntDate() {
        return returntDate;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public Car getCar() {
        return car;
    }

    public Orders getOrder() {
        return order;
    }

    public Rent(Builder builder)
    {
        this.order = builder.order;
        this.id = builder.id;
        this.rentDate = builder.rentDate;
        this.returntDate = builder.returntDate;
        this.totalPrice = builder.totalPrice;
        this.quantity = builder.quantity;
        this.car = builder.car;
    }

    public static  class Builder {
        private Long id;
        private String rentDate;
        private String returntDate;
        private BigDecimal totalPrice;
        private int quantity;
        private Car car;
        private Orders order;

        public Builder order(Orders value)
        {
            this.order = value;
            return this;
        }
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder rentDate(String value) {
            this.rentDate = value;
            return this;
        }

        public Builder returntDate(String value) {
            this.returntDate = value;
            return this;
        }

        public Builder totalPrice(BigDecimal value) {
            this.totalPrice = value;
            return this;
        }

        public Builder quantity(int value) {
            this.quantity = value;
            return this;
        }

        public Builder car(Car value) {
            this.car = value;
            return this;
        }

        public Rent build() {
            return new Rent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        return id.equals(rent.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
