package Week2.BoxMatch;

public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Khabib", 20, 120, 85,30);
        Fighter f2 = new Fighter("McGregor", 15, 140, 80,40);

        Match match = new Match(f1, f2, 90, 75);
        match.run();
    }


}
