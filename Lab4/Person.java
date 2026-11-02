package Lab4;

import java.time.LocalDate;

public class Person {
    //Attrib
    private String address;
    private String title;
    private String givenName;
    private String surname;
    private LocalDate birthday;

    //Getter und setter
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    //Konstruktor
    public Person(String address, String title, String givenName, String surname) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
    }
    public Person(String address, String title, String givenName, String surname, LocalDate birthday) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
        this.birthday = birthday;
    }

    

    
    

}
