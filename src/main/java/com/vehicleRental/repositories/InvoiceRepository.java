package com.vehicleRental.repositories;

import com.vehicleRental.domain.Invoices;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by Vulombe Makhubele on 29/10/2017..
 */
public interface InvoiceRepository extends CrudRepository<Invoices, Long>
{
    //Iterable<Rent> findAllById(long id);
}
