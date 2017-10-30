package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Invoices;

//just added to commit new changes ignore this
/**
 * Created by Vulombe on 29/10/2017.
 */

public class InvoiceFactory
{
    public  static Invoices getInvoice(Customer customer)
    {
        Invoices invoices = new Invoices.Builder()
                .customer(customer)
                .build();
        return invoices;
    }
}
