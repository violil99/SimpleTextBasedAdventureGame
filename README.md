To run this game, compile and run the Game.java file.

My game is a matching game. Each character has one or two game items that they are looking
for. In order to win the game, the player must match each player with their missing items in order
to win the game.

To win:
- The duchess needs her hat
- The caterpillar needs his hookah and mushroom
- The white rabbit needs the gloves and fan
- The queen of hearts needs her tarts
- The knave needs the key
  
To lose:
- The tarts get eaten
- The player gets too small (a warning is displayed when the player is close to shrinking
away)
- The player gets stuck. I have not yet written out code to test this, but if a character is
unable to get in or out of a room to return the rest of the items, the game is over. For
now, the player must figure this out for themselves and quit the game manually
The player must move between game locations to talk to characters, discover what they are
missing, collect items, and return them to their rightful owners. Characters can eat Drink Me
Drinks and Eat Me cakes to grow or shrink to fit through doors.

Game Classes

Location
- Has lists of characters, items, doors and directions as well as a description of the
location, and a room name. When the location is created, these are all empty (directions
are created, but without any information loaded). When the game is created, the
locations are created, then the doors(which need locations as input), the directions are
loaded last (because they need location and door objects). This way these objects can
interact.

Direction
- There are six direction objects within each location, created when the location object is
constructed. These directions can then be loaded with descriptions, doors, items, and
characters, but they can only be set up after doors and locations are created. If nothing
is loaded into a location, a player can only look in that direction, and “Nothing in that
direction” will be displayed. A player can only move in a direction if there is a door there,
and move in that direction will result in a change of location. The direction class has a
variable, throughDoor, which displays a description of going through the door, for
example, “You go through a clear door and over a twisty path”

Door
- The door class creates door objects to connect two rooms. These door objects only hold
the information about which room is being entered and can therefore be used to connect
multiple rooms. In my game, I have made my door objects connect multiple rooms, so all
entrances to the duchess house are the same door object. This is not at all necessary,
and I could easily rewrite this to include different Door objects for each room connection.
Because of how I understood the instructions, my doors are all one way.
In order to use a door, the door must be clear of objects. I.e. if there are objects in the
same direction as the door, the player will not be able to pass through, and a message
will display telling the player to move the object. Some doors have minimum and
maximum size requirements. If a character cannot pass through the door, a message will
display with a hint for how to grow or shrink. Eat me cakes allow a character to grow
while drink me drinks allow the character to shrink

Item
- Holds the name and description of an item
ConsumableItem(child of Item)
- Created to allow items to get eaten. ConsumableItems have a set number of bites, and
some of these ConsumableItems make a character grow or shrink

Character
- The character objects hold a lot of important information:
● The size of the character(controls whether or not you can get through doors,
ends game if you get too small). Eatme and drinkme objects can change this
● The character location. Is changed when a character moves
● The lines a character says
● The items a character is holding
● The name and description of the character
- Character class contains methods to change the character’s location, print lines, add or
remove items from inventory,display information about the character, and change the
size of the character by taking bites.

Action
- This class performs actions as the character it is assigned (in my game, only the player’s
character has an assigned action object, but a more complicated game could create one
for each character). Look, take, give, drop, and eat are all performed by this class
Check
- This class was created mostly for clarity’s sake. It has methods to check if items are
returned (checked after every turn), if the tarts are finished(ends the game if they are), if
an item belongs to a character, and changes a character’s line when their item(s) have
been returned. I have these run when items are given or taken away from characters.

Control
- This Class does most of the heavy work of parsing the user input and executing the
demands as understood. It takes in user input, loads it into an arraylist of words, then
checks if the input contains actions verbs, character names, item names, or directions.
Using a series of if statements, I am able to execute the commands given by the user.
My parsing method does not pay any attention to words it does not understand.
Therefore if multiple commands are made in one line or extra words are given in the
command, the command may still be executed. I decided to write this way to allow for
regular english in commands. I wanted to allow the player to write “give item to
character” or “take the item” or “take item from character” or “drop item to the north”.
- Since writing the entire program, I have rethought this and the Action class a lot. If I were
to do everything over (and I probably will!), I would put much of the control class into the
action class. The method I would make the most changes to would be parseInput().

Game (info loaded with Game.txt)
