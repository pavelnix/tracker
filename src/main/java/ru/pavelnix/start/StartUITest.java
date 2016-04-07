package ru.pavelnix.start;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput
                (new String[]{"1",
                        "1", "1", "1", "1",
                        "2",
                        "1",
                        "2", "2", "2", "2",
                        "2",
                        "4"});
        StartUI startUI = new StartUI(input);
        String id = startUI.menu();
        ((StubInput) input).setAnswers(new String[]{
                id,
                "0"});
        //     startUI.menu();
        //String id = startUI.add();
        // ((StubInput) input).setAnswers(new String[]{id});
        //startUI.getById();
    }
}
