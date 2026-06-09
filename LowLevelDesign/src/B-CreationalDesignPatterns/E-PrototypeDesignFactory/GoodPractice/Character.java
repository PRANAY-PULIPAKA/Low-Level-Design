package CreationalDesignPatterns.PrototypeDesignFactory.GoodPractice;

public class Character implements Cloneable {

    private String name;
    private int health;

    private int attackPower;

    private int level;

    public Character(String name, int health, int attackPower, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.level = level;
    }

    public Character clone() throws CloneNotSupportedException {
        return (Character) super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void showCharacterInfo() {
        System.out.println("Character [Name=" + name + ", Health=" + health
                + ", AttackPower=" + attackPower + ", Level=" + level + "]");
    }


}
