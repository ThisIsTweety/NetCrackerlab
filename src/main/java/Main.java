import dao.*;
import entity.BaseContract;
import entity.Client;
import entity.InternetContract;
import entity.TvContract;

import java.io.File;
import java.time.LocalDate;

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

    /*    contr.getDBContracts();
        for(BaseContract b1 : contr.giveContracts()){
            System.out.println(b1.toString());
        }*/
        contr.addContract(a);
        contr.addContract(d);
        File file = new File("file.xml");
        JAXBConverter jaxbConverter = new JAXBConverter();
        /*jaxbConverter.tvConvert((TvContract) d, file);
        jaxbConverter.internetConvert((InternetContract) a, file);*/
        jaxbConverter.allConvert(contr,file);
        jaxbConverter.allUnConvert(file);


    }
}
