package verification;

import entity.BaseContract;

public interface IVerif {
    public Message checkContract(BaseContract contract);
    public boolean checkType(BaseContract a);
}
