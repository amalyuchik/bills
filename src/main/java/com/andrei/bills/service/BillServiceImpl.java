package com.andrei.bills.service;

import com.andrei.bills.dao.BillDao;
import com.andrei.bills.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service("billService")
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao dao;

    @Override
    public List<Bill> selectEveryBill() {
        List<Bill> billSelect = dao.selectEveryBill();
        return billSelect;
    }

    @Override
    public String selectString() {
        return dao.selectString();
    }


}
