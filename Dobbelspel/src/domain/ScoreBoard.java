package domain;

public class ScoreBoard {
    private int score = 0;
    private int previousThrow=0;

    public ScoreBoard() {
    }

    public void setScore(int count){
        setPreviousThrow(count);
        score = score+count*2;
        if(getPreviousThrow()==count){
            score = score+5;
        }

    }

    public void setPreviousThrow(int count){
        previousThrow = count;
    }

    public int getPreviousThrow(){
        int res = 0;
        if(previousThrow!=0){
            res = previousThrow;
        }
        return res;
    }

    public int getScore(){
        return score;
    }
}
