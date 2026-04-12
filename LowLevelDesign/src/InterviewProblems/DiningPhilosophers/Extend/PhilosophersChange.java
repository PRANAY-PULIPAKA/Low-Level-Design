package InterviewProblems.DiningPhilosophers.Extend;

import InterviewProblems.DiningPhilosophers.Fork;

public class PhilosophersChange {
     class Philosophers implements Runnable{
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

            Fork first = leftFork ;
            Fork second = rightFork;

            if(System.identityHashCode(leftFork) > System.identityHashCode(rightFork)){
                first = rightFork;
                second = leftFork;
            }
            first.pickUp();
            second.pickUp();

            System.out.println("Philosopher " + id + " eating");
            Thread.sleep(1000);
            first.putDown();
            second.putDown();
        }
    }
}
