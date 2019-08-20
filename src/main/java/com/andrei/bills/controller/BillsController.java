package com.andrei.bills.controller;

import com.andrei.bills.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    private BillService billService;

   @Value("${welcome.message}")
   private String welcomeMessage;

    @GetMapping(value = "/")
    public List index() throws SQLException, IOException {
        System.out.println("testing sout");
//        List<Bill> str = new ArrayList<>();
//        //billService.selectEveryBill();
//        for (Bill bill :
//                str) {
//            bill.setBillAccountNumber(bill.getBillAccountNumber() + " - Stuff-n-Stuff-some-more-stuff");
//        }
        InputStream input = new FileInputStream("src/main/resources/application.properties");
        Properties prop = new Properties();
        prop.load(input);
        Connection con = DriverManager.getConnection
                (prop.getProperty("spring.datasource.url"), prop.getProperty("spring.datasource.username"), prop.getProperty("spring.datasource.password"));

        Statement stmt = con.createStatement();


        String sql = "SELECT b.bill_id              as billId,\n" +
                "               b.bill_name            as billName,\n" +
                "               b.bill_account_number  as billAccountNumber,\n" +
                "               b.bill_due_amount      as billAmountDue,\n" +
                "               b.bill_due_date        as billDueDate,\n" +
                "               b.bill_amount_past_due as billAmountPastDue,\n" +
                "               bt.bill_type_name      as billType,\n" +
                "               b.bill_balance         as billBalance\n" +
                "        FROM bills b\n" +
                "                 JOIN bill_type bt ON b.bill_type_id = bt.bill_type_id";

        ResultSet rs = stmt.executeQuery(sql);

        List rs2 = this.resultSetToArrayList(rs);

//        return str;
        return rs2;
           }


    public List resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList();
        while (rs.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){
                row.put(md.getColumnName(i),rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage(){
        return welcomeMessage;
   }

   @GetMapping(value = "/string")
    public String selectString()
   {
        return billService.selectString();
   }
}
