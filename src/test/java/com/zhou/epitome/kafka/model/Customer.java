/**
 * Date:     2019/6/810:12
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.kafka.model;

/**
 * 2019/6/8  10:12
 * created by zhoumb
 */
public class Customer {
    private int customerID;
    private String customerName;

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
