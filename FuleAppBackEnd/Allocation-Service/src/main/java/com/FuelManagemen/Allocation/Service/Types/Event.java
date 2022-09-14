package com.FuelManagemen.Allocation.Service.Types;

public class Event {

    private String from;
    private String type;
    private String key;
    private String qty;
    private String orderId;
    private String stockId;
    private String result;

    public Event(String from, String type, String key, String qty, String orderId, String stockId, String result) {
        this.from = from;
        this.type = type;
        this.key = key;
        this.qty = qty;
        this.orderId = orderId;
        this.stockId = stockId;
        this.result = result;
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

    @Override
    public String toString() {
        return "Event{" +
                "from='" + from + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", qty='" + qty + '\'' +
                ", orderId='" + orderId + '\'' +
                ", stockId='" + stockId + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
