public class Program {
    public static void main(String[] args) {
        int num = 479598;
        int digitSum = 0;

        digitSum += num%10;
        num = num/10;

        digitSum += num%10;
        num = num/10;

        digitSum += num%10;
        num = num/10;

        digitSum += num%10;
        num = num/10;

        digitSum += num%10;
        num = num/10;

        digitSum += num%10;
        num = num/10;

        System.out.println(digitSum);
    }
}