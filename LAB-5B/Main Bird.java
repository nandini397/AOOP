public class Main {
    public static void main(String[] args) {
        Bird genericBird = new Bird();
        Ostrich ostrich = new Ostrich();

        genericBird.fly();  // Works fine
        
        try {
            ostrich.fly();  // Throws exception
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
