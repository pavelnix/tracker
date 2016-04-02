package ru.pavelnix.start;

import ru.pavelnix.models.Item;

/**
 * Created by Administrator on 25.03.2016.
 */
public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input) {
        this.input = input;
        tracker = new Tracker();
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI(input);
        System.out.println("Chose action:");
        startUI.add();
        startUI.add();
        startUI.getAll();
 /*
        startUI.update();
        startUI.getAll();
        startUI.delete();
        startUI.getAll();
        startUI.getById();
 */
        startUI.findByKey();
    }

    public String add() {
//        input.ask("Please, choose type of Item:\n1 - Comment\n2 - ComplaintSuggestions\n3 - Consultation");
        String name = input.ask("Add Item\nPlease, enter the name: ");
        String desk = input.ask("Please, enter the description: ");
        long date = Long.valueOf(input.ask("Please, enter the date: "));
        String author = input.ask("Please, enter the author: ");
        Item itemAdd = new Item(name, desk, date, author);
        tracker.add(itemAdd);
        return itemAdd.getId();
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
        for (Item item : tracker.getAll()) {
            System.out.println(item);
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
}
