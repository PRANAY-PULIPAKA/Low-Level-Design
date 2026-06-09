package CreationalDesignPatterns.PrototypeDesignFactory.GoodPractice;

public class CharacterFactory {

    private Character prototypeCharacter;

    public CharacterFactory(){
        prototypeCharacter =
                new Character("DefaultName", 100, 50, 1); // Default prototype character
    }

    public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {

        Character cloned = prototypeCharacter.clone();
        cloned.setName(name);
        return cloned;
    }

    public Character createCharacterWithNewLevel(int level) throws CloneNotSupportedException {

        Character cloned = prototypeCharacter.clone();
        cloned.setLevel(level);
        return cloned;

    }
}
