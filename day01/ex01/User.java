public class User {
    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
        identifier = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return name + " (" + identifier + ") balance" + balance;
    }
}
