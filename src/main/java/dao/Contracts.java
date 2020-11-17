package dao;

import entity.BaseContract;
import util.BumbleSort;
import util.ISorter;
import util.SelectionSort;

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

    private static Contracts instance;
    private  BaseContract[] contracts = new BaseContract[10];
    ISorter sorter;


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

    /*public void readCSV(BufferedReader reader){
        String line = null, type;
        Scanner scanner = null;
        int index = 0;
        while ((line = reader.readLine()) != null) {

        }

        while ((line = reader.readLine()) != null) {
            BaseContra = new Employee();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    emp.setId(Integer.parseInt(data));
                else if (index == 1)
                    emp.setName(data);
                else if (index == 2)
                    emp.setRole(data);
                else if (index == 3)
                    emp.setSalary(data);
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            empList.add(emp);
        }
    }*/

}
