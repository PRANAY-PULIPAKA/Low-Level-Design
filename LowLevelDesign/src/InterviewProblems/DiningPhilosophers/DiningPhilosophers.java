package InterviewProblems.DiningPhilosophers;

public class DiningPhilosophers {

    public static void main(String[] args) {

        int n = 5 ;
        Fork [] forks = new Fork[n];
        Philosophers [] philosophers = new Philosophers[n];

        for(int i = 0; i < n ; i++){
            forks[i] = new Fork();
        }

        for(int i = 0; i<n; i++){
            philosophers[i] =  new Philosophers(i, forks[i], forks[(i+1)%n]);

            new Thread(philosophers[i]).start();

        }

    }
}
