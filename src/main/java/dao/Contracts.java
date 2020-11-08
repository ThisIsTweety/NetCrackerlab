package dao;

import entity.BaseContract;

import java.util.function.Predicate;

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
//    public BaseContract[] findAll(BaseContract contract) {
//        BaseContract[] contr = new BaseContract[10];
//        Predicate<Integer> numberChek = i -> contract.getNumber() == i;
//        for (BaseContract b:contracts) {
//            if(numberChek.test(b.getNumber())){
//                contr
//            }
//        }
//
//
//    }

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
                contracts = expand(contracts);
                return;
            }
            if(contracts[i] == null){
                contracts[i] = contract;
                return;
            }

        }
    }

    /**
     * возвращает массик контрактов
     * @return contracts
     */
    public BaseContract[] giveContracts(){
        return contracts;
    }

    /**
     * Расширает массив контрактов в 2 раза, если он заполнится
     */
    BaseContract[] expand(BaseContract[] contr) {
        BaseContract[] newArray = new BaseContract[contr.length + contr.length/2];
        System.arraycopy(contr, 0, newArray, 0, contr.length);
        return newArray;
    }

    /**
     * Удаляет контрак по id.
     * @param id
     */
    public void delete(int id){
        for(int i = 0; i<contracts.length;i++){
            if(contracts[i].getId() == id) {
                contracts[i] = null;
                for(int j = i+1;j<contracts.length;j++)
                    contracts[j-1] = contracts[j];
            }
                return;
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

    /**
     * пузырьковая сортировка, параметр зависит от компаратора.
     */
    public void bumbleSort(){
        BaseContractComparator.CompId a = new BaseContractComparator.CompId();
        for(int i=0;i<contracts.length;i++)
            for(int j = 0; j<contracts.length-1-i;j++)
                if(contracts[j+1] != null)
                  if(a.compare(contracts[j],contracts[j+1])>0 ){
                    BaseContract b = contracts[j];
                    contracts[j] = contracts[j+1];
                    contracts[j+1] = b;
                }
    }
}
