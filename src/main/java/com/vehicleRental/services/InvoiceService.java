package com.vehicleRental.services;

import com.vehicleRental.domain.Invoices;

//just added to commit new changes ignore this
/**
 * Created by Vulombe M on 29/10/2017.
 */
public interface InvoiceService
{
    Invoices create(Invoices invoices);
    Invoices read(long id);
    Invoices update(Invoices invoices);
    void delete(long id);
    Iterable<Invoices> findAll();
}
