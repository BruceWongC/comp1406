public class CustomerTestProgram {
    public static void main(String args[]) {
        Customer c;
        c = new Customer("Bob");
        c.name = "Bob";
        c.age = 27;
        c.money = 50;

        Customer b;
        b = new Customer("Joe");
        b.name = "Joe";
        b.age = 42;
        b.money = 420;

        System.out.println(c.name);
        System.out.println(c.age);
        System.out.println(c.money);

        System.out.println();

        System.out.println(b.name);
        System.out.println(b.age);
        System.out.println(b.money);
    }
}