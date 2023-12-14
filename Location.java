 /**
   *
   * Class: Location
   *
   * description: The Location class is a location that holds game characters
   * and items. 
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
    private final String name;
    the name of the location. i.e. The Duchess's House

    private ArrayList<Door> doors;
    All of the door objects in the location

    private ArrayList<Item> holding;
    All the items in the location (not including those
    that characters are holding)

    private String roomDescription;
    A description of the location

    private ArrayList<Character> characters;
    The characters in the location

    The direction objects in the room:
    final Direction n;
    final Direction e;
    final Direction s;
    final Direction w;
    final Direction u;
    final Direction d;

    those directions put into a list
    final ArrayList<Direction> directions;
   *
   * Constructors:
   * public Location(String name, String roomDescription)
   * sets name and roomDescription, and creates empty 
   * arraylists for doors,holding,and characters. creates 
   * direction objects and puts them in a list.
   *
   * Methods:
  
   * generic get and set methods
   * 
   * public void printCharacters()
   * If there are no characters, prints a relevant statement.
   * If there are characters, prints the characters and their 
   * items (self is not added to characters, and therefore is
   * not printed here)
   * 
   * public void enter()
   * prints "you have entered <NAME>" and any relevant 
   * statements from characters in the room
   * 
   * public void look()
   * prints room description as well as the items and characters in
   * the room
   * 
   * public void takeItem(Item item)
   * the location takes an item. The item is added to
   * holding and put in a random direction in the room
   * 
   * public void takeItem(Item item,char direction1)
   * ther same as the method above, but the item is placed
   * in the direction provided
   * 
   * public void dropItem(Item item)
   * removes the item from holding. if the item does not
   * exist in holding, a message is displayed
   * 
   * public void printHolding()
   * prints the items in a room or prints a message if there
   * are no items in the room
 
   *
   */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Location{
    private final String name;
    private ArrayList<Door> doors;
    private ArrayList<Item> holding;
    private String roomDescription;
    private ArrayList<Character> characters;
    final Direction n;
    final Direction e;
    final Direction s;
    final Direction w;
    final Direction u;
    final Direction d;
    final ArrayList<Direction> directions;
    

    public Location(String name, String roomDescription){
        this.name = name;
        this.roomDescription = roomDescription;
        doors = new ArrayList<Door>();
        holding = new ArrayList<Item>();
        characters = new ArrayList<Character>();
        this.n = new Direction('n',this);
        this.e = new Direction('e',this);
        this.s = new Direction('s',this);
        this.w = new Direction('w',this);
        this.u = new Direction('u',this);
        this.d = new Direction('d',this);
        directions = new ArrayList<Direction>(
            Arrays.asList(n,s,e,w,u,d)
        );
    }

   

    public void addCharacter(Character character){
        characters.add(character);
    }

    public ArrayList<Character> getCharacters(){
        return characters;
    }

    public void printCharacters(){
        if (characters.size()==0){
            System.out.println("\nThere are no characters in this location");
        }
        else{
            System.out.println("\nIn this location there are these characters:");
            for (Character character:characters){
                character.printHolding();
            }
        }
    }





    public void enter(){
        System.out.println("You have now entered "+name);
        for (Character character:characters){
            System.out.println(character.getName()+" says: "+character.getOpeningLine());
        }
    }

    public void look(){
        System.out.println(roomDescription);

        printHolding();

        printCharacters();
    }



    public void setDoor(Door door){
        doors.add(door);
    }
    public void setRoomDescription(String roomDescription){
        this.roomDescription = roomDescription;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Door> getDoors(){
        return doors;
    }
    public  String getRoomDescription(){
        return roomDescription;
    }

    public ArrayList getHolding(){
        return holding;
    }

    public void takeItem(Item item){
        Random random = new Random();
        int index = random.nextInt(3);
        holding.add(item);
        directions.get(index).setItem(item);
    }

    public void takeItem(Item item,char direction1){
        holding.add(item);
        for (Direction direction:directions){
            if(direction.getDirection()==direction1){
                direction.setItem(item);
            }
        }
        
    }

    public void dropItem(Item item){
        if (holding.contains(item)){
            holding.remove(item);
        }
        else{
            System.out.println("There is no item of that type in this location");
        }
    }

    public void printHolding(){
        if (holding.size()==0){
            System.out.println("\nThere are no items in this room");
        }
        else{
            System.out.println("\nIn this room there are these items: ");
            for (Item item : holding){
                System.out.println(item.getName());
            }
        }
    }

}