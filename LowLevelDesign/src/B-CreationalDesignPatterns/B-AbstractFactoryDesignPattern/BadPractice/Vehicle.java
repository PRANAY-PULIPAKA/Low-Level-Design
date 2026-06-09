package CreationalDesignPatterns.AbstractFactoryDesignPattern.BadPractice;

public interface Vehicle {
    void start();
    void stop();
}

class Honda implements Vehicle{
    @Override
    public void start() {
        System.out.println("Honda Car started");
    }

    @Override
    public void stop() {
        System.out.println("Honda Car stopped");
    }
}

class Toyota implements Vehicle{
    @Override
    public void start() {
        System.out.println("Toyota Car started");
    }

    @Override
    public void stop() {
        System.out.println("Toyota Car stopped");
    }
}
class BMW implements Vehicle{
    @Override
    public void start() {
        System.out.println("BMW Car started");
    }

    @Override
    public void stop() {
        System.out.println("BMW Car stopped");
    }
}

