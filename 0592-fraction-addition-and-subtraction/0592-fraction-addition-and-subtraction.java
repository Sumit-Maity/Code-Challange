class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;

        int i = 0;
        int n = expression.length();

        while (i < n) {
            int sign = 1;

            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = (expression.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            num *= sign;

            i++; 
            int den = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + (expression.charAt(i) - '0');
                i++;
            }
            numerator = numerator * den + num * denominator;
            denominator = denominator * den;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}