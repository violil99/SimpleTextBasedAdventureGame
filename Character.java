  /**
   *
   * Class:Character
   *
   * Your Class Name
   * creates character objects
   *
   * Variables:
   *     private Location location;
   * holds the location of the character
   * 
    private int size;
    size of character

    private ArrayList<Item> holding;
    the character's inventory

    private String name;
    the character's name

    private String description;
    a description of the character

    private String openingLine;
    the character's opening line

    private String thanks;
    the line a character says after you return their
    missing item
   *
   * Constructors:
   * public Character(String name,Location location)
   * creates a character in the given location with
   * generic size,description,openingLine, and thanks.
   * 
   * public Character(String name,Location location, 
   * String description, String openingLine,String thanks)
   * creates a character in the given location, setting
   * size,description,openingLine, and thanks.
   * 
   * public Character(String name, Location location, int size)
   * creates a character in the given location setting
   *  size, and with generic description,openingLine, 
   * and thanks.
   *
   * Methods:
   * -public void printThanks()
   * 
   * generic get and sets
   * 
   * public String sizeString()
   * returns the size as a big if size
   * is 8 or higher, small if size is 4
   * or smaller, and normal for anything
   * in between
   * 
   * public void takeItem(Item item)
   * adds item to inventory
   * 
   * public void dropItem(Item item)
   * removes item if in inventory. prints
   * message if not
   * 
   * public void printHolding()
   * prints inventory
   * 
   * public void printDescription()
   * prints name, description,and inventory
   * 
   * public void takeBiteBigger()
   * increases size by 1
   * 
   * public void takeBiteSmaller()
   * decreases size by 1
   * prints a message if the character is getting
   * small
   * ends game and prints GAME OVER if the character size 
   * reaches 0
   *
   */


import java.util.ArrayList;

public class Character{
    private Location location;
    private int size;
    private ArrayList<Item> holding;
    private String name;
    private String description;
    private String openingLine;
    private String thanks;
    
    
    public Character(String name,Location location){
        this.location = location;
        size =5;
        holding = new ArrayList<Item>();
        this.name = name;
        description = "A character";
        openingLine = "Hello!";
        thanks = "Thanks!";
    }

    public Character(String name,Location location, String description, String openingLine,String thanks){
        this.location = location;
        size =5;
        holding = new ArrayList<Item>();
        this.name = name;
        this.description=description;
        this.openingLine = openingLine;
        this.thanks=thanks;
    }
    public Character(String name, Location location, int size){
        this.location = location;
        this.size = size;
        holding = new ArrayList<Item>();
        this.name =name;
    }

    public void printThanks(){
        System.out.println("\n"+name+" says: "+thanks);
    }
  

    public void setOpeningLine(String newLine){
        openingLine=newLine;
    }
    public String getOpeningLine(){
        return openingLine;
    }
    public void printOpeningLine(){
        System.out.println(openingLine);
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }

    public int getSize(){
        return size;
    }

    public String sizeString(){
        if (size>7){
            return "big";
        }
        if (size<5){
            return "small";
        }
        return "normal";
    }

    public ArrayList getHolding(){
        return holding;
    }

    public void takeItem(Item item){
        holding.add(item);
    }

    public void dropItem(Item item){
        if (holding.contains(item)){
            holding.remove(item);
        }
        else{
            System.out.println("The character is not holding an item of that type");
        }
    }

    public void printHolding(){
        if (holding.size()==0){
            
                System.out.println(name+" is not holding anything");
        }
        else{
            System.out.println(name+" is holding: ");
            for (Item item : holding){
                System.out.println(item.getName());
                if (item instanceof ConsumableItem){
                    System.out.println(" ("+item.getBites()+" bites left)");
                }
                }
            }
    }

    public void printDescription(){
        System.out.println(name+" "+description);
        printHolding();
    }

    public void takeBiteBigger(){
        size++;
    }
    public void takeBiteSmaller(){
        size--;
        if (size<3){
            System.out.println("Watch out! you're getting pretty small");
        }
        if (size<=0){
            System.out.println("GAME OVER");
            System.exit(0);
        }
    }

}