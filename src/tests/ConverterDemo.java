package tests;

import converter.Converter;
import converter.LengthUnit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterDemo implements Demo {
    private final String prelude = ">";
    private final Scanner scanner = new Scanner(System.in);
    private final Converter converter = new Converter();

    @Override
    public void demo() {
        printPrelude();
        convertToAllAvailableUnits(getValue());
    }

    private void convertToAllAvailableUnits(double value) {
        var unitValues = LengthUnit.values();

        for (var fromUnit : unitValues) {
            for (var toUnit : unitValues) {
                converter.setUnits(fromUnit, toUnit);
                printConvertedValue(fromUnit, toUnit, value);
            }
        }
    }

    private double getValue() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException exception) {
            return 0;
        }
    }

    private void printPrelude() {
        System.out.println("Please input a value to convert it. Incorrect input will be interpreted as zero (0.0).");
        System.out.print(prelude + " ");
    }

    private void printConvertedValue(LengthUnit from, LengthUnit to, double value) {
        System.out.println(String.format("%s | %f -> %s | %f", from, value, to, converter.convert(value)));
    }
}
