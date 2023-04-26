package tests;

import sumcheck.CheckSumSign;

import java.util.Scanner;

public class CheckSumSignDemo implements Demo {
    private final Scanner scanner = new Scanner(System.in);
    private final CheckSumSign checkSumSign = new CheckSumSign();

    @Override
    public void demo() {
        System.out.println("Is numbers sequence sum positive?\n");

        checkSumSign.setValues(getNumbers(getNumbersCount()));
        String answer = checkSumSign.hasPositiveSum() ? "Yes" : "No";
        
        System.out.println(String.format("Answer: %s", answer));
    }

    private int getNumbersCount() {
        System.out.println("Please enter numbers count");
        System.out.print("> ");

        return scanner.nextInt();
    }

    private int[] getNumbers(int count) {
        int numbers[] = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print(String.format("\t ~ %d > ", i + 1));
            try {
                numbers[i] = scanner.nextInt();
            } catch (Exception exception) {
                numbers[i] = 0;
            }
        }

        return numbers;
    }
}
