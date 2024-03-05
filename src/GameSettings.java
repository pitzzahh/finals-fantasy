import java.util.Random;

/**
 * The GameSettings class is responsible for managing the settings of the game.
 * It holds the game assets, player information, game mode, and other settings.
 *
 * @author Peter John Arao
 */
public class GameSettings {

    // Random object used for generating random values
    protected final Random random = new Random();

    // Boolean flag to indicate whether the game is colored or not. Only change this using program arguments.
    protected boolean colored;

    // Player one object
    protected Player playerOne;

    // Player two object
    protected Player playerTwo;

    // Long to represent the freeze time when a player is attacking/attacked, by default it is 4000 millisecond. Only change this using program arguments.
    protected long gameFreeze = 4000L;

    // Boolean flag to indicate whether to exit the game or not
    protected boolean exit;

    /**
     * Generates a hero name by randomly selecting a name and a nickname from the provided arrays.
     *
     * @param names     The array of names to choose from.
     * @param nickNames The array of nicknames to choose from.
     * @param random    The random object to use for generating random indices.
     * @return The generated hero name.
     */
    protected String generateHeroName(String[] names, String[] nickNames, Random random) {
        return names[random.nextInt(names.length)] + " The " + nickNames[random.nextInt(nickNames.length)];
    }
}
