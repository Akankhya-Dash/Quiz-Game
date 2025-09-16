import java.io.*;
import java.util.*;

public class HighScoreManager {
    private static final String SCORE_FILE = "highscore.txt";

    public static void saveHighScore(String name, int score) {
        try {
            int highScore = 0;
            String highScorer = "";

            File file = new File(SCORE_FILE);
            if (file.exists()) {
                Scanner fileReader = new Scanner(file);
                if (fileReader.hasNextLine()) {
                    highScorer = fileReader.nextLine();
                }
                if (fileReader.hasNextInt()) {
                    highScore = fileReader.nextInt();
                }
                fileReader.close();
            }

            if (score > highScore) {
                FileWriter fw = new FileWriter(SCORE_FILE);
                fw.write(name + "\n" + score);
                fw.close();
                System.out.println("New High Score: " + score + " by " + name);
            } else {
                System.out.println("High Score remains: " + highScore + " by " + highScorer);
            }

        } catch (IOException e) {
            System.out.println("Error saving high score: " + e.getMessage());
        }
    }

    public static void viewHighScore() {
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) {
                System.out.println("No high score recorded yet.");
                return;
            }

            Scanner fileReader = new Scanner(file);
            String name = fileReader.nextLine();
            int score = fileReader.nextInt();
            fileReader.close();

            System.out.println("High Score: " + score + " by " + name);

        } catch (IOException e) {
            System.out.println("Error reading high score: " + e.getMessage());
        }
    }
}
