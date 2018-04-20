
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

    String[] sentences = {"¡Artista!", "¡Ole tu!", "¡Toma geroma!"};

    public ScoreBoard() {
        super(); //inicializamos la superclase
        score = 0;
        level = 1;

    }

    public void increment(int points) {
        score += points;

        if (score % 5 == 0) {
            level++;
        }

        setText("Level: " + level + " · Score: " + score);

        if (score >= 10) {
            setText("Level: " + level + " · Score: " + score + " " + getSentence());
        }
    }

    public void reset() {
        score = 0;
        level = 1;

        setText("Level: " + level + " · Score: " + score);
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

    public String getSentence() {
        String s = "";
        int num = (int) (Math.random() * sentences.length);

        s = sentences[num];

        return "" + s;
    }

}
