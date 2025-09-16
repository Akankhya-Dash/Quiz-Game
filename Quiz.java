import java.util.*;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    // Add a question
    public void addQuestion(Question q) {
        questions.add(q);
    }

    // Play the quiz
    public int play(Scanner sc, String playerName) {
        int score = 0;

        // Randomize question order
        Collections.shuffle(questions);

        System.out.println("\n--- QUIZ STARTS NOW ---\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.getText());

            String[] opts = q.getOptions();
            for (int j = 0; j < opts.length; j++) {
                System.out.println((char) ('A' + j) + ". " + opts[j]);
            }

            System.out.print("Your answer: ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            if (userAnswer == q.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz Over! " + playerName + ", your score: " + score + "/" + questions.size());
        return score;
    }
}
