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
            channels = 40;
        if(tariff.equals("M"))
            channels = 100;
        if(tariff.equals("L"))
            channels = 250;
        else
            channels = 0;
        return channels;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }
}
