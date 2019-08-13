package com.andrei.bills.service;

import com.andrei.bills.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> selectEveryBill();

    String selectString();
}
