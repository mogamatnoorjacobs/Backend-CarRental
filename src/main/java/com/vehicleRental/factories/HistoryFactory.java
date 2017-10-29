package com.vehicleRental.factories;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Invoice;
import com.vehicleRental.domain.Orders;

import java.util.Map;

/**
 * Created by Vulombe on 29/10/2017.
 */
public class HistoryFactory
{
    public  static History getHistory(Map<String, String> values, int year, Invoice invoice)
    {
        History history = new History.Builder()
                .make(values.get("make"))
                .model(values.get("make"))
                .year(year)
                .numberPlate(values.get("make"))
                .invoice(invoice)
                .orderDate(values.get("make"))
                .build();
        return history;
    }
}
