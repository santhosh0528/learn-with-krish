package com.FuelManagemen.OrderService.Types;

public class EventSchedule {
    private String from;
    private String type;
    private String key;
    private String qty;
    private String orderId;
    private String stockId;
    private String result;
    private String date;
    private String time;

    public EventSchedule() {
    }

    public EventSchedule(String from, String type, String key, String qty, String orderId, String stockId, String result, String date, String time) {
        this.from = from;
        this.type = type;
        this.key = key;
        this.qty = qty;
        this.orderId = orderId;
        this.stockId = stockId;
        this.result = result;
        this.date = date;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EventSchedule{" +
                "from='" + from + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", qty='" + qty + '\'' +
                ", orderId='" + orderId + '\'' +
                ", stockId='" + stockId + '\'' +
                ", result='" + result + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
