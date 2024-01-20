import java.util.Scanner;

/**
 * The Game class extends the GameSettings class and is responsible for managing the game flow.
 * It provides methods for starting the game, selecting the game mode, and setting up players.
 */
public class Game  {
    
    private final GameSettings gameSettings;
    private final GameAssets assets;

    /**
     * Default constructor which initializes the game settings with default values.
     */
    public Game() {
        this.gameSettings = new GameSettings();
        this.assets = new GameAssets(this.gameSettings);
    }

    /**
     * Copy constructor which copies the game settings from another game settings object.
     *
     * @param gameSettings The game settings object to copy from.
     */
    public Game(GameSettings gameSettings, GameAssets gameAssets) {
        this.gameSettings = gameSettings;
        this.assets = gameAssets;
    }

    /**
     * Starts the game by displaying the welcome text and game title.
     * It then enters a loop where the user can select the game mode or exit the game.
     *
     * @param scanner The scanner object to use for reading user input.
     */
    protected void start(Scanner scanner) throws InterruptedException {
        gameSettings.assets.printAnimatedText(gameSettings.assets.welcomeText(), 0);
        gameSettings.assets.printAnimatedText(gameSettings.assets.gameTitle(), 0);
        while (!gameSettings.exit) {
            System.out.printf("SELECT %sGAME%s MODE%s\n",
                    gameSettings.assets.colored(Color.PURPLE),
                    gameSettings.assets.colored(Color.GREEN),
                    gameSettings.assets.colored(Color.RESET)
            );
            for (GameSettings.GameMode mode : GameSettings.GameMode.values()) {
                System.out.printf("%s: %s%s %s: %s%s%s\n",
                        gameSettings.assets.colored(Color.GREEN),
                        gameSettings.assets.colored(Color.PURPLE),
                        mode.ordinal() + 1,
                        gameSettings.assets.colored(Color.GREEN),
                        gameSettings.assets.colored(Color.BLUE),
                        mode.name(),
                        gameSettings.assets.colored(Color.RESET)
                );
            }
            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    assets.colored(Color.GREEN),
                    assets.colored(Color.PURPLE),
                    GameSettings.GameMode.values().length + 1,
                    assets.colored(Color.GREEN),
                    Color.RED.value(),
                    "Exit",
                    assets.colored(Color.RESET)
            );
            System.out.printf("%s>>>:%s ", Color.YELLOW.value(), assets.colored(Color.RESET));
            switch (scanner.nextLine()) {
                case "1":
                    singlePlayer(scanner);
                    break;
                case "2":
                    multiPlayer(scanner);
                    break;
                case "3":
                    computerOnly();
                    break;
                case "4":
                    gameSettings.exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.printf("%sInvalid input%s\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                    break;
            }
        }
    }

    /**
     * Sets up a single player game where the user plays against the computer.
     *
     * @param scanner The scanner object to use for reading user input.
     */
    void singlePlayer(Scanner scanner) {
        gameSettings.gameMode = GameSettings.GameMode.SINGLE_PLAYER;

        // hero name for player
        System.out.printf("%sEnter Hero 1 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String name = scanner.nextLine();
        gameSettings.playerOne = new Player(name, assets.generateRandomColor(gameSettings.random));
        // hero name for computer
        gameSettings.playerTwo = new Player(
                gameSettings.generateHeroName(gameSettings.assets.heroNames, gameSettings.assets.heroNicknames, gameSettings.random),
                gameSettings.assets.generateRandomColor(gameSettings.random)
        );
    }

    /**
     * Sets up a multi-player game where two users can play against each other.
     *
     * @param scanner The scanner object to use for reading user input.
     */
    void multiPlayer(Scanner scanner) {
        gameSettings.gameMode = GameSettings.GameMode.MULTI_PLAYER;
        System.out.printf("%sEnter Hero 1 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String hero1 = scanner.nextLine();
        gameSettings.playerOne = new Player(hero1, assets.generateRandomColor(gameSettings.random));

        System.out.printf("%sEnter Hero 2 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String hero2 = scanner.nextLine();
        gameSettings.playerTwo = new Player(hero2, assets.generateRandomColor(gameSettings.random));
    }

    /**
     * Sets up a game where two computer players play against each other.
     */
    @SuppressWarnings("BusyWait")
    void computerOnly() throws InterruptedException {
        gameSettings.gameMode = GameSettings.GameMode.COMPUTER_ONLY;
        gameSettings.playerOne = new Player(
                gameSettings.generateHeroName(gameSettings.assets.heroNames, gameSettings.assets.heroNicknames, gameSettings.random),
                gameSettings.assets.generateRandomColor(gameSettings.random)
        );

        gameSettings.playerTwo = new Player(
                gameSettings.generateHeroName(gameSettings.assets.heroNames, gameSettings.assets.heroNicknames, gameSettings.random),
                gameSettings.assets.generateRandomColor(gameSettings.random)
        );

        while (gameSettings.playerOne.getLives() >= 0 || gameSettings.playerTwo.getLives() >= 0) {
            int i = gameSettings.random.nextInt(6);
            if (i == 0) {
                gameSettings.playerOne.attack(gameSettings.playerTwo);
                System.out.println(assets.playerOneAttack());
            } else if (i == 1) {
                gameSettings.playerTwo.attack(gameSettings.playerOne);
                System.out.println(assets.playerTwoAttack());
            } else if (i == 2) {
                gameSettings.playerOne.attack(gameSettings.playerOne);
                gameSettings.playerTwo.attack(gameSettings.playerTwo);
                System.out.println(assets.bothAttack());
            } else if (i == 3) {
                gameSettings.playerOne.defend();
                gameSettings.playerTwo.defend();
                System.out.println(assets.bothDefend());
            } else if (i == 4) {
                System.out.println(assets.bothRest());
            } else {
                gameSettings.playerTwo.attack(gameSettings.playerOne);
                System.out.println(assets.playerTwoAttack());
            }
            if(gameSettings.clearConsole) {
                gameSettings.clearConsole(1000);
            }
            Thread.sleep(1000);
        }

        if (gameSettings.playerOne.getLives() >= 0) {
            System.out.println(assets.playerOneWins());
        } else {
            System.out.println(assets.playerTwoWins());
        }
    }

}
