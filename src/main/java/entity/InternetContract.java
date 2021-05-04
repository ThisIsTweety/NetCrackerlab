package entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * наследник класса BaseContract
 */
@XmlType(name = "internetContract")
@XmlRootElement
public class InternetContract extends BaseContract {
    int maxSpeed;

    /**
     * наследует конструктор родителя с дополнительным параметром "максимальная скорость"
     * @param id
     * @param start
     * @param end
     * @param number
     * @param client
     * @param maxSpeed
     */
    public InternetContract(int id, LocalDate start, LocalDate end,int number, Client client, int maxSpeed){
        super(id, number, start, end, client);
        this.maxSpeed = maxSpeed;
    }
    public InternetContract(){}

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "InternetContract{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}
