package ru.pavelnix.start;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput
                (new String[]{"1",//add item
                        "1", "1", "1", "1",// item 1
                        "2", //show items
                        "1", //add item
                        "2", "2", "2", "2", //item 2
                        "2", //show items
                        "0"
                });
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        String id = startUI.menu();
        ((StubInput) input).setAnswers(new String[]{
                "4",
                id,
                "0"
        });
        startUI.menu();
    }
}
