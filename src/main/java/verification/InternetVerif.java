package verification;

import entity.BaseContract;
import entity.InternetContract;

public class InternetVerif extends ContractVerification {

    public BaseContract typeContract = new InternetContract();
    Message message = new Message(Status.OK);
    public Message checkContracts(InternetContract contract){
        message = super.checkContract(contract);
        checkSpeed(contract.getMaxSpeed());
        return message;
    }
    private void checkSpeed(int speed){
        if(speed < 0){
            message.setInfo("скорость не может быть отрицательной\n");
            message.setStatus(Status.Error);
            message.setFields("speed\n");
        }

    }

    @Override
    public boolean checkType(BaseContract a) {
        return a instanceof InternetContract;
    }
}
