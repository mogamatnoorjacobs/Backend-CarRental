package com.vehicleRental.controller;

import com.vehicleRental.domain.History;
import com.vehicleRental.domain.Invoices;
import com.vehicleRental.domain.Rent;
import com.vehicleRental.factories.HistoryFactory;
import com.vehicleRental.services.Impl.HistoryServiceImpl;
import com.vehicleRental.services.Impl.InvoiceServiceImpl;
import com.vehicleRental.services.Impl.RentServiceImpl;
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
    private Rent rent;

    @Autowired
    private HistoryServiceImpl historyService;

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Autowired
    private RentServiceImpl rentService;

    @CrossOrigin
    @PostMapping(path="/{invoiceId}/{rentId}/addHistory")
    public @ResponseBody
    History createHistory(@PathVariable long invoiceId,@PathVariable long rentId, boolean rented, boolean outstanding)
    {
        Map<String, Boolean> values = new HashMap<>();
        values.put("rented",rented);
        values.put("outstanding",outstanding);

        invoices = invoiceService.read(invoiceId);
        rent = rentService.read(rentId);
        history = HistoryFactory.getHistory(values,rent, invoices );

        return historyService.create(history);
    }

    @CrossOrigin
    @GetMapping (path="/findHistoryItem")
    public @ResponseBody History findHistoryItem(long historyId)
    {
        return historyService.read(historyId);
    }

    @CrossOrigin
    @PostMapping(path = "/{invoiceId}/{rentId}/updateHistory")
    public
    @ResponseBody History updateHistory(@PathVariable long invoiceId,@PathVariable long rentId,@RequestParam long id, boolean rented, boolean outstanding)
    {
        invoices = invoiceService.read(invoiceId);
        rent = rentService.read(rentId);
        History historyUpdate = new History.Builder()
                    .id(id)
                    .invoices(invoices)
                    .rent(rent)
                    .rented(rented)
                    .outstanding(outstanding)
                    .build();
        return historyService.update(historyUpdate);
    }

    @CrossOrigin
    @DeleteMapping(path = "/deleteHistory")
    public
    @ResponseBody
    void deleteHistory(long historyID) {
        historyService.delete(historyID);
    }

    @CrossOrigin
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<History> getAllRentals()
    {
        return historyService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{invoiceId}/findAllRentalBasedInvoice")
    public @ResponseBody History getAllBasedOnInvoice(@PathVariable long invoiceId)
    {

        return historyService.read(invoiceId);
    }

}
