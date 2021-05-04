package entity;

import sun.util.resources.LocaleData;
import util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

/**
 * сущность "Клиент"
 */
@XmlType(name = "client")
@XmlRootElement
public class Client {

    int id, passport;
    String FullName, gender;

    LocalDate DOB;

    /**
     * конструктор с параметрами класса:
     * @param id
     * @param passport пасспорт
     * @param fullName ФИО
     * @param gender пол
     * @param DOB дата рождения
     */
    public Client(int id, int passport, String fullName, String gender, LocalDate DOB) {
        this.id = id;
        this.passport = passport;
        FullName = fullName;
        this.gender = gender;
        this.DOB = DOB;
    }

    public Client() { }

    /**
     * get и set параметров.
     */
    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return DOB;
    }
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", passport=" + passport +
                ", FullName='" + FullName + '\'' +
                ", gender='" + gender + '\'' +
                ", DOB=" + DOB +
                '}';
    }

    /**
     * метод вычисляющий возраст клиента
     * @param birthDate входящий параметр дата рождения
     * @return возвращает возраст.
     */
    public  int calculateAge(LocalDate birthDate) {

        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
