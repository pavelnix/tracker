package ru.pavelnix.start;

import ru.pavelnix.models.Comment;
import ru.pavelnix.models.Item;

import java.util.Random;

/**
 * Class tracker
 * Класс трэкер
 */
public class Tracker implements Track {
    private static final Random RN = new Random();
    private Item[] items;
    private int countItem;

    public Tracker() {
        this.countItem = 0;
    }

    public int getCountItem() {
        return countItem;
    }

    /**
     * add the proposal to the tracker
     */
    public void add(Item item) {
        item.setId(this.generateId());
        Item[] newItems = new Item[countItem + 1];
        if (countItem > 0) {
            System.arraycopy(this.items, 0, newItems, 0, countItem);
        }
        this.items = new Item[countItem + 1];
        System.arraycopy(newItems, 0, this.items, 0, countItem);
        this.items[countItem++] = item;
    }

    /**
     * add the comment to the proposal
     *
     * @param comment - comment
     */
    public void add(Comment comment) {
        String id = comment.getItemId();
        Item item = getById(id);
        item.addComment(comment);
    }

    /**
     * update the proposal in the tracker
     *
     * @param item - proposal
     */
    public void update(Item item) {
        for (int i = 0; i < countItem; i++) {
            if (items[i].getId().equals(item.getId())) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * delete the proposal from the tracker
     *
     * @param id - proposal
     */
    public void delete(String id) {
        for (int i = 0; i < countItem; i++) {
            if (items[i].getId().equals(id)) {
                Item[] newItems = new Item[countItem - 1];
                if (i > 0) {
                    for (int j = 0; j <= 2; j++)
                        System.arraycopy(this.items, 0, newItems, 0, i);
                }
                System.arraycopy(this.items, i + 1, newItems, i, countItem - 1 - i);

                items = new Item[--countItem];
                System.arraycopy(newItems, 0, this.items, 0, countItem);

                break;
            }
        }
    }

    /**
     * Get proposal from the tracker
     *
     * @param id - identifier
     * @return proposal
     */
    public Item getById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Get all proposal from the tracker
     *
     * @return all proposal
     */
    public Item[] getAll() {
        return this.items;
    }

    /**
     * Find the proposal by the filter
     *
     * @param filter - name
     * @return proposal
     */
    public Item[] findByKey(Filter filter) {
        Item[] temp = new Item[countItem];
        int count = 0;
        boolean flag;
        String[] filterString = filter.toArrayString();
        for (Item item : items) {
            flag = false;
            String[] itemString = item.toArrayString();
            for (int i = 0; i < itemString.length; i++) {
                if (filterString[i] == null) ;
                else {
                    if (filterString[i].equals(itemString[i])) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            }

            if (flag == true) {
                temp[count++] = item;
            }
        }
        Item[] result = new Item[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;

/*
        Item[] result = items;
        int i = 0;
        if (filter.getName() != null) {
            result = findByName(filter.getName());
        }
        if (filter.getDescription() != null) {
            result = findByDescription(result, filter.getDescription());
        }
        if (filter.getDate() != 0) {
            result = findByDate(result, filter.getDate());
        }
        if (filter.getAuthorId() != null) {
            result = findByAuthorId(result, filter.getAuthorId());
        }
        return result;
*/
    }

    private Item[] findByName(String name) {
        Item[] temp = new Item[countItem];
        int i = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                temp[i++] = item;
            }
            }
        Item[] result = new Item[i];
        System.arraycopy(temp, 0, result, 0, i);
        return result;
    }

    private Item[] findByDescription(Item[] itemCut, String description) {
        Item[] temp = new Item[itemCut.length];
        int i = 0;
        for (Item item : itemCut) {
            if (item.getDescription().equals(description)) {
                temp[i++] = item;
            }
        }
        Item[] result = new Item[i];
        System.arraycopy(temp, 0, result, 0, i);
        return result;
    }

    private Item[] findByDate(Item[] itemCut, long date) {
        Item[] temp = new Item[itemCut.length];
        int i = 0;
        for (Item item : itemCut) {
            if (item.getDate() == date) {
                temp[i++] = item;
            }
        }
        Item[] result = new Item[i];
        System.arraycopy(temp, 0, result, 0, i);
        return result;
    }

    private Item[] findByAuthorId(Item[] itemCut, String authorId) {
        Item[] temp = new Item[itemCut.length];
        int i = 0;
        for (Item item : itemCut) {
            if (item.getAuthorId().equals(authorId)) {
                temp[i++] = item;
            }
        }
        Item[] result = new Item[i];
        System.arraycopy(temp, 0, result, 0, i);
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
} 