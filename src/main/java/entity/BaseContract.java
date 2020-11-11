package entity;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Calendar;
/**
 * Класс родитель контрактов со свойствами <b>id</b>, <b>number</b>, <b>start</b>, <b>end</b> и объектом класса "клиент" <b>client</b>.
 */
public class BaseContract {
    int id, number;
    LocalDate start, end;
    public Client client;

    /**
     * конструктор с параметрами:
     * @param id
     * @param number номер контаркта
     * @param start начало контракта
     * @param end окончани контракта
     * @param client клиет
     */
    public BaseContract(int id, int number, LocalDate start, LocalDate end, Client client) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.number = number;
        this.client = client;
    }

    @Override
    public String toString() {
        return "BaseContract{" +
                "id=" + id +
                ", number=" + number +
                ", start=" + start +
                ", end=" + end +
                ", client=" + client +
                '}';
    }

    /**
     * get и set параметров класса
     */
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
