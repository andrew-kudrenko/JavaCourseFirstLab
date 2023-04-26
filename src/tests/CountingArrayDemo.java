package tests;

import arraytools.ComparisonResult;
import arraytools.CountingArray;

import java.util.Scanner;

public class CountingArrayDemo implements Demo {
    private final CountingArray numbers = new CountingArray(new double[] {0});
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void demo() {
        numbers.setValues(getNumbers(getNumbersCount()));
        printResult(numbers.compare(getCompareWith()));
    }

    private int getCompareWith() {
        System.out.println("Please enter what a number should compare with");
        System.out.print("> ");

        return scanner.nextInt();
    }

    private int getNumbersCount() {
        System.out.println("Please enter numbers count");
        System.out.print("> ");

        return scanner.nextInt();
    }

    private double[] getNumbers(int count) {
        double numbers[] = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print(String.format("\t ~ %d > ", i + 1));
            try {
                numbers[i] = scanner.nextDouble();
            } catch (Exception exception) {
                numbers[i] = 0;
            }
        }

        return numbers;
    }

    private void printResult(ComparisonResult result) {
        System.out.println(String.format("LT: %d, Eq: %d, GT: %d", result.lessThan, result.equals, result.greaterThan));
    }
}
