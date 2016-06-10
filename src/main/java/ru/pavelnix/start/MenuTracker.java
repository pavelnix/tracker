package ru.pavelnix.start;

import ru.pavelnix.models.Comment;
import ru.pavelnix.models.Item;

class DeleteItem extends BaseAction {

    public DeleteItem(String name) {
        super(name);
    }

    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter id to delete: ");
        tracker.delete(id);
    }
}

class UpdateItem extends BaseAction {

    public UpdateItem(String name) {
        super(name);
    }

    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter id to update: ");
        String name = input.ask("Please, enter the new name: ");
        String desk = input.ask("Please, enter the new description: ");
        MenuTracker menuTracker = new MenuTracker(input, tracker);
        long date = menuTracker.dateFromString("Please, enter the new date: ");
        String author = input.ask("Please, enter the new author: ");
        Item item = new Item(name, desk, date, author);
        item.setId(id);
        tracker.update(item);
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

    public int fillActions() {
        this.actions[1] = this.new AddItem("Add Item");
        this.actions[2] = new MenuTracker.GetAllItem("Get all items");
        this.actions[3] = new DeleteItem("Delete Item");
        this.actions[4] = this.new GetItemById("Get Item By Id");
        this.actions[5] = new MenuTracker.GetItemsByKey("Get items by key");
        this.actions[6] = new UpdateItem("Update item");
        this.actions[7] = this.new AddComment("Add comment");
        return this.actions.length;
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

    public long dateFromString(String str) {
        long date = 0;
        boolean invalid = true;
        do {
            String dateStr = input.ask(str);
            if (dateStr.matches("^-?\\d+$")) {
                date = Long.valueOf(dateStr);
                invalid = false;
            } else {
                System.out.println("Enter right value: ");
            }
        } while (invalid);
        return date;
    }

    private static class GetAllItem extends BaseAction {

        public GetAllItem(String name) {
            super(name);
        }

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
    }

    private static class GetItemsByKey extends BaseAction {

        public GetItemsByKey(String name) {
            super(name);
        }

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Create filter\nPlease, enter the name: ");
            String desk = input.ask("Please, enter the description: ");
            MenuTracker menuTracker = new MenuTracker(input, tracker);
            long date = menuTracker.dateFromString("Please, enter the date: ");
            String author = input.ask("Please, enter the author: ");
            Filter filter = new Filter();
            filter.setName(name);
            filter.setDescription(desk);
            filter.setDate(date);
            filter.setAuthorId(author);
            Item[] itemFilter = tracker.findByKey(filter);
            if (itemFilter == null) {
                System.out.println("Items not found");
            } else {
                for (Item item : itemFilter) {
                    System.out.println(item);
                }
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(String name) {
            super(name);
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Add Item\nPlease, enter the name: ");
            String desk = input.ask("Please, enter the description: ");
            MenuTracker menuTracker = new MenuTracker(input, tracker);
            long date = menuTracker.dateFromString("Please, enter the date: ");
            String author = input.ask("Please, enter the author: ");
            Item itemAdd = new Item(name, desk, date, author);
            tracker.add(itemAdd);
        }
    }

    private class GetItemById extends BaseAction {

        public GetItemById(String name) {
            super(name);
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter id to get Item by id: ");
                Item item = tracker.getById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class AddComment extends BaseAction {

        public AddComment(String name) {
            super(name);
        }

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
    }
}
