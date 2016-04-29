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
 /*
        int menuItem;
        do {
            menuItem = Integer.valueOf(input.ask(
                    String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                            "Menu:",
                            "1. Add item",
                            "2. Get all items",
                            "3. Delete item",
                            "4. Get item by id",
                            "5. Get items by key",
                            "6. Update item by id",
                            "0. To exit",
                            "Select an option: ")));
            switch (menuItem) {
                case 1:
                    add();
                    break;
                case 2:
                    getAll();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    getById();
                    break;
                case 5:
                    findByKey();
                    break;
                case 6:
                    update();
                    break;
                case 7:
                    addComment();
                    break;
            }
        } while (menuItem != 0);
        */
    }

    /*
    private void addComment() {
        String id = input.ask("Please, enter id to add Comment: ");
        String text = input.ask("Please, enter text of Comment: ");
        long date = Long.valueOf(input.ask("Please, enter the date: "));
        String author = input.ask("Please, enter the author: ");
        Comment comment = new Comment(id, text, date, author);
        tracker.add(comment);
    }

    public void add() {
//        input.ask("Please, choose type of Item:\n1 - Comment\n2 - ComplaintSuggestions\n3 - Consultation");
        String name = input.ask("Add Item\nPlease, enter the name: ");
        String desk = input.ask("Please, enter the description: ");
        long date = Long.valueOf(input.ask("Please, enter the date: "));
        String author = input.ask("Please, enter the author: ");
        Item itemAdd = new Item(name, desk, date, author);
        tracker.add(itemAdd);
    }

    public void update() {
        String id = input.ask("Please, enter id to update: ");
        String name = input.ask("Please, enter the new name: ");
        String desk = input.ask("Please, enter the new description: ");
        long date = Long.valueOf(input.ask("Please, enter the new date: "));
        String author = input.ask("Please, enter the new author: ");
        Item item = new Item(name, desk, date, author);
        item.setId(id);
        tracker.update(item);
    }

    public void getAll() {
        if (tracker.getAll() == null) {
            System.out.println("Tracker if empty");
        } else {
            for (Item item : tracker.getAll()) {
                System.out.println(item);
            }
        }
    }

    public void delete() {
        String id = input.ask("Please, enter id to delete: ");
        tracker.delete(id);
    }

    public void findByKey() {
        String name = input.ask("Create filter\nPlease, enter the name: ");
        String desk = input.ask("Please, enter the description: ");
        long date = Long.valueOf(input.ask("Please, enter the date: "));
        String author = input.ask("Please, enter the author: ");
        Filter filter = new Filter();
        filter.setName(name);
        filter.setDescription(desk);
        filter.setDate(date);
        filter.setAuthorId(author);
        Item[] itemFilter = tracker.findByKey(filter);
        for (Item item : itemFilter) {
            System.out.println(item);
        }
    }

    public void getById() {
        String id = input.ask("Please, enter id to get Item by id: ");
        Item item = tracker.getById(id);
        System.out.println(item);
    }
    */
}
