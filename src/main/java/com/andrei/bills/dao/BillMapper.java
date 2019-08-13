package com.andrei.bills.dao;

import com.andrei.bills.model.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Mapper
public class BillMapper implements Serializable {

    @Select("SELECT\n" +
            "b.bill_id as billId,\n" +
            "       b.bill_name as billName,\n" +
            "       b.bill_account_number as billAccountNumber,\n" +
            "       b.bill_due_amount as billAmountDue,\n" +
            "       b.bill_due_date as billDueDate,\n" +
            "        b.bill_amount_past_due as billAmountPastDue,\n" +
            "       bt.bill_type_name as billType,\n" +
            "       b.bill_balance as billBalance\n" +
            "FROM bills b\n" +
            "JOIN bill_type bt ON b.bill_type_id = bt.bill_type_id")
    Bill selectAllBillsNow(){
        return new Bill();
    }

}
