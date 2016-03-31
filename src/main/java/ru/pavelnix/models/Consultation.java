package ru.pavelnix.models;

/**
 * Класс, наследник от Item, определяет заявку - Консультация
 * consultation
 * query
 */
public class Consultation extends Item {
    private String query;

    public Consultation(String name, String description, long date, String authorId, String query) {
        super(name, description, date, authorId);
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Consultation that = (Consultation) o;
        return Objects.equals(query, that.query);
    }
*/
}