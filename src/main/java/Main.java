import dao.BaseContractComparator;
import dao.CSVLoader;
import dao.Contracts;
import dao.DatabaseHandler;
import entity.BaseContract;
import entity.Client;
import entity.InternetContract;
import entity.TvContract;
import injects.Injector;
import injects.MyException;
import org.apache.commons.beanutils.BeanUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.function.Predicate;

/**
 *  Main класс, являющей точкой старта
 * @author Демченко Даниил
 */
public class Main {
    public static void main(String[] args) {

        Client client = new Client(3,1234,"dima Ivanov", "male", LocalDate.of(1986,1,30));
        BaseContract c = new BaseContract(3,3, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),client);
        BaseContract a = new InternetContract(2, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),2, client,100);
        BaseContract b = new InternetContract(1, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,100);
        BaseContract d = new TvContract(1, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,"l");
       Contracts contr = new Contracts();
       /* CSVLoader loader = new CSVLoader();
        BufferedReader reader = null;
        Injector injector = new Injector();

        try {
            injector.inject(loader.getClass());
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader(
                    "F:\\programs\\Progs\\netcracker lab\\src\\main\\resources\\test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        contr.ReadCSVWithScanner(reader);
        for(BaseContract b1 : contr.giveContracts()){
            System.out.println(b1.toString());
        }*/
       /* Predicate<BaseContract> pr = new Predicate<BaseContract>() {
            @Override
            public boolean test(BaseContract contract) {
                return contract.getNumber() == 1;
            }
        };*/
    /*
        Predicate<BaseContract> pr = contract -> contract.getNumber() == 1;
        BaseContract[] cc = contr.findPredicate(pr);*/

        contr.getDBContracts();
        for(BaseContract b1 : contr.giveContracts()){
            System.out.println(b1.toString());
        }




    }
}
