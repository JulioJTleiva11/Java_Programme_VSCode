package op02Exercises;



public class InnereStaticKlasseList {

    //Attribute Felder
    //Element wird zu einer static innere Klasse erstellt
    private Element head;  //kopf der Liste
    private Element tail;  //Ende der Liste

    //STATISCHE INNERE KLASSE ELEMENT   
    //die Klasse List hat zugriff auf Element, hier wird die Liste strukturiert
    private static class Element { //niemand von aussen hat Zugang zu Element, nur List bzw. Zugriff nur über List 
        //Felder/Attribute
        private Object obj; //Object ist allgemeinsteKLasse, die oberKlasse von allen,in Object kann man alles speichern
        private Element next; //Referenz auf nächsten element
    }

    //Methods: hinzufügen irgendeinen Object in die Warteliste
    public void add(Object obj){ //irgendeinen Object hinzufügen
        if (obj == null){  //ignoriere nulls
            return;
        }
        //element erzeugen aus der innereKlasse Element
        Element elementToAdd = new Element(); //neues Object für die Liste
        elementToAdd.obj = obj;  //  erstes Object 
        elementToAdd.next = null;

        //wenn die List leer ist, ist keiner der next oder letzte
        //tail.next = elementToAdd;
        if(head == null){  //wenn die ListenKopf leer ist, also leere List
            head = elementToAdd; //
            tail = elementToAdd;
            //head = tail = elementToAdd; //es gibt nur ein Element, also Kopf=Ende=Elementhinzugefügt 
        }
        else { //wenn ein zweites element dazu kommt
            tail.next = elementToAdd; //tail ist nicht der letzte, 
            tail = elementToAdd; //sondern elementToAdd ist jetzt der letzte
        }



    }


}
