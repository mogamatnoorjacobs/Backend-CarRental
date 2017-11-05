package com.vehicleRental.repositories;

import com.vehicleRental.domain.History;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vulombe on 29/10/2017.
 */
public interface HistoryRepository extends CrudRepository<History, Long>
{
    History findByInvoices(long id);

}
