package op02Exercises;

import java.util.Iterator;

public class ListStruktur {
    //Attribute
    private Element kopf;
    private Element ende;

    //static innere Klasse
    private static class Element {
        private Object obj; //obj ist jeder Neuer für die Liste
        private Element next; //
    }

    //Methods: hinzufügen add()
    public void add(Object obj){
        if(obj == null) {
            return; // ignore nulls
        }        
        //neues Element erzeugen
        Element elementToAdd = new Element(); //ein element zum hinzufügen
        
        //wert von obj zu den Element übergeben
        elementToAdd.obj = obj; //jeder Neuer obj ist ein ein element zum hinzufügen, also elementToAdd.obj 

        //positionzuweisung in der Liste für kopf und Ende
        if(kopf == null){  //liste leer?
            //kopf und Ende sind das elementToAdd  WichtigListKopfEnde
            kopf = elementToAdd;
            ende = elementToAdd;
        }
        else{
            ende.next = elementToAdd;
            ende = elementToAdd;
        }
    }
    
    //Iterator für die Iteraktion der Liste
    public Iterator<Object> iterator() { //iterator() methode in einer Klasse

        class ListIterator implements Iterator<Object>{  //Lokale Klasse
            private Element current = kopf;

            @Override
            public boolean hasNext() {
                // return wenn current != null ist, dann gibt es den nächsten
                return current != null;//return solange ein neues Element nicht null ist
            }
            
            

            @Override
            public Object next() {
                if(current == null) return null; //sicherung falls keiner da ist

                Object toReturn = current.obj;  //referenz merken Object/Element to return ist toReturn 
                current = current.next; //dann zum nächsten Object

                return toReturn;
            }

        }  
        
        return new ListIterator();//baue einen Iterator für die List
    }

}





