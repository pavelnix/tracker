package ru.pavelnix.start;

import java.util.Scanner;

/**
 * Created by Administrator on 25.03.2016.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String questions) {
        System.out.print(questions);
        String ret = scanner.nextLine();
        ret = "".equals(ret) ? null : ret;
        return ret;
    }
}
