package op04Exercises;
/**
   * @author JulioJTLeiva
   * @version 1.0
   * Splits a string and joins the parts again.                     
   * @param args not used here 
   * WICHTIGCSVdateienExportierenImportierenTrennenZusammenfügenbinden             ***CSV***
   */

public class SplitJoinExample1 {

    public static void main(String[] args) {
        //1 Text in eine String-Var speicher
        String texto = "esto es-un Texto, que se diferencia?" + "Symbolos contiene!Aja.Es muy divertido.";

        //2 String-Var spliten/trennen und in Array-String speichern
        String[] partes = texto.split(" "); //mit " " trennen

        //3 Array-String mit einer For-Schleife ausgeben
        for (int i = 0; i < partes.length; i++){
            System.out.println("Parte " + i + " : >" + partes[i] + "<");
        }
        System.out.println("*****************Ab Hier Neues Trenn-Verfahren*****************");
        
        // Weitere Split-Beispiele: Split with severals symbols as separator
        partes = texto.split("[-,?!. ]");
        for(int i = 0; i < partes.length; i++){
            System.out.println("Parte Numero " + i + " : >" + partes[i] + "<");
        }
        System.out.println("*****************Ab Hier Neues Trenn-Verfahren*****************");

        //1. String-Array oder String direkt schreiben ("hola que tal..."), mit join(":", arrStringName) anbinden
    // and now join them with ":"  das Gegenteil von Split
    String j = String.join(":", partes);
    System.out.println(j);

    }

}
