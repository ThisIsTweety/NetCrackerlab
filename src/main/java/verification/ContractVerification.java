package verification;

import entity.BaseContract;
import entity.InternetContract;

import java.time.LocalDate;

public abstract class ContractVerification  {
    String info, fields;

    Message message = new Message(Status.OK);


    public Message checkContract(BaseContract contract) {
        checkId(contract.getId());
        checkNumber(contract.getNumber());
        checkDate(contract.getStart(), contract.getEnd());
        return message;
    }

    private void checkId(int id) {
        if (id == 0) {
            message.setInfo(" Неверное id, укажите id\n ");
            message.setStatus(Status.Error);
            message.setFields("id\n");
        }
        if (id < 0) {
            message.setInfo("Неккоректный id\n");
            message.setStatus(Status.Error);
            message.setFields("id\n");
        }
    }

    private void checkNumber(int number) {
        if (number < 0) {
            message.setInfo("Номер не может быть отрицательным\n");
            message.setStatus(Status.Error);
            message.setFields("number\n");
        }
    }

    private void checkDate(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            message.setInfo("Начало контракта должно быть раньше конца контракта\n");
            message.setStatus(Status.Error);
            message.setFields("start, end\n");
        }
        if (end.isBefore(LocalDate.now())) {
            message.setInfo("Контракт истек");
            if (message.getStatus() == Status.OK) message.setStatus(Status.Warning);
            message.setFields("end \n");
        }
    }

}


