package ru.pavelnix.models;

import java.util.Arrays;
import java.util.Objects;

/**
 * Proposal
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long date;
    private String authorId;
    private Comment[] comments;

    private int countComment;

    public Item() {

    }

    public Item(String name, String description, long date, String authorId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.authorId = authorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Comment[] getComments() {
        return this.comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        Comment[] newComments = new Comment[countComment + 1];
        if (countComment > 0){
			System.arraycopy(this.comments, 0, newComments, 0, countComment);
		}
		this.comments = new Comment[countComment + 1];
        System.arraycopy(newComments, 0, this.comments, 0, countComment);
        this.comments[countComment++] = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(date, item.date) &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(authorId, item.authorId);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", authorId='" + authorId + '\'' +
                ", comments= " + Arrays.toString(comments) +
                '}';
    }

    public String[] toArrayString() {
        return new String[]{name, description, Long.toString(date), authorId};
    }
}


