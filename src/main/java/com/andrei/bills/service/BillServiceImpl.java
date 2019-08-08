package com.andrei.bills.service;

import com.andrei.bills.dao.BillDao;
import com.andrei.bills.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service("billService")
public class BillServiceImpl implements BillService {

//    @Autowired
//    private BillDao dao;

    @Override
    public List<Bill> getBills() {
        List<Bill> bill = new ArrayList<>();
        Bill myBill = new Bill();
        myBill.setBillId(1);
        myBill.setBillName("Test Bill");
        myBill.setBillAccountNumber("1234qwer");
        myBill.setBillAmountDue(20.78);
        myBill.setBillAmountPastDue(8.88);
        myBill.setBillType("Power");
//        List<Bill> billSelect = dao.selectEveryBill();
        return bill;
    }
}
