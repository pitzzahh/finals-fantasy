import java.util.Scanner;


public class Game extends GameSettings {


    public Game(GameSettings gameSettings) {
        super(gameSettings);
    }

    protected void start(Scanner scanner) {
        printAnimatedText(super.assets.welcomeText, 0);
        printAnimatedText(super.assets.gameTitle, 0);
        while (!exit) {
            System.out.printf("SELECT %sGAME%s MODE%s\n", Colors.PURPLE, Colors.GREEN, Colors.RESET);
            for (GameMode mode : GameMode.values()) {
                System.out.printf("%s: %s%s %s: %s%s%s\n",
                        Colors.GREEN,
                        Colors.PURPLE,
                        mode.ordinal() + 1,
                        Colors.GREEN,
                        Colors.BLUE,
                        mode.name(),
                        Colors.RESET
                );
            }
            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    Colors.GREEN,
                    Colors.PURPLE,
                    GameMode.values().length + 1,
                    Colors.GREEN,
                    Colors.RED,
                    "Exit",
                    Colors.RESET
            );
            System.out.printf("%s>>>:%s ", Colors.YELLOW, Colors.RESET);
            switch (scanner.next()) {
                case "1":
                    gameMode = GameMode.SINGLE_PLAYER;
                    playerOne = new Player(
                            generateHeroName(super.assets.heroNames, super.assets.heroNicknames, random),
                            super.assets.generateRandomColor(random)
                    );
                    playerTwo = new Player(
                            generateHeroName(super.assets.heroNames, super.assets.heroNicknames, random),
                            super.assets.generateRandomColor(random)
                    );
                    break;
                case "2":
                    gameMode = GameMode.MULTI_PLAYER;
                    break;
                case "3":
                    gameMode = GameMode.COMPUTER_ONLY;
                    break;
                case "4":
                    System.out.println("Exit");
                    exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    /*

     */
}
