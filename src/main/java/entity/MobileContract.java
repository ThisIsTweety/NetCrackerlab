package entity;

import java.time.LocalDate;

/**
 * наследник класса BaseContract
 */
public class MobileContract extends BaseContract {
    int minutes, sms, gb;

    /**
     * Наследуемый Конструктор родителя с доп. параметрами: минуты, смс, гб
     * @param id
     * @param start
     * @param end
     * @param number
     * @param client
     * @param minutes
     * @param sms
     * @param gb
     */
    public MobileContract(int id, LocalDate start, LocalDate end, int number, Client client, int minutes, int sms, int gb) {
        super(id, number, start, end, client);
        this.minutes = minutes;
        this.sms = sms;
        this.gb = gb;
    }

    public MobileContract(){}

    /**
     * гетеры и сетеры.
     */
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }
}
