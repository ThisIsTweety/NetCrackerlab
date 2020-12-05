package verification;

import entity.BaseContract;
import entity.InternetContract;
import entity.MobileContract;
import entity.TvContract;

public class MobileVerif extends ContractVerification  {
    public MobileContract typeContract = new MobileContract();
    Message message = new Message(Status.OK);
    public Message checkContract(TvContract contract){
        message = super.checkContract(contract);

        return message;
    }
    private void checkMinutes(int minutes){
        if(minutes < 0){
            message.setInfo("Минуты не могут быть отрицательными\n");
            message.setStatus(Status.Error);
            message.setFields("minutes\n");
        }
    }
    private void checkSms(int sms){
        if(sms < 0){
            message.setInfo("Sms не могут быть отрицательными\n");
            message.setStatus(Status.Error);
            message.setFields("sms\n");
        }
    }
    private void checkGb(int Gb){
        if(Gb < 0){
            message.setInfo("Gb не могут быть отрицательными\n");
            message.setStatus(Status.Error);
            message.setFields("gb\n");
        }
    }

    @Override
    public boolean checkType(BaseContract a) {
        return a instanceof MobileContract;
    }
}
