package ru.pavelnix.start;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput
                (new String[]{
                        "1", "1", "1", "1",
                        "1", "2", "2", "2",
                        null, "2", "0", null,
                        "1", null, "0", null,
                });
        StartUI startUI = new StartUI(input);
        String id = startUI.add();
        startUI.add();
        startUI.getAll();
        startUI.findByKey();
        startUI.findByKey();
        //((StubInput) input).setAnswers(new String[]{id});
        //startUI.getById();
    }
}
