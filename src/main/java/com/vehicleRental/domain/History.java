package com.vehicleRental.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vulombe on 29/10/2017.
 */
@Entity
public class History implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String  make;
    private String  model;
    private  int year;
    private String numberPlate ;
    private String  orderDate;
    @ManyToOne
    private Invoice invoice;

    private History(){}

    public History(Builder builder)
    {
        this.id = builder.id;
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.numberPlate = builder.numberPlate;
        this.orderDate = builder.orderDate;
        this.invoice = builder.invoice;
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
    public String getNumberPlate() {
        return numberPlate;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public Invoice getInvoice() {
        return invoice;
    }

    public static class Builder{
        private long id;
        private String  make;
        private String  model;
        private  int year;
        private String  numberPlate;
        private String  orderDate;
        private Invoice invoice;


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

        public Builder numberPlate(String value)
        {
            this.numberPlate = value;
            return this;
        }

        public Builder invoice(Invoice value)
        {
            this.invoice = value;
            return this;
        }

        public Builder orderDate(String value)
        {
            this.orderDate = value;
            return this;
        }


        public History build()
        {
            return new History(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        return id == history.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
