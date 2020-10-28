package dao;

import entity.BaseContract;

public class Contracts {
    public static BaseContract[] contracts = new BaseContract[10];
    public void addContract(BaseContract contract){
        for(int i = 0; i < contracts.length; i++) {
            if (i == contracts.length - 1){
                contracts[i] = contract;
                expand();
                return;
            }
            if(contracts[i] != null){
                contracts[i] = contract;
                return;
            }
        }
    }
    public void expand() {
        BaseContract[] newArray = new BaseContract[contracts.length + contracts.length/2];
        System.arraycopy(contracts, 0, newArray, 0, contracts.length);
        contracts = newArray;
    }
    public void delete(int id){
        for(int i = 0; i<contracts.length;i++){
            if(contracts[i].getId() == id)
                contracts[i] = null;

        }
    }
    public BaseContract find(int id){
        for (BaseContract contract : contracts) {
            if (contract.getId() == id)
                return contract;
        }
        return null;
    }
}
