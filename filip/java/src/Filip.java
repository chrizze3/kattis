import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Filip {
    public static Kattio io;
    public static void kattioInputFromFile() {
        try {
            io = new Kattio(new FileInputStream(new File("src/filip.dummy.3.in")), System.out);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void printNumberReverse(int num) {
        while (num > 0) {
            io.print(num % 10);
            num /= 10;
        }
    }

    public static void setup() {
        // comment/uncomment to change input from console to from file
        io = new Kattio(System.in, System.out);
        //kattioInputFromFile();
        int n = io.getInt();
        int m = io.getInt();
        int n_last_digit = n % 10;
        int m_last_digit = m % 10;
        if (n_last_digit == m_last_digit) {
            io.print(n_last_digit);
            n /= 10;
            m /= 10;
            n_last_digit = n % 10;
            m_last_digit = m % 10;
            if (n_last_digit == m_last_digit) {
                io.print(n_last_digit);
                n /= 10;
                m /= 10;
                n_last_digit = n % 10;
                m_last_digit = m % 10;
                io.print(Math.max(n_last_digit, m_last_digit));
            } else {
                if (n_last_digit > m_last_digit) {
                    printNumberReverse(n);
                } else {
                    printNumberReverse(m);
                }
            }
        } else {
            if (n_last_digit > m_last_digit) {
                printNumberReverse(n);
            } else {
                printNumberReverse(m);
            }
        }
        io.close();
    }


    public static void main(String args[]) {
        setup();
    }
}
