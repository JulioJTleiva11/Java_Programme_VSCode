package Lab03;

public class Person {
    private String address;
    private String title;
    private String givenName;
    private String surname;
    //Erweiterung für die Änderung in der Anzeige
    private PersonView myView;

    //Methods: getter und setter
    //extra setter für myView und alle andere Setter erweitern mit myView für die Änderung in der anzeige
    public void setMyView(PersonView myView) {
        this.myView = myView;
    } 

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
        // wenn Änderung, dann repaint()
        if(myView != null){
            myView.repaint();
        }
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
        // wenn Änderung, dann repaint()
        if(myView != null){
            myView.repaint();
        }
    }
    public String getGivenName() {
        return givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
        // wenn Änderung, dann repaint()
        if(myView != null){
            myView.repaint();
        }
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
        // wenn Änderung, dann repaint()
        if(myView != null){
            myView.repaint();
        }

    }

    //Konstruktor erweitert mit myView = null
    public Person(String address, String title, String givenName, String surname) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
        this.myView = null; //Erweiterung: Änderung
    }
    

    

    
}
