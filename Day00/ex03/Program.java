import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resOftheWeek = 0;
        int multiplier = 1;

        for (int weeksNum = 1; weeksNum <=18; weeksNum++){
            String str = scanner.next();
            if (!str.equals("Week") && !str.equals("42")){
                IllegalArgumentErr();
            }
            if (str.equals("42")){
                break;
            }
            if (weeksNum != scanner.nextInt()){
                IllegalArgumentErr();
            }

            resOftheWeek += getResOfTheWeek(scanner) * multiplier;
            multiplier *= 10;
        }
        printResults(resOftheWeek);
    }

    static void printResults(int res){
        int resOfWeek = 0;
        int counter = 1;
        while (res > 0){
            resOfWeek = res%10;
            printLine(resOfWeek, counter);
            res = res/10;
            counter++;
        }

    }

    static void printLine(int res, int counter){
        System.out.print("Week " + counter);
        while (res > 0){
            System.out.print("=");
            res--;
        }
        System.out.println(">");
    }

    static void IllegalArgumentErr(){
        System.err.println("Illegal Argument");
        System.exit(-1);
    }

    static int getResOfTheWeek(Scanner scanner){
        int minRes = 9;
        int res = 0;

        for (int i = 0; i < 5; i++){
            res = scanner.nextInt();
            if (res < minRes){
                minRes = res;
            }
        }
        return minRes;
    }
}