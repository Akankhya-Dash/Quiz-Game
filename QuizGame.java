import java.util.*;

public class QuizGame {
    static Scanner sc = new Scanner(System.in);
    static Quiz quiz = new Quiz();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== QUIZ GAME MENU ====");
            System.out.println("1. Create Quiz");
            System.out.println("2. Play Quiz");
            System.out.println("3. View High Score");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createQuiz();
                case 2 -> playQuiz();
                case 3 -> HighScoreManager.viewLeaderboard();
                case 4 -> System.out.println("Exiting... Thank you for playing!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    // Create quiz
    static void createQuiz() {
        System.out.print("Enter number of questions: ");
        int numQuestions = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numQuestions; i++) {
            System.out.println("\nEnter Question " + (i + 1) + ": ");
            String questionText = sc.nextLine();

            String[] opts = new String[4];
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter option " + (char) ('A' + j) + ": ");
                opts[j] = sc.nextLine();
            }

            System.out.print("Enter correct answer (A/B/C/D): ");
            char correctAnswer = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            quiz.addQuestion(new Question(questionText, opts, correctAnswer));
        }
        System.out.println("Quiz created successfully!");
    }

    // Play quiz
    static void playQuiz() {
        if (quiz == null) {
            System.out.println("No quiz found. Please create one first.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        int score = quiz.play(sc, name);
        HighScoreManager.saveScore(name, score);
    }
}
