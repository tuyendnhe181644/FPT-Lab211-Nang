package newb71;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author buidu
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String input, int min, int max) {
        while (true) {
            System.out.print(input);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Please input int more than zero");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Please input int");
            }
        }
    }

    public static double getDouble(String input, double min, double max) {
        while (true) {
            System.out.print(input);
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                } else {
                    System.err.println("Please input double more than zero");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Please input double");
            }
        }
    }

    public static String getString(String input) {
        while (true) {
            System.out.print(input);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            } else {
                System.err.println("Please input String");
            }
        }
    }

    public static String getDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Không cho phép ngày tháng sai (ví dụ: 32-13-2021)

        while (true) {
            System.out.print(input);
            String dateInput = sc.nextLine();
            try {
                dateFormat.parse(dateInput); // Cố gắng phân tích ngày nhập vào
                return dateInput; // Nếu thành công, trả về giá trị ngày
            } catch (ParseException ex) {
                System.err.println("Please input a valid date in the format dd-MM-yyyy");
            }
        }
    }

    public static boolean checkDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Không cho phép ngày tháng sai (ví dụ: 32-13-2021)
        try {
            dateFormat.parse(date); // Cố gắng phân tích ngày nhập vào
            return true; // Nếu thành công, trả về giá trị ngày
        } catch (ParseException ex) {
            return false;
        }
    }
}
