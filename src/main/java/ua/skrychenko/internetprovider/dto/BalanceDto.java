package ua.skrychenko.internetprovider.dto;

public class BalanceDto {

    private int id;
    private int sum;
    private boolean status;


    public BalanceDto(int id, int sum, boolean status) {
        this.id = id;
        this.sum = sum;
        this.status = status;
    }

    public BalanceDto(int sum, boolean status) {
        this.sum = sum;
        this.status = status;
    }

    public BalanceDto() {
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

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "" + sum + " Uah";
    }
}