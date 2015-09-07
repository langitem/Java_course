/**
 * Created by myltik
 * Created on 7/21/13 9:47 PM
 */
public class W03DQ2AppRunner {

    public static void main(String[] args) {
        try {
            W03DQ2App app = new W03DQ2App();
            app.run();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("An error has occured: " + t.getMessage());
        }
    }
}
