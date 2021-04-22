package entity;

import java.time.LocalDate;

/**
 * Наследник класса BaseContract.
 */
public class TvContract extends BaseContract {
    int channels;
    String tariff;

    /**
     * Наследуемый конструктор с доп. параметрам "тариф"
     * @param id
     * @param number
     * @param start
     * @param end
     * @param client
     * @param tariff
     */
    public TvContract(int id,  LocalDate start, LocalDate end,int number, Client client, String tariff) {
        super(id, number, start, end, client);
        this.tariff = tariff;

    }

    /**
     * возвращает кол-во каналов в зависимотси от тарифа
     * @return channels.
     */
    public int getChannels() {
        if(tariff.equals("S"))
            channels = 40;
        if(tariff.equals("M"))
            channels = 100;
        if(tariff.equals("L"))
            channels = 250;
        else
            channels = 0;
        return channels;
    }

    public TvContract() {}

    /**
     * гетеры и сетеры
     */
    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "TvContract{" +
                "tariff='" + tariff + '\'' +
                '}';
    }
}
