public class Main {
    public static void main(String[] args) {
        Worker robot = new Robot();
        Worker humanWorker = new Human();
        Eater humanEater = (Eater) humanWorker;

        robot.work();
        humanWorker.work();
        humanEater.eat();
    }
}
