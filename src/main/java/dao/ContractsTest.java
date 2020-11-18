package dao;

import entity.BaseContract;
import entity.Client;
import entity.InternetContract;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.function.Predicate;


public class ContractsTest {
    Client client = new Client(1,1234,"Ivan Ivanov", "male", LocalDate.of(1986,1,30));
    BaseContract a = new InternetContract(1, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),1, client,100);
    BaseContract a1 = new InternetContract(2, LocalDate.of(2017,7,10),LocalDate.of(2020,7,10),2, client,100);

    @Test
    public void addContract() {
        BaseContract[] expected = new BaseContract[10];
        expected[0] = a;

        Contracts contr = Contracts.getInstance();
        contr.addContract(a);

        Assert.assertArrayEquals(expected,contr.giveContracts());
    }

    @Test
    public void delete() {
        BaseContract[] expected = new BaseContract[10];
        expected[0] = a;
        expected[0] = null;

        Contracts contr = Contracts.getInstance();
        contr.addContract(a);
        contr.delete(1);

        Assert.assertArrayEquals(expected,contr.giveContracts());
    }

    @Test
    public void find() {
        BaseContract[] b = new BaseContract[10];
        b[0] = a;
        BaseContract expected = b[0];

        Contracts contr = Contracts.getInstance();
        contr.addContract(a);
        BaseContract actual = contr.find(1);

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void bumbleSort() {
        BaseContract[] expected = new BaseContract[10];
        expected[0] = a;
        expected[1] = a1;

        BaseContractComparator.CompId compId = new BaseContractComparator.CompId();
        Contracts contr = Contracts.getInstance();
        contr.addContract(a1);
        contr.addContract(a);
        contr.bumbleSort(compId );

        Assert.assertArrayEquals(expected,contr.giveContracts());
    }

    @Test
    public void selectionSort() {
        BaseContract[] expected = new BaseContract[10];
        expected[0] = a;
        expected[1] = a1;

        BaseContractComparator.CompId compId = new BaseContractComparator.CompId();
        Contracts contr = Contracts.getInstance();
        contr.addContract(a1);
        contr.addContract(a);
        contr.selectionSort(compId);

        Assert.assertArrayEquals(expected,contr.giveContracts());
    }

    @Test
    public void findPredicate() {


        Contracts contr = Contracts.getInstance();
        contr.addContract(a1);
        contr.addContract(a);
        Predicate<BaseContract> pr = contract -> contract.getNumber() == 1;
        BaseContract actual = contr.findPredicate(pr);

        Assert.assertEquals(a,actual);
    }
}