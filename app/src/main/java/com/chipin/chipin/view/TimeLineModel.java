package com.chipin.chipin.view;

public class TimeLineModel {
    String message;
    OrderStatus orderStatus;
    String date;

    public TimeLineModel()
    {

    }

    public TimeLineModel(String message, OrderStatus orderStatus, String date) {
        this.message = message;
        this.orderStatus = orderStatus;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
