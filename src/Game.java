import java.util.Scanner;

public class Game extends GameSettings {

    public Game() {
        super();
    }

    public Game(GameSettings gameSettings) {
        super(gameSettings);
    }

    protected void start(Scanner scanner) {
        assets.printAnimatedText(super.assets.welcomeText(), 0);
        assets.printAnimatedText(super.assets.gameTitle(), 0);
        while (!exit) {
            System.out.printf("SELECT %sGAME%s MODE%s\n",
                    assets.colored(Color.PURPLE),
                    assets.colored(Color.GREEN),
                    assets.colored(Color.RESET)
            );
            for (GameMode mode : GameMode.values()) {
                System.out.printf("%s: %s%s %s: %s%s%s\n",
                        assets.colored(Color.GREEN),
                        assets.colored(Color.PURPLE),
                        mode.ordinal() + 1,
                        assets.colored(Color.GREEN),
                        assets.colored(Color.BLUE),
                        mode.name(),
                        assets.colored(Color.RESET)
                );
            }
            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    assets.colored(Color.GREEN),
                    assets.colored(Color.PURPLE),
                    GameMode.values().length + 1,
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
                    exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.printf("%sInvalid input%s\n", assets.colored(Color.RED_BOLD), assets.colored(Color.RESET));
                    break;
            }
        }
    }

    void singlePlayer(Scanner scanner) {
        gameMode = GameMode.SINGLE_PLAYER;

        // hero name for player
        System.out.printf("%sEnter Hero 1 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String name = scanner.nextLine();
        playerOne = new Player(name, assets.generateRandomColor(random));
        // hero name for computer
        playerTwo = new Player(
                generateHeroName(super.assets.heroNames, super.assets.heroNicknames, random),
                super.assets.generateRandomColor(random)
        );
    }

    void multiPlayer(Scanner scanner) {
        gameMode = GameMode.MULTI_PLAYER;
        System.out.printf("%sEnter Hero 1 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String hero1 = scanner.nextLine();
        playerOne = new Player(hero1, assets.generateRandomColor(random));

        System.out.printf("%sEnter Hero 2 name: %s", assets.colored(Color.YELLOW), assets.colored(Color.RESET));
        String hero2 = scanner.nextLine();
        playerTwo = new Player(hero2, assets.generateRandomColor(random));
    }

    void computerOnly() {
        gameMode = GameMode.COMPUTER_ONLY;
        playerOne = new Player(
                generateHeroName(super.assets.heroNames, super.assets.heroNicknames, random),
                super.assets.generateRandomColor(random)
        );

        playerTwo = new Player(
                generateHeroName(super.assets.heroNames, super.assets.heroNicknames, random),
                super.assets.generateRandomColor(random)
        );
    }

}
