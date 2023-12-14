 /**
   *
   * Class:Control
   *
   * description: The control takes in and parses command line
   * input from a user, executing valid commands
   * and displaying applicable error messages when
   * the user types invalid commands
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson

   *
   * Variables:
    Scanner scanner;
    a scanner which takes in user input

    ArrayList<String> inputStrings;
    a list of words given by the user

    Action action;
    an action object which helps parse input
    (I somehow misunderstood how to use the action class.
    If I were to rewrite this program, I would change my
    action class to be more useful and distinct from the
    control class)

    Game game; 
    the game object loaded with information

   * Constructors:
   *  public Control(Action action)
   * sets scanner and Action
   *
   * Methods:
   * public void setGame(Game game)
   * this method must be used before the Control
   * object can be properly used. The control object uses
   * the game object to function
   * 
   * public void getInput()
   * scans a line of input from the player, splits
   * it into an array, and then transfers the array
   * into an arrayList
   * 
   * public Character getCharacter()
   * returns the character corresponding to the
   * character in the user's input. If no character
   * name is recognized, returns null
   * 
   * public Item getItem(char action)
   * returns the item corresponding to the itemin the
   * user's input. If no item is recognized, returns 
   * null. for eatme and drinkme items, since there are
   * duplicates, this is slightly more complicated. If
   * the action (parsed with getVerb()) is take or move,
   * the item is returned if it exists in the room. If the
   * action is anything else, (give,look,drop) the item is
   * returned if it exists in the player's hand.
   * 
   * public char getVerb()
   * returns a char corresponding to the action verb the
   * user inputs. returns null if no input verb is recognized.
   * If the verb could be confused with an item, only the 
   * first input word is checked. (i.e. take 
   * drink would not accept drink as the verb). When the verb
   * could be confused with an item, the verb is removed from
   * the input strings after it is read.
   * 
   * public char getDirection()
   * returns a char corresponding to the direction from
   * the user input. Returns 0 if no direction is 
   * recognized.
   * 
   * public void parseInput()
   * 
   * disclaimer -- since writing this method, I have really
   * rethought my use of the Action class. If I rewrite this,
   * I will put most of what happens in the parseInput() method
   * into the Action class --
   * 
   * disclaimer -- this method ignores words that it doesn't 
   * understand. That means if the user types "take cake from 
   * duchess" all it is reading is "take cake duchess", but it 
   * also means that the user could write "take ice cream cake
   * from queen victoria's dog" and the program would just understand
   * "take cake queen" and take the eatme cake from the queen. --
   * 
   * -gets verb, character, item, and direction using the
   * methods described above. 
   * -checks if quit, inventory, size, or help are in the input
   * and executes applicable actions
   * -Through an if/else tree, performs the commands given by the user.
   * 
   * 
   * 
   * 
   * 
   *
   */



import java.util.*;

