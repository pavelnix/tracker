package ru.pavelnix.start;

/**
 * Created by Administrator on 20.04.2016.
 */
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
