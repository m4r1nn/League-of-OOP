# League-of-OOP --- Burcea Marian Gabriel 324CA

**SHORT DESCRIPTION of GAME**\
	League of OOP is a mini-project that tries to implement a virtual
Role-Playing-Game, based on object oriented programming.
	Base logic is simple: N heroes are supposed to move and fight each other on
a 2-dimensional matrix map. Every hero has exactly 2 abilities to use in each
fight he's participating in and his effects depends on the opponent race
(Pyromancer, Knight, Wizard, Rogue) as long as the matrix cell type (Land,
Volcanic, Desert, Woods). Aditionally, these heroes are helped or tangled by
some new characters, named angels. The 10 angel species (DamageAngel, DarkAngel,
Dracula, GoodBoy, LevelUpAngel, LifeGiver, SmallAngel, Spawner, TheDoomer,
XPAngel) have special abilities and can modify heroes stats.
	
**MAIN HELPER CLASSES**\
	To implement this, I needed the following 3 main classes:
 - __Hero__ abstract class (implements IHero) to store heroes stats and to implement
 damage take logic (hero move was too trivial so I implemented directly in game
 logic class);
 - __GameMap__ class which contains fields matrix, used for returning heroes type
 cell;
 - __Angel__ abstract class (implements IAngel) to store angels stats and implement
 the interaction between them and heroes;

 	Hero abstract class is the "root" for the 4 types of hero, each created using
__HeroFactory__ (factory pattern) to separate creation logic from the rest of the
program (the same thing applies to __AngelFactory__).
	__Coords__ class is used to store and return heroes' immediate coordinates (line
and column in game map).
	__IHero__ interface contains only *takeDamage* method which is overriden in
*heroType* classes while __IAngel__ interface contains only *visitHero* method,
implemented in every *angelType* class.

**INTERVENTION of VISITOR PATTERN**\
	To separate the hero attack methods from the rest of the class and to avoid
using instanceof operator, I created a visitor implementation based on the 8
player's abilities: *Fireblast*, *Ignite*, *Execute*, *Slam*, *Drain*, *Deflect*,
*Backstab*, *Paralysis*. Aditionally, to implement all interactions between angels
and players without overfilling heroes classes, the double dispatch visitor is
essential. Following rows contains the visitor skeleton:

__For heroes__

- __IHeroDamage__ interface (the "root" for the 8 abilities) declares 4 void
*launchAttack* functions which takes a *heroType* opponent as parameter (4 in total)
and depending on it's race the program knows which race modifier to apply;
- *launchAttack* function are overriden in the 8 ability classes;
- The 4 *heroTypes* classes override *takeDamage* method, taking the 2 opponent
abilities as parameters and leting them applying main method *launchAttack* on them;
- after that the total damage to take is calculated and can be subsituted from
hero hp;
- *launchAttack* calculates also the damage to take without race modifiers that is
used in *Wizard* deflect.

__For angels__
- every angel derived from *IAngel* has 4 methods to override, one for every hero
race (*visitHero*);
- all 4 heroes have implemented *acceptAngel* method in which they interact with
the special characters.

**HEROES STRATEGIES**\
	Every hero has the chance to learn from previous mistakes and change his actual
strategy with another one, more offensive or deffensive, depending on situation.
The strategies are represented by a total of 8 classes (attack and deffence for
every 4 heroes) that extends the base one __Strategy__. Stats that are modified
once with changing the strategy are current HP and race modifiers.

**THE GREATEST MAGICIAN AND OBSERVER PATTERN**\
	In addition to final leaderboard, I printed some periodical stats in game
based on actions that happen during it(eg. heroes deaths, angels spawn etc.).
For this, I implemented a *visitor pattern* from the following structure:
 - __Observer__ abstract class which has the main purpose to observe acitons
 during the game and to *update* stats to finally print them;
 - __Subject__ class that is the base for all observable subjects in program -- 
 everyone has an observers list to notify them when something important happened;
 - __BigBoss__ is the main observer in game and he is my *The Greatest Magiciac*
 character;
 - *GameLogic*, *Hero* (with its derivates) and *Angel* (with its derivates)
 represents the subject instances and from time to time they notify *BigBoss*
 about the game stats.

**INPUT LOADER AND GAME LOGIC**\
	The input is read from a given file (to main argv[ ]) with the help of a
*buffered reader*. A *buffered writer* is used to print the heroes board in a
given file too.
	__GameLogic__ class has the main purpose to run all rounds. The events order
during one round is:\
	1) parsing the input which contains heroes moving directions\
	2) apply overtime damage from previous rounds if it's still valid\
	3) change heroes strategies if they need to\
	4) moving all the heroes if possible\
	5) let players (that are on the same cell) fight\
	6) let angels come and help/hit other players\
	7) go to the next round.

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
 - Instead of making 8 strategy classes I could create only one and give it
specific parameters for every hero (new hp and modifiers) but that would mean
even more information in Hero derivates --- because of that I choosed to repeat
some code to separate that information from heroes.
 - the "periodical prints" are not printed immediately, but stored into a
StringBuilder in *Observer* class to avoid repeat the try-catch code from
BufferedWriter every time a message is printed. However, the actions are
displayed in the end (with only one try-catch block), but before final stats
are printed, and that is the reason *Observer* is an abstract class and not an
interface (it contains StringBuilder res field). To stdout, the in-game information
is printed immediately.
