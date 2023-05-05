import tests.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private static final Map<String, Demo> demos = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>("convert", new ConverterDemo()),
            new AbstractMap.SimpleImmutableEntry<>("prompt", new PromptDemo()),
            new AbstractMap.SimpleImmutableEntry<>("counting-array", new CountingArrayDemo()),
            new AbstractMap.SimpleImmutableEntry<>("sum-sign", new CheckSumSignDemo())
    );

    public static void main(String[] args) {
        System.out.println("Press `Ctrl + D` to terminate the program.\n");

        while (true) {
            printDemoList();
            runDemoByKey(getDemoKey());
            System.out.println("\n");
        }
    }

    private static void printDemoList() {
        System.out.println("To select a demo enter its key");
        demos.forEach((k, v) -> System.out.printf("\t~ \"%s\"%n", k));
        System.out.println();
    }

    private static String getDemoKey() {
        System.out.print("?> ");
        return scanner.next().trim();
    }

    private static void runDemoByKey(String key) {
        if (demos.containsKey(key)) {
            demos.get(key).demo();
        } else {
            System.out.printf("Demo runner by key \"%s\" does not exist%n", key);
        }
    }
}