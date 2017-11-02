package com.vehicleRental.factories;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Invoices;
import com.vehicleRental.domain.Rent;

import java.util.Map;

/**
 * Created by Vulombe on 29/10/2017.
 */
public class HistoryFactory
{
    public  static History getHistory(Map<String, Boolean> boolValues, Rent rent, Invoices invoices)
    {
        History history = new History.Builder()
                .rented(boolValues.get("rented"))
                .outstanding(boolValues.get("outstanding"))
                .rent(rent)
                .invoices(invoices)
                .build();
        return history;
    }
}
