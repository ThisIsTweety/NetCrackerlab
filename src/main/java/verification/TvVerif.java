package verification;

import entity.BaseContract;
import entity.InternetContract;
import entity.TvContract;

public class TvVerif extends ContractVerification implements IVerif {
    Message message = new Message(Status.OK);
    public TvContract typeContract = new TvContract();
    public Message checkContract(TvContract contract){
        message = super.checkContract(contract);
        checkTariff(contract.getTariff());
        return message;
    }
    void checkTariff(String tariff){
        if(!(tariff.equals("S") || tariff.equals("M") || tariff.equals("L"))){
            message.setInfo("Неверный тариф\n");
            message.setStatus(Status.Error);
            message.setFields("tariff\n");
        }
    }

    @Override
    public boolean checkType(BaseContract a) {
        return a instanceof TvContract;
    }
}
