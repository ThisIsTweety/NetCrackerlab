package dao;

import entity.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CSVLoader {
    public void readCSV(BufferedReader reader, Contracts contracts){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        String line = null;
        Scanner scanner = null;
        int index = 0;
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            BaseContract baseContract = new BaseContract();
            Client client = new Client();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    baseContract.setId(Integer.parseInt(data));
                else if (index == 1)
                    baseContract.setNumber(Integer.parseInt(data));
                else if (index == 2)
                    baseContract.setStart(LocalDate.parse(data,formatter));
                else if (index == 3)
                    baseContract.setEnd(LocalDate.parse(data,formatter));
                else if (index == 4)
                    client.setId(Integer.parseInt(data));
                else if (index == 5)
                    client.setPassport(Integer.parseInt(data));
                else if (index == 6)
                    client.setDOB(LocalDate.parse(data,formatter));
                else if (index == 7)
                    client.setFullName(data);
                else if (index == 8) {
                    baseContract.setClient(client);
                    baseContract = typeContract(baseContract,data);
                    if(baseContract.getClient()== null)
                        System.out.println("неверный тип контракта");
                }
                else if (index == 9) {
                    if (baseContract instanceof InternetContract) {
                        ((InternetContract) baseContract).setMaxSpeed(Integer.parseInt(data));
                    }
                    if(baseContract instanceof TvContract) {
                        ((TvContract) baseContract).setTariff(data);
                    }
                    if(baseContract instanceof MobileContract) {
                        String[] spl = data.split(",");
                        if(spl.length == 3){
                            ((MobileContract) baseContract).setMinutes(Integer.parseInt(spl[0]));
                            ((MobileContract) baseContract).setGb(Integer.parseInt(spl[1]));
                            ((MobileContract) baseContract).setSms(Integer.parseInt(spl[2]));
                        }
                        else
                            System.out.println("неверная доп информация");
                    }
                }
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            contracts.addContract(baseContract);
            index = 0;

        }
        checkClient(contracts);
    }

    public BaseContract typeContract(BaseContract contract,String type){
        BaseContract baseContract ;
        if (type.equals("internet"))
        {
            baseContract = new InternetContract();
            try {
                BeanUtils.copyProperties(baseContract, contract);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return baseContract;
        }
        if(type.equals("TV")) {
            baseContract = new TvContract();
            try {
                BeanUtils.copyProperties(baseContract, contract);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return baseContract;
        }
        if(type.equals("mobile"))
            {
                baseContract = new MobileContract();
                try {
                    BeanUtils.copyProperties(baseContract, contract);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                return baseContract;
            }
            else {
            baseContract = new BaseContract();
        }
        return baseContract;
    }

    public void checkClient(Contracts contracts){
        for(BaseContract contract : contracts.giveContracts()){
            for(BaseContract contract1 : contracts.giveContracts()){
                if(contract != null && contract1 != null)
                  if(contract.getClient().getId() == contract1.getClient().getId())
                     contract1.setClient(contract.getClient());
            }
        }
    }
}
