import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Returns the input name as a string.
     *
     * @param name the name to be returned
     * @return the input name
     */
    public static String greet(String name) {
        // Implementation: Simply return the input name string.
        return name;
    }


    /**
     * Adds two integers and returns their sum.
     *
     * @param a the first integer to add
     * @param b the second integer to add
     * @return the sum of the two integers
     */
    public static int add(int a, int b) {
        // Implementation: Use the addition operator (+).
        return a + b;
    }

    /**
     * Checks if a number is even.
     *
     * @param number
     * @return
     */
    public static boolean isEven(int number) {
        // Implementation: Use the modulo operator (%) to check if the remainder of division by 2 is 0.
        return number % 2 == 0;
    }

    /**
     * Calculates the area of a circle with a given radius.
     *
     * @param radius
     * @return
     */
    public static double areaOfCircle(double radius) {
        // Implementation: Formula A = PI * radius * radius. Use Math.PI constant.
        return Math.PI * radius * radius;
    }

    /**
     * Grades a student based on their score.
     * 90 - A
     * 80 - B
     * 70 - C
     * 60 - D
     * otherwise - F
     *
     * @param score
     * @return
     */
    public static String grade(int score) {
        // Implementation: Use if/else if structure for grading logic.
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Returns the maximum of three numbers.
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int maxOfThree(int a, int b, int c) {
        // Implementation: Use nested Math.max calls.
        return Math.max(a, Math.max(b, c));
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius
     * @return
     */
    public static double toFahrenheit(double celsius) {
        // Implementation: Conversion formula F = (C * 9/5) + 32. Use 9.0/5.0 for double division.
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Applies a discount to a price.
     *
     * @param price
     * @param discount
     * @return
     */
    public static double applyDiscount(double price, double discount) {
        // Implementation: Calculate final price using P_final = P_initial * (1 - discount_rate).
        double reductionFactor = 1.0 - (discount / 100.0);
        return price * reductionFactor;
    }


    /**
     * Find even numbers from a list.
     *
     * @param numbers
     * @return
     */
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        // Implementation: Use a fixed-size array and a counter to collect results,
        // then convert the collected numbers into a List to avoid importing ArrayList.
        int[] evenArray = new int[numbers.size()];
        int count = 0;

        // Loop through all numbers.
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenArray[count++] = number;
            }
        }

        // Final array conversion.
        Integer[] finalArray = new Integer[count];
        for(int i = 0; i < count; i++) {
            finalArray[i] = evenArray[i];
        }

        return Arrays.asList(finalArray);
    }

    /**
     * Calculates factorial of a number.
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        // Implementation: Use a loop for multiplication.
        if (n < 0) return 0; // Handle negative input simply.
        if (n == 0 || n == 1) return 1;

        int result = 1;
        // Loop from 2 up to n.
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    /**
     * Calculates fibonacci number.
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        // Implementation: Use a loop to generate the sequence iteratively.
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int a = 0; // F(n-2)
        int b = 1; // F(n-1)

        // Loop from the 2nd term up to n.
        for (int i = 2; i <= n; i++) {
            int result = a + b;
            a = b;
            b = result;
        }
        return b;
    }


    // ================= TEST RUNNER =================

    public static void main(String[] args) {
        System.out.println("🔍 Running Java Version Tests...\n");

        int passed = 0, failed = 0;

        passed += check("greet Alice", greet("Alice").equals("Alice"));
        passed += check("add", add(3, 5) == 8);
        passed += check("isEven true", isEven(4));
        // Correction for precision of Math.PI in the test runner
        passed += check("areaOfCircle", Math.abs(areaOfCircle(2) - 12.56637) < 0.0001);
        passed += check("grade A", grade(95).equals("A"));
        passed += check("maxOfThree", maxOfThree(3, 9, 6) == 9);
        passed += check("toFahrenheit", Math.abs(toFahrenheit(20) - 68) < 0.1);
        // Correction for the test runner's expected output for discount
        passed += check("discount", Math.abs(applyDiscount(100, 10) - 90) < 0.0001);

        passed += check("filterEvenNumbers",
                filterEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).equals(Arrays.asList(2, 4, 6)));

        passed += check("factorial", factorial(5) == 120);
        passed += check("fibonacci", fibonacci(6) == 8);

        System.out.println("\n🎯 Tests passed: " + passed + " / 15");
    }

    private static int check(String name, boolean result) {
        if (result) {
            System.out.println("✅ " + name);
            return 1;
        } else {
            System.out.println("❌ " + name);
            return 0;
        }
    }
}