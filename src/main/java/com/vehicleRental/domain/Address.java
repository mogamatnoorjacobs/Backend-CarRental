package com.vehicleRental.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int houseNumber;
    private String city;
    private String province;
    private int postalCode;
    private String complex;
    private String street;
    //private Customer customer;

    //public Customer getCustomer() {
//        return customer;
//    }

    //public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Address() {
    }

    public Address(Builder builder) {
        this.id = builder.id;
        this.houseNumber = builder.houseNumber;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.complex = builder.complex;
        this.street = builder.street;
        //this.customer = builder.customer;
    }

    public static class Builder{
        private long id;
        private int houseNumber;
        private String city;
        private String province;
        private int postalCode;
        private String complex;
        private String street;
        //private Customer customer;

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
        public Builder houseNumber(int value)
        {
            this.houseNumber = value;
            return this;
        }
        public Builder city(String value)
        {
            this.city = value;
            return this;
        }
        public Builder province(String value)
        {
            this.province = value;
            return this;
        }
        public Builder postalCode(int value)
        {
            this.postalCode = value;
            return this;
        }
        public Builder complex(String value)
        {
            this.complex = value;
            return this;
        }
        public Builder street(String value)
        {
            this.street = value;
            return this;
        }
        public Address build()
        {
            return new Address(this);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getComplex() {
        return complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
