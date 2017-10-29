package com.vehicleRental.controller;

import com.vehicleRental.domain.Customer;
import com.vehicleRental.domain.Invoices;
import com.vehicleRental.factories.InvoiceFactory;
import com.vehicleRental.services.Impl.CustomerServiceImpl;
import com.vehicleRental.services.Impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//just added to commit new changes ignore this
/**
 * Created by Vulombe on 29/10/2017.
 */
@Controller
@RequestMapping(path = "/invoice")
public class InvoiceController
{

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    InvoiceServiceImpl invoiceService;

    private Invoices invoices;

    private Customer customer;

    @CrossOrigin
    @GetMapping(path="/{customerId}/addInvoice")
    public @ResponseBody
    Invoices create(@PathVariable long customerId)
    {
        customer = customerService.read(customerId);
        invoices = InvoiceFactory.getInvoice(customer);
        return  invoiceService.create(invoices);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/findInvoice")
    public @ResponseBody
    Invoices findByCustomer (@PathVariable long customerId, @RequestParam long id)
    {
        return invoiceService.read(id);
    }

    @CrossOrigin
    @GetMapping (path="/{customerId}/updateInvoice")
    public @ResponseBody
    Invoices updateOrder (@PathVariable long customerId, @RequestParam long id) {


        invoiceService.read(id);
        Invoices invoiceUpdate = new Invoices.Builder()
                .id(id)
                .customer(customer)
                .build();

        return invoiceService.update(invoiceUpdate);
    }
    @CrossOrigin
    @GetMapping (path="/{customerId}/deleteInvoicer")
    public @ResponseBody void updateOrder (@RequestParam Long id) {
        invoiceService.delete(id);

    }
}
