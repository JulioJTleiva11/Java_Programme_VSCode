package Auf6neu;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class ToDoItem implements Serializable { //mit Serializable, da lesen und zugreifen?
    //Atrib.
    private String whatToDo;
    private String context; 
    private GregorianCalendar deadline;
    private int priority;

    //Konstru. mit Super()
    public ToDoItem (String whatToDo, String context, GregorianCalendar deadline, int priority){
        super();
        this.whatToDo = whatToDo;
        this.context = context;
        this.deadline = deadline;
        this.priority = priority;
    }

    //getter und setter
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

    //überschriebene ToString methode
    @Override
    public String toString(){
        return whatToDo 
                + "@ " + context 
                + "until " + deadline 
                + "with Priority " + priority;
    }



}
