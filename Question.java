public class Question {
    private String text;
    private String[] options;
    private char correctAnswer;

    // Constructor
    public Question(String text, String[] options, char correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}
