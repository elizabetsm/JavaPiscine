public class Program {
    public static void main(String[] args) {
        User user1 = new User("aaa", 10000);
        User user2 = new User("bbb", 100000);
        User user3 = new User("ccc", -100000);
        User user4 = new User("ddd", 10);
        User user5 = new User("eee", 974);
        User user6 = new User("fff", 0);
        User user7 = new User("ggg", 327450183);
        User user8 = new User("hhh", -1);

        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());
        System.out.println(user4.getIdentifier());
        System.out.println(user5.getIdentifier());
        System.out.println(user6.getIdentifier());
        System.out.println(user7.getIdentifier());
        System.out.println(user8.getIdentifier());
    }
}
