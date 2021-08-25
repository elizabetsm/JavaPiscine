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

        UsersList list = new UsersArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user8);

        System.out.println(list.getByIndex(0) + " == " + user1);
        System.out.println(list.getByIndex(user2.getIdentifier()) + " == " + user2);
        System.out.println("count = " + list.getAll());

        User user9 = new User("iii", -100000);
        System.out.println(list.getById(3));
        System.out.println(list.getById(user9.getIdentifier()));
    }
}
