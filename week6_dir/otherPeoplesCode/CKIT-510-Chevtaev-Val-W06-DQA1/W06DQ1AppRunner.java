/**
 * Created by myltik
 * Created on 8/11/13 4:40 PM
 */
public class W06DQ1AppRunner {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                throw new CloseAppException("Please specify <numbers count> argument");
            }

            final int numbersCount = Integer.parseInt(args[0]);
            if (numbersCount < 1) {
                throw new CloseAppException("Argument <numbers count> must be greater than 0");
            }

            new W06DQ1App(numbersCount).run();

        } catch (CloseAppException e) {
            System.err.println("Error: " + e.getMessage());
            usage();
        } catch (NumberFormatException e) {
            usage();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }

    /**
     * Print app usage message to console.
     */
    private final static void usage() {
        System.err.println("Usage: java " + W06DQ1AppRunner.class + " <numbers count>");
    }
}
