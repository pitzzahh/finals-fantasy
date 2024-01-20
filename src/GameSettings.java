import java.util.Random;

/**
 * The GameSettings class is responsible for managing the settings of the game.
 * It holds the game assets, player information, game mode, and other settings.
 */
public class GameSettings {

    // Random object used for generating random values
    protected final Random random = new Random();

    // Game assets object which holds all the game assets
    protected GameAssets assets;

    // Boolean flag to indicate whether to clear the console or not
    protected boolean clearConsole;

    // Boolean flag to indicate whether the game is colored or not
    protected boolean colored;

    // Enum to represent the game mode (single player, multi-player, or computer only)
    protected GameMode gameMode;

    // Player one object
    protected Player playerOne;

    // Player two object
    protected Player playerTwo;

    // Boolean flag to indicate whether to exit the game or not
    protected boolean exit;

    /**
     * Default constructor which initializes the game assets.
     */
    public GameSettings() {
        assets = new GameAssets(this);
    }

    /**
     * Copy constructor which copies the game settings from another game settings object.
     *
     * @param gameSettings The game settings object to copy from.
     */
    public GameSettings(GameSettings gameSettings, GameAssets assets) {
        clearConsole = gameSettings.clearConsole;
        colored = gameSettings.colored;
        gameMode = gameSettings.gameMode;
        playerOne = gameSettings.playerOne;
        playerTwo = gameSettings.playerTwo;
        exit = gameSettings.exit;
        this.assets = assets;
    }

    /**
     * Generates a hero name by randomly selecting a name and a nickname from the provided arrays.
     *
     * @param names The array of names to choose from.
     * @param nickNames The array of nicknames to choose from.
     * @param random The random object to use for generating random indices.
     * @return The generated hero name.
     */
    protected String generateHeroName(String[] names, String[] nickNames, Random random) {
        return names[random.nextInt(names.length)] + " The " + nickNames[random.nextInt(nickNames.length)];
    }

    /**
     * Clears the console after a specified delay if the clearConsole flag is set to true.
     *
     * @param delay The delay in milliseconds before clearing the console.
     */
    public void clearConsole(long delay) {
        if (clearConsole) {
            System.out.print("\033\143");
            System.out.flush();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
    }

    /**
     * Enum to represent the game mode.
     */
    public enum GameMode {
        SINGLE_PLAYER,
        MULTI_PLAYER,
        COMPUTER_ONLY
    }
}
