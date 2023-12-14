 /**
   *
   * Class:Door
   *
   * description: 
   * The door class creates door objects to connect two
   * rooms. These door objects only hold the information
   * about which room is being entered and can threrfore
   * be used to connect multiple rooms
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
    private final String doorName - holds
    a string saying "door to <ROOM ENTERED>"

    private final Location entering
    The location the door leads to

    private final int size
    The size of the door. A character must be smaller than
    the door size to fit through

    private int minSize
    The minimum size a character can be in order to fit 
    through the door

   * Constructors:
   * public Door(Location entering,int size)
   * creates a door with size set to the given int
   * and entering set to the given location. sets 
   * doorname using entering and minSize to 0
   * 
   * public Door (Location entering)
   * does the same as the other constructor but sets
   * size to 100
   * 
   *
   * Methods:
   * generic get and set methods
   * 
   * look()
   * prints doorName
   * 
   * useDoor()
   * prints error messages if there are items in
   * the way of the door or if the character is too
   * small/big to go through
   * 
   * If the door is accessible and the character fits,
   * prints a description of going through the door,
   * sets the character's location to the new location,
   * and uses the Location.enter() method to display
   * the name of the new location and any character
   * lines necessary
   *    
   */



public class Door{
    private final String doorName;
    private final Location entering;
    private final int size;
    private int minSize;

    public Door(Location entering,int size){
        this.entering = entering;
        this.size = size;
        doorName = "Door to "+entering.getName();
        minSize=0;
    }
    public Door (Location entering){
        this.entering = entering;
        this.size =100;
        doorName = "Door to "+entering.getName();
        minSize=0;
    }

    public void setMinSize(int minSize){
        this.minSize=minSize;
    }

    public String getDoorName(){
        return doorName;
    }
    public Location getEntering(){
        return entering;
    }

    public void look(){
        System.out.println(doorName);
    }

    public void useDoor(Character character,Direction direction){
        if (direction.getItems().size()>0){
            System.out.println("There is something in front of the door! Try moving it before going through");
            return;
        }
        if (character.getSize()<size&&character.getSize()>minSize){
            direction.printThroughDoor();
            character.setLocation(entering);
            entering.enter();
        }
        else{
            if(character.getSize()>=size){
                System.out.println("You're too big to fit through this door");
                System.out.println("HINT: Try a drink to help you shrink ;)");
            }
            else{
                System.out.println("This door is REEEEAAALLY heavy");
                System.out.println("HINT: Cake will make you bigger");
            }
        }
    }
}

