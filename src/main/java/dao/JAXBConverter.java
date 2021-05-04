package dao;

import com.sun.xml.internal.ws.util.Pool;
import entity.*;

import javax.xml.bind.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JAXBConverter {


    public void clientConvert(Client client)  {
        StringWriter writer = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Client.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(client, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);
    }


    public void internetConvert(InternetContract internetContract, File file){

        StringWriter writer = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(InternetContract.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(internetContract, file);
            marshaller.marshal(internetContract, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);
    }


    public void mobileConvert(MobileContract mobileContract, File file){
        StringWriter writer = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(MobileContract.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(mobileContract, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);
    }


    public void tvConvert(TvContract tvContract, File file){
        StringWriter writer = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(TvContract.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(tvContract, writer);
            marshaller.marshal(tvContract, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);
    }

    public void allConvert(Contracts contracts, File file){
        StringWriter writer = new StringWriter();

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Contracts.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(contracts, writer);
            marshaller.marshal(contracts, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        System.out.println(result);
    }

    public void allUnConvert(File file){
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Contracts.class);
            Unmarshaller um = context.createUnmarshaller();
            Contracts contracts = (Contracts) um.unmarshal(new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8));
            for(BaseContract b : contracts.giveContracts()){
                System.out.println(b);
            }
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
