package Aufgabe6;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class ToDoItem implements Serializable{
    //Schutzmechanismus, damit das Programm nicht abstürzt, wenn Objekte geladen werden. 
    //quasi diese Version als kompatibel mit der alten bleibt, Egal wie viel ich am Code ändere
    private static final long serialVersionUID = 1L; //feste Versionsnummer für die Serialisierung

    // 1. Private Attribute (Datenfelder) gemäß UML
    private String whatToDo;
    private String context;
    private GregorianCalendar deadline;
    private int priority;

    // 2. Konstruktor zur Initialisierung aller Attribute
    public ToDoItem(String whatToDo, String context, GregorianCalendar deadline, int priority){
        super();  //damit die andere Klasse Zugang hat zu den Attributen der Konstruktor
        this.whatToDo = whatToDo;
        this.context = context;
        this.deadline = deadline;
        this.priority = priority;
    }
    
    // 3. Getter-Methoden (notwendig für die Tabellendarstellung in Aufgabe 6)
    public String getWhatToDo(){
        return whatToDo;
    }
    public void setWhatToDo(String whatToDo){
        this.whatToDo = whatToDo;
    }

    public String getContext(){
        return context;
    }
    public void setContext(String context){
        this.context = context;
    }
    
    public GregorianCalendar getDeadline(){
        return deadline;
    }
    public void setDeadline(GregorianCalendar deadline){
        this.deadline = deadline;
    }

    public int getPriority(){
        return priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }

    // 4. Überschriebene toString()-Methode 
    @Override
    public String toString() {
        return "ToDoItem [whatToDo=" + whatToDo + ", context=" + context + ", deadline=" + deadline + ", priority="
                + priority + "]";
    }
   /*@Override
    public String toString(){
        return "Was zu tun: " + whatToDo 
                + ", Wo: " + context 
                + ", Bis wann: " + deadline
                + ", Wie wichtig: " + priority;
    }*/
}

