package entity;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Calendar;

public class BaseContract {
    int id, number;
    LocalDate start, end;
    public Client client;
    public BaseContract(int id, int number, LocalDate start, LocalDate end, Client client) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.number = number;
        this.client = client;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
