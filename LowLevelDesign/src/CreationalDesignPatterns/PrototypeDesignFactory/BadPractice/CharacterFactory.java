package CreationalDesignPatterns.PrototypeDesignFactory.BadPractice;

public class CharacterFactory {

    public Character createCharacterWithNewName(String name){
        return  new Character(name, 100, 50,1);
    }

    public Character createCharacterWithNewLevel(int  level){
        return  new Character("DefaultName", 100, 50,level);
    }

    public Character createCharacterWithNewAttackPower(int attckPower){
        return new Character("DefaultName", 100, attckPower, 1);
    }
}
