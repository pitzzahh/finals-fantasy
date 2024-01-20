import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
        if (args != null) {
            for (String arg : args) {
                gameSettings.clearConsole = arg.toLowerCase(Locale.ROOT).matches(".*clear.*");
                gameSettings.colored = arg.toLowerCase(Locale.ROOT).matches(".*color.*");
            }
        }

        Game game = new Game(gameSettings);
        game.start(new Scanner(System.in));
    }
}