package com.vehicleRental.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Order  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private Customer customer;
    private String orderDate;

    public Order(){}

    public Order(Builder builder) {
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        //this.customer = builder.customer;
    }

    public static class Builder{
        private Long id;
        //private Customer customer;
            private String orderDate;

//        public Builder customer(Customer value)
//        {
//            this.customer = value;
//            return this;
//        }

        public Builder id(long value)
        {
            this.id = value;
            return this;
        }
        public Builder orderDate(String value)
        {
            this.orderDate = value;
            return this;
        }


        public Order build()
        {
            return new Order(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
