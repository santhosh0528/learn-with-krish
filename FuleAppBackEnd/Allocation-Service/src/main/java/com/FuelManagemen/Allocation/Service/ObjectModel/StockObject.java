package com.FuelManagemen.Allocation.Service.ObjectModel;

public class StockObject {
    private int stockId;
    private String type;
    private double availableStock;
    private double progress;

    public StockObject(int stockId, String type, double availableStock, double progress) {
        this.stockId = stockId;
        this.type = type;
        this.availableStock = availableStock;
        this.progress = progress;
    }

    public StockObject() {
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(double availableStock) {
        this.availableStock = availableStock;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
