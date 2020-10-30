package dao;

import entity.BaseContract;

/**
 * класс репозиторий, хранящий все контракты.
 */
public class Contracts {
    /**
     * свойства:
     * instance для реализации патерна singleton
     * Массив контрактов
     */
    private static Contracts instance;
    private  BaseContract[] contracts = new BaseContract[10];

    /**
     * Возвращает единственный объект
     * @return instance
     */
    public static Contracts getInstance(){
        if(instance == null){
            instance = new Contracts();
        }
        return instance;
    }

    /**
     * Добавляет в массив новый контракт
     * @param contract входящий парметр контракт.
     */
    public  void addContract(BaseContract contract){
        for(int i = 0; i < contracts.length; i++) {
            if (i == contracts.length - 1 ){
                contracts[i] = contract;
                expand();

                return;
            }
            if(contracts[i] == null){
                contracts[i] = contract;
                return;
            }

        }
    }

    /**
     * Расширает массив контрактов в 2 раза, если он заполнится
     */
    public  void expand() {
        BaseContract[] newArray = new BaseContract[contracts.length + contracts.length/2];
        System.arraycopy(contracts, 0, newArray, 0, contracts.length);
        contracts = newArray;
    }

    /**
     * Удаляет контрак по id.
     * @param id
     */
    public void delete(int id){
        for(int i = 0; i<contracts.length;i++){
            if(contracts[i].getId() == id)
                contracts[i] = null;

        }
    }

    /**
     * ищет контракт по id
     * @param id
     * @return возвращает контракт
     */
    public BaseContract find(int id){
        for (BaseContract contract : contracts) {
            if (contract.getId() == id)
                return contract;
        }
        return null;
    }
}
