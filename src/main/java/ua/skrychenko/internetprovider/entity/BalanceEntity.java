package ua.skrychenko.internetprovider.entity;

public class BalanceEntity {
    private int id;
    private int sum;
    private boolean status;

    public BalanceEntity(int sum, boolean status) {
        this.sum = sum;
        this.status = status;
    }

    public BalanceEntity(int id, int sum, boolean status) {
        this.id = id;
        this.sum = sum;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public boolean getStatus() {
        return status;
    }
}
