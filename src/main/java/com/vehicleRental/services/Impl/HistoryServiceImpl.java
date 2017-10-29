package com.vehicleRental.services.Impl;

import com.vehicleRental.domain.History;
import com.vehicleRental.repositories.HistoryRepository;
import com.vehicleRental.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryServiceImpl implements HistoryService
{
    @Autowired
    private HistoryRepository historyRepository;


    public History create(History history)
    {
        return historyRepository.save(history);
    }

    public History read(long id)
    {
        return historyRepository.findOne(id);
    }
    public History update(History history)
    {
        return historyRepository.save(history);
    }
    public void delete(long id)
    {
         historyRepository.delete(id);
    }
    public Iterable<History> findAll()
    {
        return  historyRepository.findAll();
    }
}
