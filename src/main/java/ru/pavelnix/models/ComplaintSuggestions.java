package ru.pavelnix.models;

/**
 * Класс, наследник от Item, определяет заявку - Замечания и Предложения
 * Жалобы и предложения
 */
public class ComplaintSuggestions extends Item {
    private String compliant;

    public ComplaintSuggestions(String name, String description, long date, String authorId, String compliant) {
        super(name, description, date, authorId);
        this.compliant = compliant;
    }

    public String getCompliant() {
        return this.compliant;
    }

    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }
}
