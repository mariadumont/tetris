
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20482156n
 */
public class ScoreBoard extends JLabel {

    private int score;

    private int level;

    public ScoreBoard() {
        super(); //inicializamos la superclase
        score = 0;
        level = 1;

    }

    public void increment(int points) {
        score += points;
        setText("Level: " + level + " · Score: " + score);;
    }

    public void reset() {
        score = 0;
        level = 1;
        //setText("Score: " + 0);
        setText("Level: " + level + " · Score: " + 0);
    }

    public void pause() {
        setText("Paused");
    }

    public void resume() {
        //setText("Score: " + score);
        setText("Level: " + level + " · Score: " + score);
    }

    public String printScore() {
        return "Score: " + score;
    }

    public int getScore() {
        return score;
    }

    public void incrementLevel(int levelIncrement) {
        level += levelIncrement;
        setText("Level: " + level + " · Score: " + score);
    }

    public void maxLevel() {
        setText("Level: " + level + " · Score: " + score + " ¡Artista!");
    }

}
