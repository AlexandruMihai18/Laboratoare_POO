package task1;

import java.util.Arrays;
import java.util.Collection;

interface Calculator {
    class NullParameterException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }

    class OverflowException extends RuntimeException {
    }

    Double add(Double nr1, Double nr2);

    Double divide(Double nr1, Double nr2);

    Double average(Collection<Double> numbers);
}

class CalculatorBase implements Calculator {
    public CalculatorBase() {

    }

    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        Double result = nr1 + nr2;

        if (result == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }

        if (result == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }

        return result;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        if (nr2 == 0d && nr1 > 0d) {
            throw new OverflowException();
        }

        if (nr2 == 0d && nr1 < 0d) {
            throw new UnderflowException();
        }

        Double result = nr1 / nr2;

        return result;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new NullParameterException();
        }

        Double sum  = 0d;

        for (Double number : numbers) {
            if (number == null) {
                throw new NullParameterException();
            }

            sum += number;

            if (sum == Double.POSITIVE_INFINITY) {
                throw new OverflowException();
            }

            if (sum == Double.NEGATIVE_INFINITY) {
                throw new UnderflowException();
            }
        }

        Double result = sum / numbers.size();

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorBase();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(Arrays.asList(1d, 2d, 3d, 4d)));


        try {
            calculator.add(null, Double.MAX_VALUE);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(Double.MAX_VALUE, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }

        try {
            calculator.divide(null, Double.MAX_VALUE);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(Double.MAX_VALUE, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(null, null);
        } catch (CalculatorBase.NullParameterException e) {
            System.out.println("Null Parameter Exception thrown!");
        }

        try {
            calculator.divide(1d, 0d);
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.divide(-1d, 0d);
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }

        try {
            calculator.average(Arrays.asList(1d, 2d, Double.MAX_VALUE, Double.MAX_VALUE));
        } catch (CalculatorBase.OverflowException e) {
            System.out.println("Overflow Exception thrown!");
        }

        try {
            calculator.average(Arrays.asList(1d, -100d, -Double.MAX_VALUE, -Double.MAX_VALUE));
        } catch (CalculatorBase.UnderflowException e) {
            System.out.println("Underflow Exception thrown!");
        }
    }
}