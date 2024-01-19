import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameSettings gameSettings = new GameSettings();
        Game game = new Game(gameSettings);

        if (args != null && args.length > 0) {
            if (args[0].equals("clear")) {
                game.clearConsole = true;
            }
        }

        game.playerOne.setLives(78);
        game.playerTwo.setLives(20);

        game.start(new Scanner(System.in));
    }
}