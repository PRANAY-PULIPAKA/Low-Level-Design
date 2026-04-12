package InterviewProblems.DiningPhilosophers;

public class Philosophers implements Runnable{
    private final int id;
    private final Fork leftFork;

    private final Fork rightFork;

    public Philosophers(int id, Fork leftFork, Fork rightFork){
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try{
            while(true){
                think();
                eat();
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void think() throws InterruptedException{
        System.out.println("Philosopher " + id + " thinking");
        Thread.sleep((long) Math.random() * 1000);
    }

    private void eat() throws InterruptedException{
        leftFork.pickUp();
        rightFork.pickUp();

        System.out.println("Philosopher " + id + " eating");
        Thread.sleep((long) Math.random() * 1000);
        leftFork.putDown();
        rightFork.putDown();
    }
}
