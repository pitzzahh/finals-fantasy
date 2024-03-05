import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

/**
 * The Game class extends the GameSettings class and is responsible for managing the game flow.
 * It provides methods for starting the game, selecting the game mode, and setting up players.
 */
public class Game {

    private final GameSettings gameSettings;
    private final GameAssets assets;
    private GameMode gameMode;

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
                case "1" -> {
                    System.out.printf("%s: %s%s %s: %s%s%s\n",
                            assets.colored(Color.GREEN),
                            assets.colored(Color.PURPLE),
                            1,
                            assets.colored(Color.GREEN),
                            assets.colored(Color.BLUE),
                            "You vs CPU",
                            assets.colored(Color.RESET)
                    );
                    System.out.printf("%s: %s%s %s: %s%s%s\n",
                            assets.colored(Color.GREEN),
                            assets.colored(Color.PURPLE),
                            2,
                            assets.colored(Color.GREEN),
                            assets.colored(Color.RED),
                            "CPU vs CPU",
                            assets.colored(Color.RESET)
                    );
                    System.out.printf("%s: %s%s %s: %s%s%s\n",
                            assets.colored(Color.GREEN),
                            assets.colored(Color.PURPLE),
                            3,
                            assets.colored(Color.GREEN),
                            assets.colored(Color.BLUE),
                            "Exit",
                            assets.colored(Color.RESET)
                    );
                    System.out.printf("%s>>>:%s ", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
                    switch (scanner.nextLine()) {
                        case "1" -> {
                            gameMode = GameMode.HUMAN_VS_COMPUTER;
                            String humanName;
                            do {
                                System.out.printf("%sEnter a catchy name >>>:%s ", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
                                humanName = scanner.nextLine();
                                if (humanName.isEmpty()) {
                                    System.out.printf("%sPlease identify yourself mighty knight!%s\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                                }
                            } while (humanName.isEmpty());
                            Color humanSelectedColor = Color.BLACK;
                            if(gameSettings.colored) {
                                Optional<Color> optionalColor;
                                do {
                                    System.out.printf("%sHello mighty %s%s,%s please select your desired color%s\n",
                                            assets.colored(Color.PURPLE_BOLD),
                                            assets.colored(Color.RESET),
                                            humanName,
                                            assets.colored(Color.PURPLE),
                                            assets.colored(Color.RESET)
                                    );
                                    System.out.printf("%s:Available colors (Pick the number):%s\n", assets.colored(Color.PURPLE_BOLD_BRIGHT), assets.colored(Color.RESET));

                                    assets.filteredColors()
                                            .forEach(color -> System.out.printf("%d: %s%s%s\n", color.ordinal(), color.value(), color.name(), Color.RESET.value()));

                                    System.out.print("Enter your color >>>: ");
                                    String colorInput = scanner.nextLine().toLowerCase().trim();

                                    optionalColor = assets.filteredColors()
                                            .stream()
                                            .filter(color -> Objects.equals(String.valueOf(color.ordinal()), colorInput))
                                            .findAny();

                                    if (optionalColor.isPresent()) {
                                        System.out.printf("You selected %s%s%s\n", optionalColor.get().value(), optionalColor.get().name(), Color.RESET.value());
                                        humanSelectedColor = optionalColor.get();
                                    } else {
                                        System.out.printf("\n%sInvalid color%s\n\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                                    }
                                } while (optionalColor.isEmpty());
                            }
                            gameSettings.playerOne = new Player(humanName, humanSelectedColor);

                            // print a ready counter with colors
                        }
                        case "2" -> {
                            gameMode = GameMode.COMPUTER_VS_COMPUTER;
                            gameSettings.playerOne = new Player(
                                    gameSettings.generateHeroName(assets.heroNames, assets.heroNicknames, gameSettings.random),
                                    assets.generateRandomColor(gameSettings.random)
                            );
                        }
                        case "3" -> {
                            gameSettings.exit = true;
                            scanner.close();
                        }
                    }
                    if (!gameSettings.exit) {
                        System.out.printf("%sTHE %sBATTLE%s BEGINS IN\n",
                                assets.colored(Color.YELLOW_BOLD),
                                assets.colored(Color.RED_BOLD_BRIGHT),
                                assets.colored(Color.YELLOW_BOLD)
                        );
                        for (int i = 3; i > 0; i--) {
                            System.out.printf("%s%s%s\n", assets.colored(Color.YELLOW), i, assets.colored(Color.RESET));
                            Thread.sleep(1000);
                        }
                        // print a fight
                        System.out.println(assets.fight());
                        gameSettings.playerTwo = new Player(
                                gameSettings.generateHeroName(assets.heroNames, assets.heroNicknames, gameSettings.random),
                                assets.generateRandomColor(gameSettings.random)
                        );
                        gamePlay(scanner);
                    }
                }
                case "2" -> {
                    gameSettings.exit = true;
                    scanner.close();
                }
                default -> {
                    System.out.printf("%sInvalid input%s\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                    System.out.printf("\n%sPress any to retry%s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
                    scanner.nextLine();
                }
            }
        }
    }

    @SuppressWarnings("BusyWait")
    private void gamePlay(Scanner scanner) throws InterruptedException {
        while (gameSettings.playerOne.getLives() >= 1 && gameSettings.playerTwo.getLives() >= 1) {
            int computerChoice = gameSettings.random.nextInt(5);
            switch (gameMode) {
                case HUMAN_VS_COMPUTER -> {
                    String userInput;
                    do {
                        System.out.println("Choose your action:");
                        System.out.println("1. Attack");
                        System.out.println("2. Defend");
                        System.out.println("3. Rest");

                        System.out.print("Enter your choice (1, 2 or 3): ");
                        userInput = scanner.nextLine();

                        switch (userInput) {
                            case "1" -> {
                                gameSettings.playerOne.attack(gameSettings.playerTwo);
                                computerChoice = gameSettings.random.nextInt(4) + 1;
                                if (computerChoice == 1) { // one attack
                                    gameSettings.playerTwo.defend();
                                    // put back player two live because it defends
                                    gameSettings.playerTwo.setLives(
                                            gameSettings.playerOne.getDamage() +
                                                    gameSettings.playerTwo.getLives()
                                    );
                                    gameSettings.playerOne.setDamage(0);
                                    System.out.println(assets.playerOneAttack());
                                } else if (computerChoice == 2) { // both attack
                                    gameSettings.playerTwo.attack(gameSettings.playerOne);
                                    System.out.println(assets.bothAttack());
                                } else if (computerChoice == 3) { // two rest and one attack
                                    gameSettings.playerTwo.rest();
                                    System.out.println(assets.playerOneAttack());
                                }
                            }
                            case "2" -> {
                                gameSettings.playerOne.defend();
                                computerChoice = gameSettings.random.nextInt(2) + 1;
                                if (computerChoice == 1) { // two attack
                                    System.out.println(assets.playerTwoAttack());
                                } else { // both defend
                                    gameSettings.playerTwo.defend();
                                    System.out.println(assets.bothDefend());
                                }
                            }
                            case "3" -> {
                                gameSettings.playerOne.rest();
                                computerChoice = gameSettings.random.nextInt(2) + 1;
                                if (computerChoice == 1) { // two attack
                                    gameSettings.playerTwo.attack(gameSettings.playerOne);
                                    System.out.println(assets.playerTwoAttack());
                                } else {
                                    gameSettings.playerTwo.rest();
                                    System.out.println(assets.bothRest());
                                }
                            }
                            default -> System.out.println("Invalid input. Please enter 1 for Attack or 2 for Defend.");
                        }
                    } while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
                }
                case COMPUTER_VS_COMPUTER -> {
                    if (computerChoice == 0) { // one attack
                        gameSettings.playerTwo.defend();
                        System.out.println(assets.playerOneAttack());
                    } else if (computerChoice == 1) { // two attack
                        gameSettings.playerOne.defend();
                        System.out.println(assets.playerTwoAttack());
                    } else if (computerChoice == 2) { // both attack
                        gameSettings.playerOne.attack(gameSettings.playerTwo);
                        gameSettings.playerTwo.attack(gameSettings.playerOne);
                        System.out.println(assets.bothAttack());
                    } else if (computerChoice == 3) { // both defend
                        gameSettings.playerOne.defend();
                        gameSettings.playerTwo.defend();
                        System.out.println(assets.bothDefend());
                    } else { // both rest
                        System.out.println(assets.bothRest());
                    }
                }
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
    }

}
