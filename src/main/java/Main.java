import dao.Contracts;
import entity.BaseContract;
import entity.Client;
import entity.InternetContract;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 *  Main класс, являющей точкой старта
 * @author Демченко Даниил
 */
public class Main {
    public static void main(String[] args) {


        Client client = new Client(1,1234,"Ivan Ivanov", "male", LocalDate.of(1986,1,30));
        BaseContract a = new InternetContract(2, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,100);
        BaseContract b = new InternetContract(1, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),2, client,100);

        Contracts contr = Contracts.getInstance();
        contr.addContract(a);
        contr.addContract(b);

       /* Predicate<BaseContract> pr = new Predicate<BaseContract>() {
            @Override
            public boolean test(BaseContract contract) {
                return contract.getNumber() == 1;
            }
        };*/
        contr.bumbleSort();
        Predicate<BaseContract> pr = contract -> contract.getNumber() == 1;
        BaseContract[] cc = contr.findPredicate(pr);
        for(BaseContract b1 : cc){
            System.out.println(b1.toString());
        }

    }
}
