import java.util.Scanner;

/**
 * The Game class extends the GameSettings class and is responsible for managing the game flow.
 * It provides methods for starting the game, selecting the game mode, and setting up players.
 */
public class Game {

    private final GameSettings gameSettings;
    private final GameAssets assets;

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
    @SuppressWarnings("BusyWait")
    protected void start(Scanner scanner) throws InterruptedException {
        while (!gameSettings.exit) {
            System.out.println(assets.welcomeText());
            System.out.println(assets.gameTitle());
            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    assets.colored(Color.GREEN),
                    assets.colored(Color.PURPLE),
                    1,
                    assets.colored(Color.GREEN),
                    assets.colored(Color.BLUE),
                    "Start",
                    assets.colored(Color.RESET)
            );

            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    assets.colored(Color.GREEN),
                    assets.colored(Color.PURPLE),
                    2,
                    assets.colored(Color.GREEN),
                    assets.colored(Color.RED),
                    "Exit",
                    assets.colored(Color.RESET)
            );
            System.out.printf("%s>>>:%s ", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
            switch (scanner.nextLine()) {
                case "1":
                    gameSettings.playerOne = new Player(
                            gameSettings.generateHeroName(assets.heroNames, assets.heroNicknames, gameSettings.random),
                            assets.generateRandomColor(gameSettings.random)
                    );

                    gameSettings.playerTwo = new Player(
                            gameSettings.generateHeroName(assets.heroNames, assets.heroNicknames, gameSettings.random),
                            assets.generateRandomColor(gameSettings.random)
                    );

                    while (gameSettings.playerOne.getLives() >= 1 && gameSettings.playerTwo.getLives() >= 1) {
                        int i = gameSettings.random.nextInt(5);
                        if (i == 0) {
                            gameSettings.playerOne.attack(gameSettings.playerTwo);
                            gameSettings.playerTwo.defend();
                            System.out.println(assets.playerOneAttack());
                        } else if (i == 1) {
                            gameSettings.playerTwo.attack(gameSettings.playerOne);
                            gameSettings.playerOne.defend();
                            System.out.println(assets.playerTwoAttack());
                        } else if (i == 2) {
                            gameSettings.playerOne.attack(gameSettings.playerTwo);
                            gameSettings.playerTwo.attack(gameSettings.playerOne);
                            System.out.println(assets.bothAttack());
                        } else if (i == 3) {
                            gameSettings.playerOne.defend();
                            gameSettings.playerTwo.defend();
                            System.out.println(assets.bothDefend());
                        } else {
                            System.out.println(assets.bothRest());
                        }
                        Thread.sleep(gameSettings.gameFreeze);
                    }

                    if (gameSettings.playerOne.getLives() == 0 && gameSettings.playerTwo.getLives() == 0) {
                        System.out.println(assets.bothLost());
                    } else if (gameSettings.playerOne.getLives() == 0) {
                        System.out.println(assets.playerTwoWins());
                    } else {
                        System.out.println(assets.playerOneWins());
                    }
                    System.out.printf("\n%sPress any to continue%s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
                    scanner.nextLine();
                    break;
                case "2":
                    gameSettings.exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.printf("%sInvalid input%s\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                    System.out.printf("\n%sPress any to retry%s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
                    scanner.nextLine();
                    break;
            }
        }
    }
}
