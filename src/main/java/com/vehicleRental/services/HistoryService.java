package com.vehicleRental.services;

import com.vehicleRental.domain.History;

/**
 * Created by Vulombe on 29/10/2017.
 */
public interface HistoryService
{
    History create(History history);
    History read(long id);
    History update(History history);
    void delete(long id);
    Iterable<History> findAll();
}
