package ru.pavelnix.start;

import ru.pavelnix.models.Comment;
import ru.pavelnix.models.Item;

class DeleteItem implements UserAction {

    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter id to delete: ");
        tracker.delete(id);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Delete Item");
    }
}

class UpdateItem implements UserAction {

    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter id to update: ");
        String name = input.ask("Please, enter the new name: ");
        String desk = input.ask("Please, enter the new description: ");
        long date = Long.valueOf(input.ask("Please, enter the new date: "));
        String author = input.ask("Please, enter the new author: ");
        Item item = new Item(name, desk, date, author);
        item.setId(id);
        tracker.update(item);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Update item");
    }
}

/**
 * Created by Administrator on 20.04.2016.
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[1] = this.new AddItem();
        this.actions[2] = new MenuTracker.GetAllItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = this.new GetItemById();
        this.actions[5] = new MenuTracker.GetItemsByKey();
        this.actions[6] = new UpdateItem();
        this.actions[7] = this.new AddComment();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction userAction : this.actions) {
            if (userAction != null) {
                System.out.println(userAction.info());
            }
        }
    }

    private static class GetAllItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            if (tracker.getAll() == null) {
                System.out.println("Tracker if empty");
            } else {
                for (Item item : tracker.getAll()) {
                    System.out.println(item);
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Get all items");
        }
    }

    private static class GetItemsByKey implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
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

        public String info() {
            return String.format("%s. %s", this.key(), "Get items by key");
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Add Item\nPlease, enter the name: ");
            String desk = input.ask("Please, enter the description: ");
            long date = Long.valueOf(input.ask("Please, enter the date: "));
            String author = input.ask("Please, enter the author: ");
            Item itemAdd = new Item(name, desk, date, author);
            tracker.add(itemAdd);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add Item");
        }
    }

    private class GetItemById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter id to get Item by id: ");
            Item item = tracker.getById(id);
            System.out.println(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Get Item By Id");
        }
    }

    private class AddComment implements UserAction {
        public int key() {
            return 7;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter id to add Comment: ");
            String text = input.ask("Please, enter text of Comment: ");
            long date = Long.valueOf(input.ask("Please, enter the date: "));
            String author = input.ask("Please, enter the author: ");
            Comment comment = new Comment(id, text, date, author);
            tracker.add(comment);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add comment");
        }
    }
}