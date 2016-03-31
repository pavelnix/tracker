package ru.pavelnix.start;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StubInput implements Input {
    private String[] answers;
    private int positions = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String questions) {
        System.out.print(questions);
        System.out.println(answers[positions]);
        return answers[positions++];
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
        positions = 0;
    }
}
