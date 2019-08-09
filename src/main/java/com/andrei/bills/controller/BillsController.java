package com.andrei.bills.controller;

import com.andrei.bills.model.Bill;
import com.andrei.bills.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillService billService;

   @Value("${welcome.message}")
   private String welcomeMessage;
    @GetMapping(value = "/")
    public List<Bill> index(){
        List<Bill> str = billService.selectEveryBill();
        System.out.println("testing sout");
        System.out.println("${jdbc.driverClassName}");
        return str;
           }

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage(){
        //List<Bill>  rrr = billService.getBills();
        return welcomeMessage+ " " + "${jdbc.driverClassName}";
   }
}
