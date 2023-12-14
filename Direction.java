 /**
   *
   * Class: Direction
   *
   * description: The direction class holds descriptions and information
   * about each direction within a location
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
    private final char direction; 
    a character representing the direction (i.e. north='n')

    private final Location location;
    The location of the direction (north in one
    location must be different from north in another)

    private String description;
    a description of the direction

    private boolean hasDoor;
    true if there is a door, false if not

    private Door door;
    the door in that direction

    private String throughDoor;
    a description of going through the door
    i.e. You fall down, down, down the rabbit hole

    private ArrayList<Character> characters;
    a list of characters in the direction

    private ArrayList<Item> items;   
    a list of Items in the direction

   * Constructors:
   * public Direction(char direction, Location location)
   * sets location and direction to those given, hasdoor,
   * description, throughDoor, items, and characters are 
   * all set to the default/empty state to be set later on
   *
   * Methods:
   * genericget/set methods 
   * setItem/Character simply adds one object to the 
   * array
   * 
   * public void printCharacters()
   * prints a message if there are not characters
   * in Characters and prints a list of characters 
   * and what they are holding otherwise.
   * 
   * public void printHolding()
   * prints a message if there are no items
   * in Items and prints a list of items otherwise
   * 
   * look() 
   * if there is nothing in the direction or the
   * description is no longer set to the default, 
   * prints description, prints items and characters
   * when those lists are not empty
   * 
   * 
   * 
   *
   */




import java.util.ArrayList;

public class Direction{
    private final char direction;
    private final Location location;
    private String description;
    private boolean hasDoor;
    private Door door;
    private String throughDoor;
    private ArrayList<Character> characters;
    private ArrayList<Item> items;


    public Direction(char direction, Location location){
        this.direction = direction;
        this.location = location;
        hasDoor = false;
        description = "Nothing in that direction";
        throughDoor = "";
        items = new ArrayList<Item>();
        characters = new ArrayList<Character>();

    }

    public void setCharacter(Character character){
        characters.add(character);
    }
    public void setItem(Item item){
        items.add(item);
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public ArrayList<Character> getCharacters(){
        return characters;
    }
    
    public void printCharacters(){
        if (characters.size()==0){
            System.out.println("\nThere are no characters in this direction");
        }
        else{
            System.out.println("\nIn this direction there are these characters:");
            for (Character character:characters){
                System.out.println(character.getName());
                character.printHolding();
            }
        }
    }
        public void printHolding(){
        if (items.size()==0){
            System.out.println("\nThere are no items in this direction");
        }
        else{
            System.out.println("\nIn this direction there are these items: ");
            for (Item item : items){
                System.out.println(item.getName());
            }
        }
    }


    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setThroughDoor(String throughDoor){
        this.throughDoor=throughDoor;
    }

    public void printThroughDoor(){
        System.out.println(throughDoor);
    }

    public void look(){
        if (!((characters.size()>0||items.size()>0)&&description=="Nothing in that direction")){
            System.out.println(description);
        }
        if (characters.size()>0){
            printCharacters();
        }
        if (items.size()>0){
            printHolding(); 
        }
    }
    
    public void setDoor(Door door){
        this.door = door;
        hasDoor = true;
    }
    
    public Door getDoor(){
        return door;
    }
    
    public char getDirection(){
        return direction;
    }
    
    public boolean getHasDoor(){
        return hasDoor;
    }



}