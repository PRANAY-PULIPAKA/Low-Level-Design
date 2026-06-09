package CreationalDesignPatterns.SingletonDesignPattern.BadPractice;

public class Application {

    public static void run() {
        Logger logger = new Logger();
        logger.log("Application started");
    }

    //Every time run method is called new object is created
}

