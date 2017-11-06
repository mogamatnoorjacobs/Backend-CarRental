package com.vehicleRental.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Noor on 27/10/2017.
 */
@Entity
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name,surname,email;
    private int houseNumber;
    private String city;
    private String province;
    private int postalCode;
    private String complex;
    private String street;

//    public List<Invoices> getInvoices() {
//        return invoices;
//    }
//    @OneToMany
//    private List<Invoices> invoices;

    private Customer(){
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getComplex() {
        return complex;
    }

    public String getStreet() {
        return street;
    }

    public Customer(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email=builder.email;
        this.houseNumber = builder.houseNumber;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.complex = builder.complex;
        this.street = builder.street;
        //this.invoices = builder.invoices;
    }

    public static class Builder{
        private long id;
        private String name,surname,email;
        private int houseNumber;
        private String city;
        private String province;
        private int postalCode;
        private String complex;
        private String street;
       // private List<Invoices> invoices;

//        public Builder invoices (List<Invoices> value)
//        {
//            this.invoices = value;
//            return this;
//        }
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
        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder email(String value)
        {
            this.email=value;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Customer customer = (Customer) o;

            return id == customer.id;
        }

        @Override
        public int hashCode() {
            return (int) (id ^ (id >>> 32));
        }

    }





}
