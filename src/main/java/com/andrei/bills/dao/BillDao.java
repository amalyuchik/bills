package com.andrei.bills.dao;

import com.andrei.bills.model.Bill;

import java.util.List;

public interface BillDao {
List<Bill> selectEveryBill();

}
