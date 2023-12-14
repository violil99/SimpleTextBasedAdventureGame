  /**
   *
   * Class: Check
   *
   * description: The check class checks if the game has been won or lost
   * as well as if items are match their owner to allow for 
   * statements to be printed or changed
   * 
   * date: 8/13/2023
   * @author: Lilith Richter-Stephenson student ID: 3643216
   * @version: 1.0
   * @copyright 2001-2020   Lilith Richter-Stephenson
   *
   * Variables:
   * game is the game object 
   *
   * Constructors:
   *  public Check(Game game) sets the game
   *
   * Methods:
   * public boolean itemsReturned() returns true if all items 
   * are returned to their rightful owners and false if not
   * 
   * public void tartsFinished()
   * ends the game and displays GAME OVER if the tarts are 
   * finished
   * 
   * public boolean isMatch(Item item,Character character)
   * returns true if the item belongs to the character. This
   * is used to display a thank you message when an item is
   * returned and a warning when a matched item is taken away.
   * 
   * 
   * public void changeLines(Item item, Character character)
   * changes the characters' opening lines when their items
   * are returned. This way characters do not ask for their
   * missing items when they have been returned.
   * 
   * disclaimer -- there is not a method to change the lines 
   * back if the items are taken back. When I rewrite this,
   * I would like to make changeLines run after every turn
   * and simply update based on which items the characters
   * are holding. This way, when an item is taken back, it
   * would change the line back. --
   * 
   *
   */


public class Check{
    Game game;
    public Check(Game game){
        this.game = game;
    }

    public boolean itemsReturned(){
        if (!game.duchess.getHolding().contains(game.duchessHat)){
            return false;
        }


        if (!game.caterpillar.getHolding().contains(game.hookah)){
            return false;
        }
        if (!game.caterpillar.getHolding().contains(game.mushroom)){
            return false;
        }


        if (!game.whiteRabbit.getHolding().contains(game.gloves)){
            return false;
        }
        if (!game.whiteRabbit.getHolding().contains(game.fan)){
            return false;
        }

        if (!game.queenOfHearts.getHolding().contains(game.tarts)){
            return false;
        }

        if (!game.knave.getHolding().contains(game.keyToChains)){
            return false;
        }
        return true;
    }

    public void tartsFinished(){
        if(game.tarts.getBites()==0){
            System.out.println("Uh oh, the Queen of Hearts's tarts are finished!");
            System.out.println("GAME OVER");
            System.exit(0);
        }
    }

    public boolean isMatch(Item item,Character character){
        if (character== game.duchess&&item==game.duchessHat){
            return true;
        }
        if (character==game.caterpillar&&item==game.hookah){
            return true;
        }
        if (character==game.caterpillar&&item==game.mushroom){
            return true;
        }
        if (character== game.whiteRabbit&&item==game.fan){
            return true;
        }
        if (character==game.whiteRabbit&&item==game.gloves){
            return true;
        }
        if (character==game.knave&&item==game.keyToChains){
            return true;
        }
        if (character==game.queenOfHearts&&item==game.tarts){
            return true;
        }

        return false;
    }
    public void changeLines(Item item, Character character){
        if (character== game.duchess&&item==game.duchessHat){
            character.setOpeningLine(character.getName()+" says: Hello again! Do you like my hat?");
            return;
        }

        if (character==game.caterpillar&&item==game.hookah){
            if (game.caterpillar.getHolding().contains(game.mushroom)){
                character.setOpeningLine(character.getName()+" says: I'm so happy to be sitting on this mushroom, smoking my pipe!");
                return;
            }
            else{
                character.setOpeningLine(character.getName()+" says: I'm happy to have my pipe, but I don't have anywhere to sit. Have you seen my mushroom?");
                return;
            }
        }
        if (character==game.caterpillar&&item==game.mushroom){
            if (game.caterpillar.getHolding().contains(game.hookah)){
                character.setOpeningLine(character.getName()+" says: I'm so happy to be sitting on this mushroom, smoking my pipe!");
                return;
            }
            else{
                character.setOpeningLine(character.getName()+" says: Thanks for returning my mushroom. Have you seen my hookah pipe?");
                return;
            }

        }
        if (character== game.whiteRabbit&&item==game.fan){
            if (game.whiteRabbit.getHolding().contains(game.gloves)){
                character.setOpeningLine(character.getName()+" says: Thank you for finding this fan and pair of gloves!");
                return;
            }
            else{
                character.setOpeningLine(character.getName()+" says: I've got my fan, but I'm still looking for those gloves");
                return;
            }
        }
        if (character==game.whiteRabbit&&item==game.gloves){
           if (game.whiteRabbit.getHolding().contains(game.fan)){
                character.setOpeningLine(character.getName()+" says: Thank you for finding this fan and pair of gloves!");
                return;
            }
            else{
                character.setOpeningLine(character.getName()+" says: I've got my gloves, but I'm still looking for that fan");
                return;
            }
        }
        if (character==game.knave&&item==game.keyToChains){
            character.setOpeningLine(character.getName()+" says: Hi, thanks for finding those keys!");
            return;
                }
        if (character==game.queenOfHearts&&item==game.tarts){
            character.setOpeningLine(character.getName()+" says: No beheadings today... Thanks for finding the tarts");
            return;   
        }
    }
}