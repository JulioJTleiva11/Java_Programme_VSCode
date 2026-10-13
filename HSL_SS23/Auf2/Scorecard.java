package HSL_SS23.Auf2;

public class Scorecard {
    private int[] scoreFields;
    private boolean[] isEmptyFields;

    public Scorecard(){
        this.scoreFields = new int[6];
        this.isEmptyFields = new boolean[6];
        this.reset();
    }

    public void reset(){
        for (int i = 0; i < 6; i ++){
            scoreFields[i] =0;
            isEmptyFields[i] = false; 
        }

    }

    public boolean isScoreFieldEmpty(int rolledNumber){
        return false;      
    }

    public int getScoreField(int rolledNumber){
        return rolledNumber;        
    }

    public void setScoreField(int rolledNumber, int numberDice){

    }

    public int getScore(){
        return 0;        
    }

    

}
