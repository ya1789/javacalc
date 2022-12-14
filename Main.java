import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Main {

    enum Roman {
        I(1), II(2), III(3),
        IV(4), V(5), VI(6),
        VII(7), VIII(8), IX(9), X(10);
        int num;
        Roman(int n) {
            this.num = n;
        }
        int toInt() {
            return num;
        }
    }

    static int getResult(String symbol, int n1, int n2) throws Exception {
        if (n1 <= 10 && n2 <= 10) {
            switch (symbol) {
                case "-":
                    return n1 - n2;
                case "+":
                    return n1 + n2;
                case "*":
                    return n1 * n2;
                case "/":
                    return n1 / n2;
                default:
                    throw new Exception();
            }
        } else throw new Exception();
    }

    static int toArabic(String n1) {
        return Roman.valueOf(n1).toInt();
    }

    static String toRoman(int n1) throws Exception {
        if (n1 <= 0) throw new Exception();
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(n1 >= values[i])
            {
                n1 = n1 - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

    public static String calc(String input) throws Exception {
        String[] a = input.split(" ");
        if (a.length != 3) throw new Exception();
        if (StringUtils.isNumeric(a[0]) && StringUtils.isNumeric(a[2]))
        {
            return String.valueOf(getResult(a[1], Integer.parseInt(a[0]), Integer.parseInt(a[2])));
        } else if (!StringUtils.isNumeric(a[0]) && !StringUtils.isNumeric(a[2])) {
            return toRoman(getResult(a[1], toArabic(a[0]), toArabic(a[2])));
        } else throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        System.out.println(m.calc(line));
    }
}
