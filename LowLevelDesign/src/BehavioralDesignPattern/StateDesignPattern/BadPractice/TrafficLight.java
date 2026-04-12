package BehavioralDesignPattern.StateDesignPattern.BadPractice;

public class TrafficLight {
    private String color;

    public TrafficLight(){
        this.color = "RED";
    }
    public void next(){

        if(color.equals("RED")){
            color = "GREEN";
            System.out.println("Light changed from RED to GREEN. Cars go!");
        } else if(color.equals("GREEN")) {
            color = "YELLOW";
            System.out.println("Light changed from GREEN to YELLOW. Slow down!");
        } else if(color.equals("YELLOW")) {
            color = "RED";
            System.out.println("Light changed from YELLOW to RED. Stop!");
        }
    }

    private String getColor() {
        return  color;
    }
}
