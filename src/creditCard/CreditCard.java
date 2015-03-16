package creditCard;

import java.util.Scanner;

public class CreditCard {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int count=0;
		long array[]=new long[16];
		System.out.println("Enter a credit card number:");
		long number = input.nextLong();
	
	if (isValid(number)){
		System.out.println("this cc number is valid");
		}
	else {
		System.out.println("this cc number is invalid");
	}
	}
public static boolean isValid(long number) {

    return (getSize(number) >= 13) && (getSize(number) <= 16)
            && (prefixMatched(number, 4) || prefixMatched(number, 5)
            || prefixMatched(number, 6) || prefixMatched(number, 37))
            && (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
}

public static int sumOfDoubleEvenPlace(long number) {

    int result = 0;

    String digits = Long.toString(number);
    for (int i = digits.length() - 2; i > -1; i -= 2) {
        result += Integer.parseInt("" + digits.charAt(i));
    }

    return result;

}

public static int getDigit(int number) {

    return number % 10 + (number / 10);

}

public static int sumOfOddPlace(long number) {

    int result = 0;

    while (number != 0) {

        result += (int) (number % 10);

        number = number / 100;

    }

    return result;

}

public static boolean prefixMatched(long number, int d) {

    return getPrefix(number, getSize(d)) == d;

}

public static int getSize(long d) {

    int numberOfDigits = 0;

    String sizeString = Long.toString(d);
    numberOfDigits = sizeString.length();

    return numberOfDigits;

}
public static long getPrefix(long number, int k) {
long result=number;
for (int i=0; i<getSize(number)-k; i++)
	result/=10;
return result;
}
}