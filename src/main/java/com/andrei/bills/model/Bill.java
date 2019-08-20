package com.andrei.bills.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Bill implements Serializable {
    private int billId;
    private String billName;
    private String billAccountNumber;
    private Date billDueDate;
    private Float billAmountDue;
    private Float billAmountPastDue;
    private String billType;
    private Float billBalance;


    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillAccountNumber() {
        return billAccountNumber;
    }

    public void setBillAccountNumber(String billAccountNumber) {
        this.billAccountNumber = billAccountNumber;
    }

    public Date getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(Date billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Float getBillAmountDue() {
        return billAmountDue;
    }

    public void setBillAmountDue(Float billAmountDue) {
        this.billAmountDue = billAmountDue;
    }

    public Float getBillAmountPastDue() {
        return billAmountPastDue;
    }

    public void setBillAmountPastDue(Float billAmountPastDue) {
        this.billAmountPastDue = billAmountPastDue;
    }

    public Float getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(Float billBalance) {
        this.billBalance = billBalance;
    }

    @Override
    public String toString(){
        return "Bill{" +
                "Name = " + billName +
                ", Amount = " + billAmountDue +
                ", Due Date = " + billDueDate + "}";
    }
}
