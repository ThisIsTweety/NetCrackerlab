package entity;

import java.time.LocalDate;

public class TvContract extends BaseContract {
    int channels;
    String tariff;

    public TvContract(int id, int number, LocalDate start, LocalDate end, Client client, int channels, String tariff) {
        super(id, number, start, end, client);
        this.channels = channels;
        this.tariff = tariff;
    }

    public int getChannels() {
        if(tariff.equals("S"))
            return 40;
        if(tariff.equals("M"))
            return 100;
        if(tariff.equals("L"))
            return 250;
        else
            return 0;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }
}
