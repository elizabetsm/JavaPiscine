import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int sumOfDigits = 0;
        int coffeeQueryCounter = 0;
        while (input != 42){
            input = scanner.nextInt();
            sumOfDigits = getSumOfDigits(input);
            if (isSumPrime(sumOfDigits)){
                coffeeQueryCounter++;
            }
        }
        System.out.println("Count of coffee-request - " + coffeeQueryCounter);
    }

    static int getSumOfDigits(int input){
        int sum = 0;
        while (input > 0){
            input = input/10;
            sum++;
        }
        return sum;
    }

    static boolean isSumPrime(int sum){
        boolean isPrime = true;
        for (int i = 2; i*i <= sum; i++) {
            if (sum % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}