public class Control{
    Scanner scanner;
    ArrayList<String> inputStrings;
    Action action;
    Game game;

    
    public Control(Action action){
        scanner = new Scanner(System.in);
        this.action = action;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public void getInput(){
        String input;
        String[] inputArray;

        inputStrings=new ArrayList<String>();

        input = scanner.nextLine();
        input = input.toLowerCase();

        inputArray = input.split(" ");

        for (String string: inputArray){
            if (string==null){
                break;
            }
            else{
                inputStrings.add(string);
            }
        }
    }



    public void parseInput(){
        char verb = getVerb();
        Character character = getCharacter();
        Item item = getItem(verb);
        char direction = getDirection();

        

        if (inputStrings.contains("quit")){
            System.out.println("Good Bye!");
            System.exit(0);
        }
        if (inputStrings.contains("inventory")){
            if (character!=null){
                character.printHolding();
                return;
            }
            else{
                action.getCharacter().printHolding();
                return;
            }

        }
        if (inputStrings.contains("help")){

            System.out.println("The goal of this game is to return all items "+
            "to their rightful owners. \nMove north, south, east, and west to find characters and there items."+
            "Be careful not to get too small. The game will end if you shrink away");
            System.out.println("\nType \"more\" for more help");
            getInput();
            if (inputStrings.contains("more")){
                System.out.println("-To look at the location you are in, type \"look\". You can also"+
                " look in a specific direction \nor at a characters or item with the command \"look <DIRECTION/ITEM/CHARACTER>\""+
                "\nYou can only look at items which you are currently holding");
                System.out.println("-To move your character, try the command \"move <DIRECTION>\"");
                System.out.println("-To pick up an item, try \"take <ITEM>\"");
                System.out.println("-If you don't fit through a door, try eating or drinking a consumable item with the command \"eat <ITEM>\"."+
                "\nYou might need to use the eat command multiple times to reach the correct size.\nDon't worry though, "+
                "most consumable items have several bites!");
                System.out.println("-To give an item to a character, use the command \"give <ITEM>\" or \"give <ITEM> <CHARACTER>\"");
                System.out.println("-To drop and item, use the command \"drop <ITEM>\" or \"drop <ITEM> <DIRECTION>\" to drop the item in a specific spot");
                System.out.println("-To see what you or another character are holding, type \"inventory\" or \"inventory <CHARACTER>\"");
                System.out.println("-To talk to a character, try \"talk\" or \"talk <CHARACTER>\"");
            
            }
            return;
        }

        if (inputStrings.contains("size")){
            System.out.println(game.self.getSize());
        }

        
        if (verb=='0'){
            System.out.println("I didn't understand that command");
            return;
        }




        if (verb=='l'){

            if (inputStrings.size()==1){
                action.look();
                return;
            }
            //direction
            if (direction!='0'){
                action.look(direction);
                return;
            }
            //character
            if (character!=null){
                //check that the character is in the location
                if (character.getLocation()==action.getCharacter().getLocation()){
                    character.printDescription();
                    return;
                }
                else{
                    System.out.println("That character is not in this room");
                    return;
                }

            }
            //object
            if (item!=null){
                if(action.getCharacter().getHolding().contains(item)){
                    item.printDescription();
                    return;
                }
                else{
                    System.out.println("You can only look at items you are holding");
                    return;
                }
            }

            System.out.println("Please specify a direction, item, or character you would like to look at");
            System.out.println("Remember, you can only look at items you are holding");
            System.out.println("You can look at your current location by simply typing \"look\" with no other arguments");
            return;
        }

        if (verb=='m'){
            if (direction=='0'){
                if(item==null){
                    System.out.println("You have to specify an item you would like to move or a direction you would like to move in");
                    System.out.println("Remember, you can only move items in your current location");
                    return;
                }
                else{
                    Direction direction2=null;
                    for (Direction direction1:game.self.getLocation().directions){
                        if (direction1.getItems().contains(item)){
                            direction1.getItems().remove(item);
                            direction2=direction1;
                            break;
                        }
                    }
                    if (direction2==null){
                        System.out.println("Remember, you can only move items which are in your current location");
                        return;
                    }

                    if (direction2.getDirection()=='n'){
                        game.self.getLocation().s.getItems().add(item);
                    }
                    else{
                        game.self.getLocation().n.getItems().add(item);
                    }
                    return;
                }
            }
            if(item==null){
                action.move(direction);
                return;
            } 
            if(game.self.getLocation().getHolding().contains(item)){
                for (Direction direction1:game.self.getLocation().directions){
                    if(direction1.getItems().contains(item)){
                        direction1.getItems().remove(item);
                    }
                    if (direction1.getDirection()==direction){
                        direction1.getItems().add(item);
                    }
                }
                return;
            }
            else{
                System.out.println("A character is holding that item!");
                return;
            }
            
        }

        if (verb=='t'){
            if (item==null){
                System.out.println("Make sure to specify which item you would like to take");
                System.out.println("Remember, you can only take items which are in your current location");
                return;
            }
            
            if (character==null){
                character=action.takeItem(item,action.getCharacter().getLocation());
                    if (game.check.isMatch(item, character)){
                        System.out.println("Uh oh, the "+item.getName()+" belongs with "+character.getName());
                        System.out.println("Type \"yes\" if you would like to give the item back");
                        getInput();
                        if(inputStrings.contains("yes")){
                            action.giveItem(item,character);
                            return;
                        }
                        return;
                }
                return;
            }
            else{
                if (action.getCharacter().getLocation()==character.getLocation()){
                    action.takeItem(item,character);
                    if (game.check.isMatch(item, character)){
                        System.out.println("Uh oh, the "+item.getName()+" belongs with "+character.getName());
                        System.out.println("Type \"yes\" if you would like to give the item back");
                        getInput();
                        if(inputStrings.contains("yes")){
                            action.giveItem(item,character);
                            return;
                        }
                        return;
                }
                else{
                    System.out.println("That character is not in this room");
                    return;
                }
            }
        }
    }
            
        

        if (verb=='e'){
            //eat item
            if (item!=null){
                if (action.getCharacter().getHolding().contains(item)){
        
                    action.takeBite(item);
                    return;
                }
                else{
                    System.out.println("You can only consume items you are holding.");
                    System.out.println("Try “take <ITEM NAME>” before trying “eat/drink <ITEM NAME>”");
                    return;
                }
            }
            else{
                System.out.println("Make sure to specify which item you would like to eat/drink");
                System.out.println("Remember, you can only consume items you are holding");
                return;
            }
        }
        if (verb=='s'){
            if (character!=null){
                if (game.self.getLocation().getCharacters().contains(character)){
                    character.printOpeningLine();
                    return;
                }
                else{
                    System.out.println("That character is not in this room");
                    return;
                }
                
            }
            else{
                if (game.self.getLocation().getCharacters().size()==0){
                    System.out.println("No characters to speak to in this room");
                    return;
                }
                else{
                    character= game.self.getLocation().getCharacters().get(0);
                    character.printOpeningLine();
                    return;
                }
            }
        }
        if (verb=='d'){
            //drop item
            if (item!=null){
                if (direction!='0'){
                    action.giveItem(item, action.getCharacter().getLocation(),direction);
                    return;  
                }
                else{
                    action.giveItem(item, action.getCharacter().getLocation());
                    return;

                }
               
            }
            else{
                System.out.println("Make sure to specify which item you would like to drop");
                System.out.println("Remember, you can only drop items you are currently holding");
                return;
            }
        }

        if (verb=='g'){
            //give item to character
            if (item!=null && character!=null){
                action.giveItem(item, character);
                if (character.getHolding().contains(item)){
                    if (game.check.isMatch(item, character)){
                        character.printThanks();
                        game.check.changeLines(item, character);
                    }
                
                }
                return;
            }
            else{
                if (item!=null){
                    if (game.self.getLocation().getCharacters().size()!=0){
                        character=game.self.getLocation().getCharacters().get(0);
                        action.giveItem(item,character);
                        if (character.getHolding().contains(item)){
                            game.check.changeLines(item, character);
                            if (game.check.isMatch(item, character)){
                                character.printThanks();
                            }
                        }
                        return;
                    }
                    else{
                        System.out.println("There aren't any people here for you to give "+item.getName()+" to");
                        return;
                    }
                }
                else{
                    System.out.println("Make sure to specify which item you would like to give");
                    System.out.println("Remember, you can only give items which are in your hand");
                    return;
                }
            }
        }

        System.out.println("I didn't understand that command");

    }



    public Character getCharacter(){
        if (inputStrings.contains("rabbit")){
            return game.whiteRabbit;
        }
        if (inputStrings.contains("caterpillar")){
            return game.caterpillar;
        }
        if (inputStrings.contains("duchess")){
            return game.duchess;
        }
        if (inputStrings.contains("queen")||inputStrings.contains("queenofhearts")){
            return game.queenOfHearts;
        }
        if (inputStrings.contains("knave")){
            return game.knave;
        }
        else{
            return null;
        }

    }

    public Item getItem(char action){
        if (inputStrings.contains("hat")){
            return game.duchessHat;
        }
        if (inputStrings.contains("watch")||inputStrings.contains("pocket")){
            return game.pocketWatch;
        }
        if (inputStrings.contains("cake")||inputStrings.contains("eatme")){
            for (ConsumableItem cake: game.eatMe){
                if (action=='t'||action=='m'){
                    if (game.self.getLocation().getHolding().contains(cake)){
                        return cake;
                    }
                    for (Character character: game.self.getLocation().getCharacters()){
                        if(character.getHolding().contains(cake)){
                            return cake;
                        }
                    }
                }
                else{
                    if (game.self.getHolding().contains(cake)){
                        return cake;
                    }
                }
            }
            
            
        }
        if (inputStrings.contains("drink")||inputStrings.contains("drinkme")){
            for (ConsumableItem drink: game.drinkMe){
                if (action=='t'||action=='m'){
                    if (game.self.getLocation().getHolding().contains(drink)){
                        return drink;
                    }
                    for (Character character: game.self.getLocation().getCharacters()){
                        if(character.getHolding().contains(drink)){
                            return drink;
                        }
                    }
                }
                else{
                    if (game.self.getHolding().contains(drink)){
                        return drink;
                    }
                }
            }
          
            
        }
        if (inputStrings.contains("glove")||inputStrings.contains("gloves")){
            return game.gloves;
        }
        if (inputStrings.contains("tarts")||inputStrings.contains("tart")||inputStrings.contains("jam")){
            return game.tarts;
        }
        if (inputStrings.contains("key")||inputStrings.contains("keys")){
            return game.keyToChains;
        }
        if (inputStrings.contains("mushroom")){
            return game.mushroom;
        }
        if (inputStrings.contains("hookah")||inputStrings.contains("pipe")){
            return game.hookah;
        }
        if (inputStrings.contains("fan")){
            return game.fan;
        }
        
        return null;
        
    }

    public char getVerb(){

        if (inputStrings.contains("look")){
            return 'l';
        }
        if (inputStrings.get(0).equals("move")){
            return 'm';
        }
        if (inputStrings.contains("go")){
            return 'm';
        }
        if (inputStrings.contains("talk")||inputStrings.contains("speak")){
            return 's';
        }
        if (inputStrings.get(0).equals("drop")){
            return 'd';
        }
        if (inputStrings.get(0).equals("eat")||inputStrings.contains("bite")){
            inputStrings.remove("eat");
            return 'e';
        }
        if (inputStrings.get(0).equals("drink")){
            inputStrings.remove("drink");
            return 'e';
        }
        //take bite/sip

        if (inputStrings.get(0).equals("give")){
            return 'g';
        }

        if (inputStrings.get(0).equals("take")){
            return 't';
        }
        //take bite
        if (inputStrings.contains("hold")){
            return 't';
        }
    
        
        
        return '0';
        

    }

    public char getDirection(){
        if (inputStrings.contains("n")||inputStrings.contains("north")){
            return 'n';
        }
        if (inputStrings.contains("e")||inputStrings.contains("east")){
            return'e';
        }
        if (inputStrings.contains("s")||inputStrings.contains("south")){
            return 's';
        }
        if (inputStrings.contains("w")||inputStrings.contains("west")){
            return 'w';
        }
        if (inputStrings.contains("u")||inputStrings.contains("up")){
            return'u';
        }
        if (inputStrings.contains("d")||inputStrings.contains("down")){
            return'd';
        }
        
        return '0';
    
        }
}


   