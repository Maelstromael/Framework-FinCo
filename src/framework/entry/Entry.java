package framework.entry;

import java.time.LocalDate;

public class Entry implements IEntry {
    private double amount;
    private LocalDate date;

    public Entry(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void notifyUser()
    {}
}
