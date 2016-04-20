package ru.pavelnix.start;

import ru.pavelnix.models.Item;

/**
 * Created by Administrator on 22.03.2016.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput
                (new String[]{"1",//add item
                        "1", "1", "1", "1",// item 1
                        "n",
                        "2", //show items
                        "n",
                        "1", //add item
                        "2", "2", "2", "2", //item 2
                        "n",
                        "2", //show items
                        "y"
                });
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        startUI.menu();
        String[] ids = new String[2];
        int index = 0;
        for (Item item : tracker.getAll()) {
            ids[index++] = item.getId();
        }
        ((StubInput) input).setAnswers(new String[]{
                "4", //Get item by ID
                ids[0],
                "n",
                "7",
                ids[0], "q", "12", "e",
                "n",
                "2",
                "n",
                "7",
                ids[0], "1", "12", "e",
                "n",
                "2",
                "n",
                "6",
                ids[0], "qw", "qw", "123", "qw",
                "n",
                "2",
                "y"
        });
        startUI.menu();
    }
}
