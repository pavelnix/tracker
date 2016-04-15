package ru.pavelnix.models;

/**
 * Класс для работы с комментариями
 */
public class Comment {
    private String itemId;
    private String text;
    private long date;
    private String authorId;

    public Comment(String itemId, String text, long date, String authorId) {
        this.itemId = itemId;
        this.text = text;
        this.date = date;
        this.authorId = authorId;
    }

    public String getItemId() {
        return this.itemId;
    }

    @Override
    public String toString() {
        return "\n\t\tComment{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", authorId='" + authorId + '\'' +
                "}";
    }
}
