package ex1;

public class MyMath {

    public MyMath() {
    }

    public static double cos(double x) {
        x = x % (2 * Math.PI);

        double term = 1.0;
        double sum = 0.0;

        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) sum += term;
            if (i % 4 == 3) sum -= term;
        }
        return sum;
    }

    public static String decimalTo(String number, int outRadix) {
        return toRadix(number, 10, outRadix);
    }

    public static double exp(double x) {
        double sum = 0.0;
        double power = 1.0;
        double factorial = 1.0;
        sum += 1.0;
        for (int i = 1; i < 10; i++) {
            power = power * x;
            factorial = factorial * i;
            sum += power / factorial;
        }
        return sum;
    }

    public static String toRadix(String in, int inRadix, int outRadix) {
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTVUWXYZ";
        if (inRadix < 0 || inRadix > 16 || outRadix < 0 || outRadix > 16)
            throw new IllegalArgumentException("Illegal Argument Exception!!!");
        if (inRadix == outRadix) {
            return in;
        }
        int result = 0;
        for (int i = in.length() - 1; i >= 0; i--) {
            int digit = Character.digit(in.charAt(i), inRadix);
            result += digit * Math.pow(inRadix, (in.length() - 1 - i));
        }
        String str = "";
        if (outRadix == 0) {
            return str;
        }

        while (result > 0) {
            str = alphabet.charAt(result % outRadix) + str;
            result /= outRadix;
        }
        return str;
    }

    public static String toDecimal(String str, int radix) {
        String str_uppercase = str.toUpperCase();
        int check = 0;
        for (int charIdx = 0; charIdx < str.length(); charIdx++) {
            if (radix >= 10) {
                if (!Character.isLetter(str.charAt(charIdx)) && !Character.isDigit(str.charAt(charIdx))) {
                    check++;
                    break;
                } else if ((str_uppercase.charAt(charIdx) < 'A' || str_uppercase.charAt(charIdx) > (char) ('F' - 16 + radix)) && (str_uppercase.charAt(charIdx) < '0' || str_uppercase.charAt(charIdx) > '9')) {
                    check++;
                    break;
                }
            } else {
                if (Character.isLetter(str.charAt(charIdx)) || str.charAt(charIdx) < '0' || str.charAt(charIdx) > (char) (radix - 1 + '0')) {
                    check++;
                    break;
                }
            }
        }
        if (check == 0) {
            int result = 0;
            int decimal;
            for (int charIdx = 0; charIdx < str.length(); charIdx++) {
                char ch = str.charAt(charIdx);
                if (Character.isLetter(str.charAt(charIdx))) decimal = Integer.parseInt(String.valueOf(ch), 16);
                else decimal = ch - '0';
                result += decimal * Math.pow(radix, str.length() - (charIdx + 1));
            }
            return Integer.toString(result);
        } else {
            return "Can not convert!!!";
        }
    }

    public static void main(String[] args) {
        String str = "123456789123456789";
        System.out.println(toRadix(str, 13, 8));
        System.out.println(exp(2.2)*cos(3.3));
    }
}


