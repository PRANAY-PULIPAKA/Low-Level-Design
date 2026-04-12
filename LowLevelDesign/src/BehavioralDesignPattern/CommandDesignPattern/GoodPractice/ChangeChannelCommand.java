package BehavioralDesignPattern.CommandDesignPattern.GoodPractice;
//4th
public class ChangeChannelCommand implements Command{

    private TV tv;
    private int channel;

    public ChangeChannelCommand(TV tv, int channel){
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
          tv.changeChannel(channel);
    }
}
