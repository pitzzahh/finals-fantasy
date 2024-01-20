import java.util.Scanner;


public class Game extends GameSettings {

    public Game(GameSettings gameSettings) {
        super(gameSettings);
    }

    protected void start(Scanner scanner) {
        printAnimatedText(super.welcomeText, 0);
        printAnimatedText(super.gameTitle, 0);
        while (!exit) {
            System.out.printf("SELECT %sGAME%s MODE%s\n",
                    Color.PURPLE.value(),
                    Color.GREEN.value(),
                    Color.RESET.value()
            );
            for (GameMode mode : GameMode.values()) {
                System.out.printf("%s: %s%s %s: %s%s%s\n",
                        Color.GREEN.value(),
                        Color.PURPLE.value(),
                        mode.ordinal() + 1,
                        Color.GREEN.value(),
                        Color.BLUE.value(),
                        mode.name(),
                        Color.RESET.value()
                );
            }
            System.out.printf("%s: %s%s %s: %s%s%s\n",
                    Color.GREEN.value(),
                    Color.PURPLE.value(),
                    GameMode.values().length + 1,
                    Color.GREEN.value(),
                    Color.RED.value(),
                    "Exit",
                    Color.RESET.value()
            );
            System.out.printf("%s>>>:%s ", Color.YELLOW.value(), Color.RESET.value());
            switch (scanner.next()) {
                case "1":
                    gameMode = GameMode.SINGLE_PLAYER;
                    playerOne = new Player(
                            generateHeroName(super.heroNames, super.heroNicknames, random),
                            super.generateRandomColor(random)
                    );
                    playerTwo = new Player(
                            generateHeroName(super.heroNames, super.heroNicknames, random),
                            super.generateRandomColor(random)
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
