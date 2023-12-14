  /**
   *
   * Class:Item
   * description: This class creates items
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
   * name 
   * name of item
   * 
   * description
   * a short description of the item
   *
   * Constructors:
   * public Item(String name,String description)
   * sets name and description
   *
   * Methods:
   * public int getBites()
   * created to be overridden by child class
   * 
   * public void takeBite(Character character)
   * created to be overridden by child class
   * 
   * public String getName()
   * 
   * public String getDescription()
   * 
   * public void printDescription()
   */


public class Item{
    private String name;
    private String description;
    
    public Item(String name,String description){
            this.name = name;
            this.description = description;

    }

    public int getBites(){
        return 0;
    }

    public void takeBite(Character character){
        System.out.println("This item is not edible");
    }
 

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void printDescription(){
        System.out.println(description);
    }

    

    
}