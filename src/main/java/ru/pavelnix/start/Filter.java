package ru.pavelnix.start;

/**
 * Класс задает поля для поиска заявки
 * Class specifies search item
 */
public class Filter {
    private String name;
    private String description;
    private long date;
    private String authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String[] toArrayString() {
        String dateString = null;
        if (date != 0) {
            dateString = Long.toString(date);
        }
        return new String[]{name, description, dateString, authorId};
    }
}
