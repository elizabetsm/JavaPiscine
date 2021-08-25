public class Program {
    public static void main(String[] args) {
        User user1 = new User("aaa", 918634);
        User user2 = new User("bbb", 9816);
        User user3 = new User("ccc", 13876);

        TransactionsList list = new TransactionsLinkedList();
        user1.setTransactionsList(list);
        user2.setTransactionsList(list);
        user3.setTransactionsList(list);


        Transaction transaction1 = Transaction.createTransaction(user2, user1, TransactionType.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(user1, user2, TransactionType.DEBIT, 500);
        Transaction transaction3 = Transaction.createTransaction(user2, user3, TransactionType.CREDIT, -500);
        Transaction transaction4 = Transaction.createTransaction(user3, user2, TransactionType.DEBIT, 500);


        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);

        System.out.println("-------------------");
        System.out.println("Transactions");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
        System.out.println("delete");
        System.out.println(list.remove(transaction2.getIdentifier().toString()));
        System.out.println("-------------------");
        System.out.println("after");
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println("-------------------");
        list.remove("");
    }
}
