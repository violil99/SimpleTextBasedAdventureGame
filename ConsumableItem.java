  /**
   *
   * Class:ConsumableItem
   *
   * description: creates food or drink items
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
   *     private int bites;
   * how many bites are in the item
   * 
    private String changeSize;
    how does it change the size of the consumer (bigger,
    smaller, none)
   *
   * Constructors:
   * public ConsumableItem(String name, String description, 
   * int bites, String changeSize) runs parent class constructor
   * to set name and description, sets bites and changesize
   *
   * Methods:
   * public int getBites()
   * 
   * public void printDescription()
   * prints description, including bites left
   * (overrides parent class method of the same name)
   * 
   *  public void takeBite(Character character)
   * removes 1 from bites, makes character grow
   * or shrink, prints messages when the item is
   * finished or almost finished, and prints if
   * the character grew or shrank
   *
   */


public class ConsumableItem extends Item{
    private int bites;
    private String changeSize;

    public ConsumableItem(String name, String description, int bites, String changeSize){
        super(name, description);
        this.bites = bites;
        this.changeSize = changeSize.toUpperCase();
        
    }

    public int getBites(){
        return bites;
    }

    public void printDescription(){
        System.out.println(getDescription());
        System.out.println("There are "+bites+" bites left in this item");
    }

    public void takeBite(Character character){
        bites--;



        switch(changeSize){
            case "GROW":
            System.out.println(character.getName()+" grew!"); 
            character.takeBiteBigger();
            break;

            case "SHRINK": 
            System.out.println(character.getName()+" shrank!");
            character.takeBiteSmaller();
            break;
            
            default: 
            System.out.println(character.getName()+" took a bite!");
        }
        if (bites<3&&bites>0){
            System.out.println("watch out. The item is almost finished");
        }
        if (bites==0){
            System.out.println("This item is finished");
            character.getHolding().remove(this);
            return;
        }
    }
}