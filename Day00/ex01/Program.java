import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int operationsNum = 1;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if (num <= 1){
            System.err.println("Illegal Argument");
            System.exit(-1);
        }

        boolean isPrime = true;
        for (int i = 2; i*i <= num; i++) {

            if (num % i == 0) {
                isPrime = false;
                break;
            }
            operationsNum++;

        }
        System.out.println(isPrime + " " + operationsNum);
    }
}