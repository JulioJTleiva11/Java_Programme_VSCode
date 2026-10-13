package HSL_SS23.Auf2;

import java.util.Random;

public class Dice {
    private int numberDice;
    private int[] rolledNumbers;
    
    public Dice(int numberDice) {
        this.numberDice = numberDice;
        this.rolledNumbers = new int[numberDice];
        this.roll();
    }

    public int getNumberDice() {
        return numberDice;
    }

    public int getRolledNumbers(int index) {
        return this.rolledNumbers[index];
    }

    public int getNumberCount(int rolledNumber){
        int count = 0;
        for (int i= 0; i < rolledNumbers.length; i++){
            if(rolledNumbers[i] == rolledNumber){
                count++;
            }
        }

        return count;        
    }

    public void roll(){
        Random randon = new Random();

        for(int i = 0; i < this.rolledNumbers.length; i++){
            this.rolledNumbers[i] = randon.nextInt(6)+1;
        }

    }

    @Override
    public String toString() {
        String result = "";
        for ( int i = 0; i < this.rolledNumbers.length; i++){
            result += this.rolledNumbers[i];
            if(i < this.rolledNumbers.length -1){
                result += " ";
            }
        }
        return result;
    }

   

    

    

}
