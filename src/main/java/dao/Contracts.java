package dao;

import entity.BaseContract;
import injects.AutoInjectable;
import util.BumbleSort;
import util.ISorter;
import util.SelectionSort;

import java.io.BufferedReader;
import java.util.Comparator;
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


    private  BaseContract[] contracts = new BaseContract[10];
    @AutoInjectable
    ISorter sorter;




    /**
     * Добавляет в массив новый контракт
     * @param contract входящий парметр контракт.
     */
    private void addContract(BaseContract contract, BaseContract[] otherContracts){
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
     * возвращает массив контрактов
     * @return contracts
     */
    public BaseContract[] giveContracts(){
        return contracts;
    }

    /**
     * Расширает массив контрактов в половину его размера, если он заполнится
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
    public void bumbleSort(Comparator a){
        sorter = new BumbleSort();
        sorter.sort(contracts,a);
    }

    /**
     * сортировка выбором, параметр сортировки зависит от компаратора.
     */
    public void selectionSort(Comparator a){
        sorter = new SelectionSort();
        sorter.sort(contracts,a);
    }

    /**
     * поиск объектов по предикату
     * @param predicate предикат
     * @return список объектов
     */
    public  BaseContract findPredicate(Predicate<BaseContract> predicate) {
        BaseContract contr = null;
        for (BaseContract contract : contracts) {
            if (contract != null) {
                if (predicate.test(contract)) {
                    contr = contract;
                    return contr;
                }
            }
        }
        return contr;

    }

    /**
     * вызывает метод для чтение и записи csv файла
     * @param reader файл для чтений
     */
    public void ReadCSVWithScanner(BufferedReader reader){
        CSVLoader loader = new CSVLoader();
        loader.readCSV(reader,this);
    }

}
