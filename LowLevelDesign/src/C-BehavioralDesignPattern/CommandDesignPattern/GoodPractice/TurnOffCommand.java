package BehavioralDesignPattern.CommandDesignPattern.GoodPractice;

//3rd
public class TurnOffCommand implements Command{

    private TV tv;

    public TurnOffCommand(TV tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
      tv.turnOff();
    }
}
