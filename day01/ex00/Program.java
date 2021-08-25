public class Program {
    public static void main(String[] args) {
        User user1 = new User("qwerty", 10_000);
        user1.setIdentifier(1);
        User user2 = new User("ytrewq", 100_000);
        user2.setIdentifier(2);

        Transaction transaction1 = Transaction.createTransaction(user2, user1, TransactionType.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(user1, user2, TransactionType.DEBIT, 500);

        System.out.println(transaction1);
        System.out.println(transaction2);

        user1.setBalance(user1.getBalance() - 500);
        user2.setBalance(user2.getBalance() + 500);

        System.out.println(user1.getName()+ ' ' + user1.getBalance());
        System.out.println(user2.getName()+ ' ' + user2.getBalance());


        transaction1 = Transaction.createTransaction(user1, user2, TransactionType.DEBIT, -5_000);
        System.out.println(transaction1);

        transaction1 = Transaction.createTransaction(user1, user2, TransactionType.DEBIT, 500_000);
        System.out.println(transaction1);


    }
}
