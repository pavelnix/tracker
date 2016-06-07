package ru.pavelnix.start;

/**
 * Created by Administrator on 25.03.2016.
 */
public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(input, tracker);
        startUI.menu();
    }

    public void menu() {
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int menuItem = 0;
            boolean invalid = true;
            do {
                try {
                    menuItem = Integer.valueOf(input.ask("Select an option: "));
                    invalid = false;
                } catch (NumberFormatException ex) {
                    System.out.println("Enter right value: ");
                }
            } while (invalid);
            menu.select(menuItem);
        } while (!"y".equals(this.input.ask("Exit? (y):")));
    }
}
