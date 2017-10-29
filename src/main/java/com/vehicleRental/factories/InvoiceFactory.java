package com.vehicleRental.factories;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Invoice;

/**
 * Created by Vulombe on 29/10/2017.
 */
public class InvoiceFactory
{
    public  static Invoice getInvoice(Customer customer)
    {
        Invoice invoice = new Invoice.Builder()
                .customer(customer)
                .build();
        return invoice;
    }
}
