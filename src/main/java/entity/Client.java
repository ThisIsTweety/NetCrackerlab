package entity;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Client {
    int id, passport;
    String FullName, gender;
    LocaleData DOB;

    public Client(int id, int passport, String fullName, String gender, LocaleData DOB) {
        this.id = id;
        this.passport = passport;
        FullName = fullName;
        this.gender = gender;
        this.DOB = DOB;
    }

    public int getId() {
        return id;
    }

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

    public LocaleData getDOB() {
        return DOB;
    }

    public void setDOB(LocaleData DOB) {
        this.DOB = DOB;
    }
    public  int calculateAge(LocalDate birthDate) {

        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
