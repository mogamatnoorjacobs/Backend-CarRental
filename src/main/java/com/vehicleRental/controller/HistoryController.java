package com.vehicleRental.controller;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Invoices;
import com.vehicleRental.factories.HistoryFactory;
import com.vehicleRental.services.Impl.HistoryServiceImpl;
import com.vehicleRental.services.Impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vulombe on 29/10/2017.
 */
@Controller
@RequestMapping(path = "/history")
public class HistoryController
{
    private History history;
    private Invoices invoices;

    @Autowired
    private HistoryServiceImpl historyService;

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @CrossOrigin
    @PostMapping(path="/{invoiceId}/checkHistory")
    public @ResponseBody
    History createHistory(@PathVariable long historyId, @RequestParam String make, @RequestParam String model,
                   @RequestParam int year, @RequestParam String numberPlate,@PathVariable long invoiceID,@RequestParam String orderDate)
    {
        Map<String, String> values = new HashMap<>();
        values.put("make",make);
        values.put("model",model);
        values.put("numberPlate",numberPlate);
        values.put("orderDate",orderDate);
        invoices = invoiceService.read(invoiceID);
        history = HistoryFactory.getHistory(values, year, invoices);

        return historyService.create(history);
    }

    @CrossOrigin
    @GetMapping (path="/findHistoryItem")
    public @ResponseBody History findHistoryItem(long historyId)
    {
        return history = historyService.read(historyId);
    }

    @CrossOrigin
    @GetMapping(path = "/updateHistory")
    public
    @ResponseBody History updateHistory(@PathVariable long historyId, @RequestParam String make, @RequestParam String model,
                                @RequestParam int year, @RequestParam String numberPlate,@PathVariable long invoiceID,@RequestParam String orderDate)
    {
        invoices = invoiceService.read(invoiceID);
        history = historyService.read(historyId);
        History historyUpdate = new History.Builder()
                    .id(historyId)
                    .make(make)
                    .model(model)
                    .year(year)
                    .numberPlate(numberPlate)
                    .orderDate(orderDate)
                    .build();
        return historyService.update(historyUpdate);
    }

    @CrossOrigin
    @GetMapping(path = "/deleteHistory")
    public
    @ResponseBody
    void deleteHistory(long historyID) {
        historyService.delete(historyID);
    }

    @CrossOrigin
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<History> getAllCustomers()
    {
        return historyService.findAll();
    }

}
