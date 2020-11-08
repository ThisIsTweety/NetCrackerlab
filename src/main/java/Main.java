import dao.Contracts;
import entity.BaseContract;
import entity.Client;
import entity.InternetContract;

import java.time.LocalDate;

/**
 *  Main класс, являющей точкой старта
 * @author Демченко Даниил
 */
public class Main {
    public static void main(String[] args) {


        Client client = new Client(1,1234,"Ivan Ivanov", "male", LocalDate.of(1986,1,30));
        BaseContract a = new InternetContract(2, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,100);
        BaseContract b = new InternetContract(1, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,100);

        Contracts contr = Contracts.getInstance();
        contr.addContract(a);
        contr.addContract(b);
        a = contr.find(1);
        System.out.println(a.getId());
        a = contr.find(2);
        System.out.println(a.getId());
        contr.bumbleSort();
        a = contr.find(1);
        System.out.println(a.getId());
        a = contr.find(2);
        System.out.println(a.getId());

    }
}
