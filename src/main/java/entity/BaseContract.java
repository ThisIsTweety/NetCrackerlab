package entity;

import sun.util.resources.LocaleData;
import util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Calendar;
/**
 * Класс родитель контрактов со свойствами <b>id</b>, <b>number</b>, <b>start</b>, <b>end</b> и объектом класса "клиент" <b>client</b>.
 */
@XmlType(name = "baseContract")
@XmlRootElement
public class BaseContract {
    int id, number;
    LocalDate start, end;
    Client client;

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
    public BaseContract(){}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setStart(LocalDate start) {
        this.start = start;
    }
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setEnd(LocalDate end) {
        this.end = end;
    }
    @XmlAttribute
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
