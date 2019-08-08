package com.andrei.bills.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bill {
    private int billId;
    private String billName;
    private String billAccountNumber;
    private Date billDueDate;
    private Number billAmountDue;
    private Number billAmountPastDue;
    private String billType;
    private Number billBalance;

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

    public Number getBillAmountDue() {
        return billAmountDue;
    }

    public void setBillAmountDue(Number billAmountDue) {
        this.billAmountDue = billAmountDue;
    }

    public Number getBillAmountPastDue() {
        return billAmountPastDue;
    }

    public void setBillAmountPastDue(Number billAmountPastDue) {
        this.billAmountPastDue = billAmountPastDue;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Number getBillBalance() {
        return billBalance;
    }

    public void setBillBalance(Number billBalance) {
        this.billBalance = billBalance;
    }
}
