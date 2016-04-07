package ru.pavelnix.start;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput
                (new String[]{"1",//add item
                        "1", "1", "1", "1",
                        "2", //show items
                        "1", //add item
                        "2", "2", "2", "2",
                        "2", //show items
                        "4" //get item by id
                });
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
