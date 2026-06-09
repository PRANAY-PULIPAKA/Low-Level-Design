package CreationalDesignPatterns.AbstractFactoryDesignPattern.GoodPractice;

public interface Vehicle {

    void start();
    void stop();
}

class Honda implements Vehicle{
    @Override
    public void start() {
        System.out.println("Honda starting");
    }
    @Override
    public void stop() {
        System.out.println("Honda stopping");
    }
}

class Toyota implements Vehicle{
    @Override
    public void start() {
        System.out.println("Toyota starting");
    }
    @Override
    public void stop() {
        System.out.println("Toyota stopping");
    }
}

class BMW implements Vehicle{
    @Override
    public void start() {
        System.out.println("BMW starting");
    }
    @Override
    public void stop() {
        System.out.println("BMW stopping");
    }
}
