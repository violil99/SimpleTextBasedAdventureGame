  /**
   *
   * Class: Action
   *
   * description: This class performas actions as a character. In my game,
   * only the player uses the actions class, but this class
   * could control other characters in a more complicated game.
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
   * character performs actions.
   *
   * Constructors:
   * public Action(Character character)
   * set character
   * 
   *
   * Methods:
   * public void  look(char directionC)
   * looks int the direction given. n= north, s=south etc
   * 
   * public void look()
   * looks in the room that the character is in
   * 
   * public void move(char directionC)
   * moves in the given direction if there is a door.
   * Otherwise, prints a message. 
   * 
   * public Direction setDirection(char direction)
   * returns a direction object based on the char direction
   * 
   * public void takeBite(Item item)
   * takes a bit of an item. item bites will be decreased
   * and character size will change if the item does that.
   * If the item is not edible, a message will print
   * 
   * public void printSize()
   * prints the size of the character
   * 
   * public Character takeItem(Item item, Location location)
   * takes the given item if it is in the location or if a 
   * character in the given location is holding that item. returns
   * a the character that the item is taken from or null if the
   * item was taken from the room. for continuity, it is imprtant
   * that the location the location that the character is in.
   * 
   * public void takeItem(Item item, Character character)
   * takes item from character
   * 
   * public void giveItem(Item item, Character character)
   * gives item to character. prints message if item is not
   * in your inventory
   * 
   * public void giveItem(Item item, Location location)
   * drops item. prints message if item is not in inventory
   * 
   * public void giveItem(Item item, Location location, char direction)
   * drops an item in a location, placing it in a specific 
   * direction in that location
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   *
   */


public class Action{
    Character character;
    
    public Action(Character character){
        this.character=character;
    }


    public void  look(char directionC){
        Direction direction = setDirection(directionC);
        direction.look();
        
    }

    public Character getCharacter(){
        return character;
    }
        
    
    public void look(){
        character.getLocation().look();
    }


    public void move(char directionC){
        Direction direction = setDirection(directionC);
        if (direction.getHasDoor()){
            direction.getDoor().useDoor(character,direction);
        }
        else{
            System.out.println("You cannot go any farther in this direction");
        }
    }

    public Direction setDirection(char direction){
        Direction returnDirection;
        switch(direction){
            case 'n': returnDirection = character.getLocation().n;
            break;
            case 'e': returnDirection = character.getLocation().e;
            break;
            case 's': returnDirection = character.getLocation().s;
            break;
            case 'w': returnDirection = character.getLocation().w;
            break;
            case 'u': returnDirection = character.getLocation().u;
            break;
            case 'd': returnDirection = character.getLocation().d;
            break;
            default: 
            returnDirection = character.getLocation().d;
            System.out.println("INVALID DIRECTION!!!!!");
            System.exit(1);
        }
        return returnDirection;

    }

  
    public void takeBite(Item item){
        item.takeBite(character);

    }
    public void printSize(){
        System.out.println(character.sizeString());
    }


    public Character takeItem(Item item, Location location){
        for (Character person :location.getCharacters()){
            if (person.getHolding().contains(item)){
                person.getHolding().remove(item);
                character.takeItem(item);
                System.out.println("You have added "+item.getName()+" to your hand");     
                return person;            
            }
        }
        if (location.getHolding().contains(item)){
            location.getHolding().remove(item);
            character.takeItem(item);
            for (Direction direction:location.directions){
                if(direction.getItems().contains(item)){
                    direction.getItems().remove(item);
                }
            }
            System.out.println("You have added "+item.getName()+" to your hand");
        }
        else{
            System.out.println("There is no item of that type in this room");
        }
        return null;
    }

    public void takeItem(Item item, Character character){
        if (character.getHolding().contains(item)){
            character.getHolding().remove(item);
            this.character.takeItem(item);
            System.out.println("You have added "+item.getName()+" to your hand");

        }
        else{
            System.out.println("The character is not holding an item of that type");
        }
    }
    public void giveItem(Item item, Character character){
        if (this.character.getHolding().contains(item)){
            this.character.getHolding().remove(item);
            character.takeItem(item);
            System.out.println("You have given the "+item.getName()+" to "+ character.getName());
        }
        else{
            System.out.println("The item you are hoping to give is not in "+
            "your inventory");
        }
    }
    public void giveItem(Item item, Location location){
        if (character.getHolding().contains(item)){
            character.getHolding().remove(item);
            location.takeItem(item);
            System.out.println("You have dropped the "+item.getName()+ " in "+location.getName());
        }
        else{
            System.out.println("The item you are hoping to drop is not in "+
            "your inventory");
        }
    }

    public void giveItem(Item item, Location location, char direction){
        if (character.getHolding().contains(item)){
            character.getHolding().remove(item);
            location.takeItem(item,direction);
            System.out.println("You have dropped the "+item.getName()+ " in "+location.getName());
        }
        else{
            System.out.println("The item you are hoping to drop is not in "+
            "your inventory");
        }
    }

}
    


