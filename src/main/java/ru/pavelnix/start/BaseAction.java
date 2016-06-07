package ru.pavelnix.start;

/**
 * Created by Administrator on 04.05.2016.
 */
public abstract class BaseAction implements UserAction {
    private String name;

    public BaseAction(String name) {
        this.name = name;
    }

    public abstract int key();

    public abstract void execute(Input input, Tracker tracker);

    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
