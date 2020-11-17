package dao;

import entity.BaseContract;

import java.util.Arrays;
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
    void addContract(BaseContract contract, BaseContract[] otherContracts){
        for(int i = 0; i < otherContracts.length; i++) {
            if (i == otherContracts.length - 1 ){
                otherContracts[i] = contract;
                otherContracts = expand(otherContracts);
                return;
            }
            if(otherContracts[i] == null){
                otherContracts[i] = contract;
                return;
            }

        }
    }
    public  void addContract(BaseContract contract){
        addContract(contract,contracts);
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
     * пузырьковая сортировка, параметр сортировки зависит от компаратора.
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

    /**
     * сортировка выбором, параметр сортировки зависит от компаратора.
     */
    public void selectionSort(){
        BaseContractComparator.CompNumber a = new BaseContractComparator.CompNumber();
        for(int left = 0; left<contracts.length; left++){
            int minInd = left;
            for(int i = left; i < contracts.length;i++) {
                if(contracts[i] != null && contracts[minInd] != null)
                 if (a.compare(contracts[i], contracts[minInd]) < 0) {
                    minInd = i;
                }
            }
            BaseContract b = contracts[left];
            contracts[left] = contracts[minInd];
            contracts[minInd] = b;
        }
    }

    /**
     * поиск объектов по предикату
     * @param predicate предикат
     * @return список объектов
     */
    public  BaseContract[] findPredicate(Predicate<BaseContract> predicate) {
        BaseContract[] contr = new BaseContract[10];
        for (BaseContract contract : contracts) {
            if (contract != null) {
                if (predicate.test(contract)) {
                    addContract(contract, contr);
                }
            }
        }
        return contr;

    }



}
