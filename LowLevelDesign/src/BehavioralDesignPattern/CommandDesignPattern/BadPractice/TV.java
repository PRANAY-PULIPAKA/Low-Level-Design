package BehavioralDesignPattern.CommandDesignPattern.BadPractice;

public class TV {

    public void turnOn(){
        System.out.println("TV is ON");
    }

    public void turnOff(){
        System.out.println("TV is off");
    }

    public void changeChannel(int channel){
        System.out.println("Channel changed to "+ channel);
    }

    public void adjustVolume(int volume){
        System.out.println("Volume set to " + volume);
    }
}
class RemoteControl{
    TV tv;

    public RemoteControl(TV tv){
        this.tv = tv;
    }

    public void pressOnButton(){
        tv.turnOn();
    }
    public void pressOffButton(){
        tv.turnOff();
    }

    public void pressChannelChange(int channel){
        tv.changeChannel(channel);
    }

    public void pressVolumeButton(int volume){
        tv.adjustVolume(volume);

    }
}