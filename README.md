# League-of-OOP --- Burcea Marian Gabriel 324CA

**SHORT DESCRIPTION of GAME**
	League of OOP is a mini-project that tries to implement a virtual
Role-Playing-Game, based on object oriented programming.
	Base logic is simple: N heroes are supposed to move and fight each other on
a 2-dimensional matrix map. Every hero has exactly 2 abilities to use in each
fight he's participating in and his effects depends on the opponent race
(Pyromancer, Knight, Wizard, Rogue) as long as the matrix cell type (Land,
Volcanic, Desert, Woods).
	
**MAIN HELPER CLASSES**
	To implement this, I needed the following 2 main classes:
 - __Hero__ abstract class (implements IHero) to store heroes stats and to implement
 damage take logic (hero move was too trivial so I implemented directly in game
 logic class);
 - __GameMap__ class which contains fields matrix, used for returning heroes type
 cell;

 	Hero abstract class is the "root" for the 4 types of hero, each created using
__HeroFactory__ (factory pattern) to separate creation logic from the rest of the
program.
	__Coords__ class is used to store and return heroes' immediate coordinates (line
and column in game map).
	__IHero__ interface contains only *takeDamage* method which is overriden in
*heroType* classes.

**INTERVENTION of VISITOR PATTERN**
	To separate the hero attack methods from the rest of the class and to avoid
using instanceof operator, I created a visitor implementation based on the 8
player's abilities: *Fireblast*, *Ignite*, *Execute*, *Slam*, *Drain*, *Deflect*,
*Backstab*, *Paralysis*. Following rows contains the visitor skeleton:

- __IHeroDamage__ interface (the "root" for the 8 abilities) declares 4 void
*launchAttack* functions which takes a *heroType* opponent as parameter (4 in total)
and depending on it's race the program knows which race modifier to apply.
- *launchAttack* function are overriden in the 8 ability classes;
- The 4 *heroTypes* classes override *takeDamage* method, taking the 2 opponent
abilities as parameters and leting them applying main method *launchAttack* on them;
- after that the total damage to take is calculated and can be subsituted from
hero hp;
- *launchAttack* calculates also the damage to take without race modifiers that is
used in *Wizard* deflect;

**INPUT LOADER AND GAME LOGIC**
	The input is read from a given file (to main argv[]) with the help of a
*buffered reader*. A *buffered writer* is used to print the heroes board in a
given file too.
	__GameLogic__ class has the main purpose to run all rounds. The events order
during one round is:
	1) parsing the input which contains heroes moving directions
	2) moving all the heroes if possible
	3) apply overtime damage from previous rounds if it's still valid
	4) let players (that are on the same cell) fight
	5) go to the next round

**Some special notes:**
	- I could save the whole input from file including the players moving
directions and not reading them in GameLogic class but that would have cost me
some extra memory for storing the lines (in a Collection for example) and some
extra running time because the input would be firstly stored and then executed,
instead of being executed instantly.
	- To check if 2 (alive) players are in the same cell I could go through the
game map, but that would mean I could meet some cells that have more than 2
(alive or dead) heroes in them and the checking for finding the 2 alive ones
(if they exist) would have been more complicated. Instead of this, I choosed to
iterate through heroes list and to compare 2 by 2 if both are alive and in the
same cell.
