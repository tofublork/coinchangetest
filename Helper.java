import java.util.Scanner;
public class Helper {

    public static int getInt(String msg) {
        Scanner kb = new Scanner(System.in);
        print(msg);
        int n = kb.nextInt();
        return n;
    }

    public static String getString(String msg) {
        Scanner kb = new Scanner(System.in);
        print(msg);
        String s = kb.nextLine();
        return s;
    }

    public static void println(String msg) {
        System.out.println(msg);
    }
    public static void print(String msg) {
        System.out.print(msg);
    }

}
