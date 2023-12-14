  /**
   * title: Wonderland adventure
   * description: This text based adventure game requires a user explore
   * wonderland and return items to their rightful owners 
   * date:8/11/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   */

  /**
   * DOCUMENTATION...
   */
  /**
   *
   *
   *
   * Compiling and running instructions
   * Required: How do I know which java version is required to run my code?
   * Compile: 
   * javac Location.java
   * javac Direction.java
   * javac Door.java
   * javac Item.java
   * javac ConsumableItem.java
   * javac Character.java
   * javac Action.java
   * javac Control.java
   * javac Game.java
   * javac Check.java
   * Run: java Game

   *
   */
  /**
   *
   * Class: Game
   * Variables:
   * instance variables:
    scanner annd file are used to read Game.txt which holds all the 
    information on characters, items, and room descriptions

    ArrayList<String> input is where the contents from Game.txt are loaded.
    I ended up putting them into an ArrayList so that I could clear away
    any extra whitespaces.


    Character self --> the character used by the player

    characters in the game:
    Character whiteRabbit
    Character caterpillar
    Character duchess
    Character queenOfHearts
    Character knave


    -Action selfAction is used to control the player
    -Control selfControl also used to control the player
    -Check check a chack object loaded set to this game object (once the game is 
    created). This object checks if the game has been won or lost, and
    also check a few other things


    game locations:
    Location greatHall;
    Location whiteRabbitHouse;
    Location forest;
    Location duchessHouse;
    Location marchHareHouse;
    Location beautifulGarden;
    Location safeHouse;
    Location riverBank;

    game doors:
    Door toGreatHall;
    Door toWhiteRabbitHouse;
    Door toForest;
    Door toMarchHareHouse;
    Door toBeautifulGarden;
    Door toSafeHouse;
    Door toDuchessHouse;
   

    eatme/drinkme items:
    ConsumableItem eatMe1;
    ConsumableItem drinkMe1;
    ConsumableItem eatMe2;
    ConsumableItem drinkMe2;
    ConsumableItem eatMe3;
    ConsumableItem drinkMe3;
    ConsumableItem eatMe4;
    ConsumableItem drinkMe4;
    ConsumableItem eatMe5;
    ConsumableItem drinkMe5;
    ConsumableItem eatMe6;
    ConsumableItem drinkMe6;

    arraylists to hold the eatme/drinkme:
    ArrayList<ConsumableItem> eatMe;
    ArrayList<ConsumableItem> drinkMe;
   
    game items:
    ConsumableItem tarts;
    Item pocketWatch;
    Item gloves;
    Item fan;
    Item mushroom;
    Item hookah;
    Item duchessHat;
    Item keyToChains;



   *
   * Constructors:
   * with this constructor, the game is set as follows:
   * - file is cleaned and loaded into the arraylist input
   * - Items are created and loaded with the information from input
   * - Doors are created and their sizes set
   * - Directions are set with descriptions(input) and doors
   * - Characters are created and loaded with input information.
   * they are placed in locations as they are created
   * - Items are placed in locations and characters' inventories
   * - User characters (self) is created and placed on the
   * riverbank
   * - control and action objects are created to control
   * the user's character (In a more complicated game, I
   * would also create these for the other characters, but
   * my game does not involve moving any characters other than
   * the user's)
   * -scanner is closed
   *
   * Methods:
   * main method 
   *- creates game object
   - sets control and check objects (because they need
   the game object as input. If I had more objects which 
   needed to be loaded this way, I would use a method to
   do this)
   -opening message is printed
   -gameplay while loop
        - prints lines for clarity
        - input is taken from user
        - extra lines are printed for clarity
        - user input is parsed and dealt with in the
        control class
        - Checks if the game has been won(items returned 
        to correct owners)
        - checks if the game has been lost(the tarts were eaten)

   *
   */
  /**
   * Program Testing
   * See Testing.pdf for testing
   */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Game{

    Scanner scanner;
    File file;

    ArrayList<String> input;

    Character self;
    Character whiteRabbit;
    Character caterpillar;
    Character duchess;
    Character queenOfHearts;
    Character knave;

    Action selfAction;
    Control selfControl;
    Check check;

    Location greatHall;
    Location whiteRabbitHouse;
    Location forest;
    Location duchessHouse;
    Location marchHareHouse;
    Location beautifulGarden;
    Location safeHouse;
    Location riverBank;

    Door toGreatHall;
    Door toWhiteRabbitHouse;
    Door toForest;
    Door toMarchHareHouse;
    Door toBeautifulGarden;
    Door toSafeHouse;
    Door toDuchessHouse;
    

    ConsumableItem eatMe1;
    ConsumableItem drinkMe1;
    ConsumableItem eatMe2;
    ConsumableItem drinkMe2;
    ConsumableItem eatMe3;
    ConsumableItem drinkMe3;
    ConsumableItem eatMe4;
    ConsumableItem drinkMe4;
    ConsumableItem eatMe5;
    ConsumableItem drinkMe5;
    ConsumableItem eatMe6;
    ConsumableItem drinkMe6;

    ArrayList<ConsumableItem> eatMe;
    ArrayList<ConsumableItem> drinkMe;
    
    ConsumableItem tarts;
    Item pocketWatch;
    Item gloves;
    Item fan;
    Item mushroom;
    Item hookah;
    Item duchessHat;
    Item keyToChains;



    public Game(){

        input=new ArrayList<>();
        
        try{
            file = new File("Game.txt");
            scanner = new Scanner(file);

        }
        catch(FileNotFoundException e){
            System.out.println("The file Game.txt does not exist");
        }

        scanner.useDelimiter("@");

        String string;
        while(scanner.hasNext()){
            string=scanner.next();
            string=string.strip();
            //System.out.println("|"+string+"|");
            input.add(string);
        }        

        
        int index = 0;
        eatMe1 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe1 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        eatMe2 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe2 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        eatMe3 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe3 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        eatMe4 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe4 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        eatMe5 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe5 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        eatMe6 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;
        drinkMe6 = new ConsumableItem(input.get(index),input.get(index+1),Integer.parseInt(input.get(index+2)),input.get(index+3));
        index+=4;

        eatMe=new ArrayList<ConsumableItem>(
            Arrays.asList(eatMe1,eatMe2,eatMe3,eatMe4,eatMe5,eatMe6));
        
        drinkMe=new ArrayList<>(
            Arrays.asList(drinkMe1,drinkMe2,drinkMe3,drinkMe4,drinkMe5,drinkMe6));


        
        tarts = new ConsumableItem(input.get(index), input.get(index+1), Integer.parseInt(input.get(index+2)), input.get(index+3));
        index+=4;
        pocketWatch = new Item(input.get(index), input.get(index+1));
        index+=2;
        gloves = new Item(input.get(index), input.get(index+1));
        index+=2;
        fan = new Item(input.get(index), input.get(index+1));
        index+=2;
        mushroom = new ConsumableItem(input.get(index), input.get(index+1), Integer.parseInt(input.get(index+2)), input.get(index+3));
        index+=4;
        hookah = new Item(input.get(index), input.get(index+1));
        index+=2;
        duchessHat = new Item(input.get(index), input.get(index+1));
        index+=2;
        keyToChains = new Item(input.get(index), input.get(index+1));
        index+=2;


        //creating locations
        greatHall = new Location(input.get(index),input.get(index+1));
        index+=2;
        marchHareHouse = new Location(input.get(index),input.get(index+1));
        index+=2;
        whiteRabbitHouse = new Location(input.get(index),input.get(index+1));
        index+=2;
        forest = new Location(input.get(index),input.get(index+1));
        index+=2;
        duchessHouse = new Location(input.get(index),input.get(index+1));
        index+=2;
        beautifulGarden = new Location(input.get(index),input.get(index+1));
        index+=2;
        safeHouse = new Location(input.get(index),input.get(index+1));
        index+=2;
        riverBank=new Location(input.get(index),input.get(index+1));
        index+=2;

        //creating doors
        toMarchHareHouse = new Door(marchHareHouse);
        toWhiteRabbitHouse = new Door(whiteRabbitHouse,4);
        toGreatHall = new Door(greatHall);
        toBeautifulGarden = new Door(beautifulGarden,3);
        toDuchessHouse = new Door(duchessHouse,20);
        toSafeHouse = new Door(safeHouse,100);
        toForest = new Door(forest, 15);

        toMarchHareHouse.setMinSize(6);
        toDuchessHouse.setMinSize(7);
       


        //setting directions
        riverBank.d.setDescription(input.get(index));
        index++;
        riverBank.d.setDoor(toGreatHall);
        riverBank.d.setThroughDoor(input.get(index));
        index++;

        greatHall.n.setDescription(input.get(index));
        index++;
        greatHall.n.setDoor(toMarchHareHouse);
        greatHall.n.setThroughDoor(input.get(index));
        index++;

        greatHall.e.setDescription(input.get(index));
        index++;
        greatHall.e.setDoor(toWhiteRabbitHouse);
        greatHall.e.setThroughDoor(input.get(index));
        index++;

        greatHall.s.setDescription(input.get(index));
        index++;;
        greatHall.s.setDoor(toBeautifulGarden);
        greatHall.s.setThroughDoor(input.get(index));
        index++;

        greatHall.w.setDescription(input.get(index));
        index++;
        greatHall.w.setDoor(toDuchessHouse);
        greatHall.w.setThroughDoor(input.get(index));
        index++;
    
        greatHall.u.setDescription(input.get(index));
        index++;
        greatHall.u.setDoor(toSafeHouse);
        greatHall.u.setThroughDoor(input.get(index));
        index++;

        greatHall.d.setDescription(input.get(index));
        index++;

        marchHareHouse.e.setDescription(input.get(index));
        index++;
        marchHareHouse.e.setDoor(toWhiteRabbitHouse);
        marchHareHouse.e.setThroughDoor(input.get(index));
        index++;


        whiteRabbitHouse.s.setDescription(input.get(index));
        index++;
        whiteRabbitHouse.s.setDoor(toBeautifulGarden);
        whiteRabbitHouse.s.setThroughDoor(input.get(index));
        index++;
        
        whiteRabbitHouse.d.setDescription(input.get(index));
        index++;
        whiteRabbitHouse.d.setDoor(toGreatHall);
        whiteRabbitHouse.d.setThroughDoor(input.get(index));
        index++;

        beautifulGarden.w.setDescription(input.get(index));
        index++;
        beautifulGarden.w.setDoor(toSafeHouse);
        beautifulGarden.w.setThroughDoor(input.get(index));
        index++;

        safeHouse.n.setDescription(input.get(index));
        index++;
        safeHouse.n.setDoor(toDuchessHouse);
        safeHouse.n.setThroughDoor(input.get(index));
        index++;

        duchessHouse.n.setDescription(input.get(index));
        index++;
        duchessHouse.n.setDoor(toForest);
        duchessHouse.n.setThroughDoor(input.get(index));
        index++;

        forest.e.setDescription(input.get(index));
        index++;
        forest.e.setDoor(toMarchHareHouse);
        forest.e.setThroughDoor(input.get(index));
        index++;
        forest.d.setDescription(input.get(index));
        index++;
        forest.d.setDoor(toGreatHall);
        forest.d.setDescription(input.get(index));
        index++;

        
        //setting Characters
        whiteRabbit = new Character(input.get(index),whiteRabbitHouse,input.get(index+1),input.get(index+2),input.get(index+3));
        index+=4;
        whiteRabbitHouse.addCharacter(whiteRabbit);

        caterpillar = new Character(input.get(index),forest,input.get(index+1),input.get(index+2),input.get(index+3));
        index+=4;
        forest.addCharacter(caterpillar);

        duchess = new Character(input.get(index),duchessHouse,input.get(index+1),input.get(index+2),input.get(index+3));
        index+=4;
        duchessHouse.addCharacter(duchess);

        queenOfHearts = new Character(input.get(index),beautifulGarden,input.get(index+1),input.get(index+2),input.get(index+3));
        index+=4;
        beautifulGarden.addCharacter(queenOfHearts);

        knave = new Character(input.get(index),marchHareHouse,input.get(index+1),input.get(index+2),input.get(index+3));
        index+=4;
        marchHareHouse.addCharacter(knave);


        
        //placing items
        whiteRabbit.takeItem(pocketWatch);
        caterpillar.takeItem(duchessHat);
        duchess.takeItem(gloves);
        queenOfHearts.takeItem(keyToChains);
        knave.takeItem(tarts);
        queenOfHearts.takeItem(drinkMe2);
        queenOfHearts.takeItem(eatMe2);


        greatHall.takeItem(drinkMe1);
        greatHall.takeItem(eatMe1);
        whiteRabbitHouse.takeItem(drinkMe3);
        marchHareHouse.takeItem(eatMe3);
        marchHareHouse.takeItem(hookah);
        duchessHouse.takeItem(fan);
        duchessHouse.takeItem(drinkMe4);
        duchessHouse.takeItem(eatMe4);
        beautifulGarden.takeItem(mushroom);
        forest.takeItem(drinkMe5);
        forest.takeItem(eatMe5);
        safeHouse.takeItem(drinkMe6);
        safeHouse.takeItem(eatMe6);





        self = new Character("Alice (you)",riverBank);
        selfAction = new Action(self);
        selfControl = new Control(selfAction);

        scanner.close();

    }

    public static void main(String[] args){

        Game game = new Game();
        game.selfControl.setGame(game);
        game.check = new Check(game);
        

        System.out.println("\nWelcome to Alice's Adventure Game!");
        System.out.println("Things have gotten mixed up in wonderland, and the characters need your help.");
        System.out.println("To complete the game, return all items to their rightful owners.");
        System.out.println("Find each character to find out which items they are looking for.");
        System.out.println("Make sure not to get too small, and don't eat any of the items which people are looking for!");

        System.out.println("\ntype \"help\" for assistance and \"quit\" to end the game");

      
        while(true){
            System.out.println("\n\n");
            game.selfControl.getInput();
            System.out.println();
            game.selfControl.parseInput();
            
      
            if (game.check.itemsReturned()){
                System.out.println("You won!");
                System.exit(0);
            }

            game.check.tartsFinished();


        }



        
    }
}