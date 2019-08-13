package com.andrei.bills.dao;

import com.andrei.bills.model.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BillDao {
List<Bill> selectEveryBill();
String selectString();
}
