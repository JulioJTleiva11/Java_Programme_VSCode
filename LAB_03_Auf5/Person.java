/*
Programm     : Person.java
Autor        : Julio Jesus Tomasto Leiva
Datum        : heute
Beschreibung : 
*/
package LAB_03_Auf5;

public class Person {
    //Atributte
    private String address;
    private String title;
    private String givenName;
    private String surname;
    private Integer day;
    private String month;
    private Integer year;
    private PersonView myView;

    //Getter setter
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
        if(myView != null){
            myView.repaint();
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
        if(myView != null){
            myView.repaint();
        }
    }
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
        if(myView != null){
            myView.repaint();
        }
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
        if(myView != null){
            myView.repaint();
        }
    }
    public Integer getDay(){
        return day;
    }
    public void setDay(Integer day){
        this.day = day;
        if(myView != null){
            myView.repaint();
        }
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
        if(myView!=null){
            myView.repaint();
        }
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
        if(myView!=null){
            myView.repaint();
        }
    }
    public void setMyView(PersonView myView){
        this.myView = myView;
    }

    //Konstruktor 1
    public Person(String address, String title, String givenName, String surname) {
        this(address, title, givenName, surname, 8, "Oktober", 1949); // Ruft den Konstruktor darunter auf       
    }
    //Konstruktor 2
    public Person(String address, String title, String givenName, String surname, 
        Integer day, String month, Integer year) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
        this.day = (day != null) ? day : 1; // Schutz vor null-Werten
        this.month = (month != null) ? month : "Januar";
        this.year = (year != null) ? year : 2000;
        this.myView = null;
    }

}
