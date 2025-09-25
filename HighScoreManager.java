import java.io.*;
import java.util.*;

public class HighScoreManager {
    private static final String SCORE_FILE = "highscore.txt";

    // Save a player's score (append to file)
    public static void saveScore(String name, int score) {
        try (FileWriter fw = new FileWriter(SCORE_FILE, true)) { // true = append mode
            fw.write(name + "," + score + "\n");
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    // View leaderboard (Top 5 scores)
    public static void viewLeaderboard() {
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) {
                System.out.println("No scores recorded yet.");
                return;
            }

            // Read all scores
            List<PlayerScore> scores = new ArrayList<>();
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores.add(new PlayerScore(name, score));
                }
            }
            fileReader.close();

            // Sort scores descending
            scores.sort((a, b) -> Integer.compare(b.score, a.score));

            // Show top 5
            System.out.println("\n===== LEADERBOARD =====");
            for (int i = 0; i < Math.min(5, scores.size()); i++) {
                PlayerScore ps = scores.get(i);
                System.out.println((i + 1) + ". " + ps.name + " - " + ps.score);
            }
            System.out.println("=======================");

        } catch (IOException e) {
            System.out.println("Error reading scores: " + e.getMessage());
        }
    }

    // Inner class to hold score data
    static class PlayerScore {
        String name;
        int score;

        PlayerScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
