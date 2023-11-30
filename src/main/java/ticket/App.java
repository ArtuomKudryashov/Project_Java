package ticket;

public class App {
    public static void main(String[] args) {
        Tickets infant = new Tickets(5,1000);
        System.out.println(infant.getPrice());
    }
}
