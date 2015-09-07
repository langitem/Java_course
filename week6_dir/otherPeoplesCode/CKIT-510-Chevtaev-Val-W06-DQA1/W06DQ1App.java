import java.util.*;

import static java.lang.System.out;

/**
 * Write a Java program which defines an unconstrained array of user defined length n, that
 * contains n Random numbers and outputs those random numbers that are even numbers.
 *
 * Created by myltik
 * Created on 8/11/13 4:40 PM
 */
public class W06DQ1App implements Runnable {

    private final int numbersCount;

    public W06DQ1App(int numbersCount) {
        this.numbersCount = numbersCount;
    }

    /**
     * Process
     */
    @Override
    public void run() {
        final int[] randomNumbers = generateRandomNumbers(numbersCount);

        out.println("Randomly generated array of size " + numbersCount + ":");
        out.println("\t" + Arrays.toString(randomNumbers));
        out.println("Even numbers: ");
        out.println("\t" + filter(randomNumbers));
    }

    /**
     * @param count
     * @return Array of specified length of random integers
     */
    private int[] generateRandomNumbers(int count) {
        final Random rnd = new Random(System.currentTimeMillis());
        final int[] numbers = new int[count];

        while (count-- > 0) {
            numbers[count] = rnd.nextInt();
        }

        return numbers;
    }

    /**
     * @param array
     * @return Array of even numbers only
     */
    private List<Integer> filter(final int[] array) {
        List<Integer> result = new ArrayList<Integer>(array.length);

        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                result.add(array[i]);
            }
        }

        return result;
    }
}
