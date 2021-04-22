package dao;

import entity.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class DatabaseHandler {
    ;
    static final String DB_URL = "jdbc:postgresql://localhost:5432/netcracker";
    static final String USER = "postgres";
    static final String PASS = "danya54321";

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }
    public Client getClient(int id){
        Client client;
        String select = "SELECT * FROM "+ ConstDb.ClientTable +" WHERE " + ConstDb.ClientId + "=" + id;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                client = new Client();
                client.setId(resultSet.getInt(1));
                client.setPassport(resultSet.getInt(2));
                client.setFullName(resultSet.getString(3));
                client.setGender(resultSet.getString(4));
                client.setDOB(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(5))));
                return client;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        client = null;
        return client;
    }
    public void signUpClient(Client client) {
        if (getClient(client.getId()) !=null) {
            String insert = "INSERT INTO " + ConstDb.ClientTable + "(" + ConstDb.ClientId + "," + ConstDb.ClientPassport
                    + "," + ConstDb.ClientFullName + "," + ConstDb.ClientGender + "," + ConstDb.ClientDOB + ")"
                    + "VALUES(?,?,?,?,?)";

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setInt(1, client.getId());
                prSt.setInt(2, client.getPassport());
                prSt.setString(3, client.getFullName());
                prSt.setString(4, client.getGender());
                prSt.setDate(5, Date.valueOf(client.getDOB()));
                prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void getInternetContracts(Contracts contracts){
        String select = "SELECT * FROM " + ConstDb.InternetTable;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int idClient;
                BaseContract baseContract = new InternetContract();
                baseContract.setId(resultSet.getInt(1));
                baseContract.setStart(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(2))));
                baseContract.setEnd(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(3))));
                baseContract.setNumber(resultSet.getInt(4));
                idClient = resultSet.getInt(5);
                baseContract.setClient(getClient(idClient));
                ((InternetContract) baseContract).setMaxSpeed(resultSet.getInt(6));
                contracts.addContract(baseContract);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void getTVContracts(Contracts contracts){
        String select = "SELECT * FROM " + ConstDb.TvTable;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int idClient;
                BaseContract baseContract = new TvContract();
                baseContract.setId(resultSet.getInt(1));
                baseContract.setStart(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(2))));
                baseContract.setEnd(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(3))));
                baseContract.setNumber(resultSet.getInt(4));
                idClient = resultSet.getInt(5);
                baseContract.setClient(getClient(idClient));
                ((TvContract) baseContract).setTariff(resultSet.getString(6));
                contracts.addContract(baseContract);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void getMobileContracts(Contracts contracts){
        String select = "SELECT * FROM " + ConstDb.MobileTable;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int idClient;
                BaseContract baseContract = new MobileContract();
                baseContract.setId(resultSet.getInt(1));
                baseContract.setStart(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(2))));
                baseContract.setEnd(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate(3))));
                baseContract.setNumber(resultSet.getInt(4));
                idClient = resultSet.getInt(5);
                baseContract.setClient(getClient(idClient));
                ((MobileContract) baseContract).setSms(resultSet.getInt(6));
                ((MobileContract) baseContract).setMinutes(resultSet.getInt(7));
                ((MobileContract) baseContract).setGb(resultSet.getInt(8));
                contracts.addContract(baseContract);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void signUpInternetContract(InternetContract internetContract) {
        String insert = "INSERT INTO " + ConstDb.InternetTable + "(" + ConstDb.BaseId + "," + ConstDb.BaseStart
                + "," + ConstDb.BaseEnd + "," + ConstDb.BaseNumber + ","  +ConstDb.BaseIdClient + "," + ConstDb.InternetSpeed + ")"
                + "VALUES(?,?,?,?,?,?)";

        Client client = internetContract.getClient();
        try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)){

            prSt.setInt(1, internetContract.getId());
            prSt.setDate(2, Date.valueOf(internetContract.getStart()));
            prSt.setDate(3,  Date.valueOf(internetContract.getEnd()));
            prSt.setInt(4, internetContract.getNumber());
            prSt.setInt(5, client.getId());
            prSt.setInt(6, internetContract.getMaxSpeed());
            prSt.executeUpdate();
            signUpClient(client);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void signUpTvContract(TvContract tvContract) {
        String insert = "INSERT INTO " + ConstDb.TvTable + "(" + ConstDb.BaseId + "," + ConstDb.BaseStart
                + "," + ConstDb.BaseEnd + "," + ConstDb.BaseNumber + ","  +ConstDb.BaseIdClient + "," + ConstDb.TvTarif + ")"
                + "VALUES(?,?,?,?,?,?)";

        Client client = tvContract.getClient();
        try(PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

            prSt.setInt(1, tvContract.getId());
            prSt.setDate(2, Date.valueOf(tvContract.getStart()));
            prSt.setDate(3,  Date.valueOf(tvContract.getEnd()));
            prSt.setInt(4, tvContract.getNumber());
            prSt.setInt(5, client.getId());
            prSt.setString(6, tvContract.getTariff());
            prSt.executeUpdate();
            signUpClient(client);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void signUpMobileContract(MobileContract mobileContract) {
        String insert = "INSERT INTO " + ConstDb.MobileTable + "(" + ConstDb.BaseId + "," + ConstDb.BaseStart
                + "," + ConstDb.BaseEnd + "," + ConstDb.BaseNumber + ","  +ConstDb.BaseIdClient + "," + ConstDb.MobileSms + "," + ConstDb.MobileMinutes
                + "," + ConstDb.MobileGb + ")" + "VALUES(?,?,?,?,?,?)";

        Client client = mobileContract.getClient();
        try(PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

            prSt.setInt(1, mobileContract.getId());
            prSt.setDate(2, Date.valueOf(mobileContract.getStart()));
            prSt.setDate(3,  Date.valueOf(mobileContract.getEnd()));
            prSt.setInt(4, mobileContract.getNumber());
            prSt.setInt(5, client.getId());
            prSt.setInt(8, mobileContract.getGb());
            prSt.setInt(7, mobileContract.getMinutes());
            prSt.setInt(6, mobileContract.getSms());

            prSt.executeUpdate();
            signUpClient(client);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
