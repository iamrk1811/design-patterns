package patterns.structural;
import java.util.HashMap;

/*
 * FlyWeight: helps minimize memory usage by sharing as much as data possible between similar objects.
 */

// Flyweight Interface
interface Character {
    void display(int size);
}

// Concrete Flyweight
class CharacterA implements Character {
    private final String letter = "A"; // Intrinsic state

    @Override
    public void display(int size) { // Extrinsic state
        System.out.println("Displaying " + letter + " with font size " + size);
    }
}

// Flyweight Factory
class CharacterFactory {
    private static final HashMap<String, Character> characters = new HashMap<>();

    public static Character getCharacter(String letter) {
        Character character = characters.get(letter);
        if (character == null) {
            switch (letter) {
                case "A":
                    character = new CharacterA();
                    break;
                // Add cases for other letters
            }
            characters.put(letter, character);
        }
        return character;
    }
}
 

class ClientFlyWeight {
     public static void main(String[] args) {
         Character character1 = CharacterFactory.getCharacter("A");
         character1.display(12);
 
         Character character2 = CharacterFactory.getCharacter("A");
         character2.display(16);
 
         System.out.println(character1 == character2); // true
     }
 }
 