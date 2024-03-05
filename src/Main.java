import java.util.Arrays;
import java.util.Scanner;

/**
 * Finals Fantasy is a battle game where two knights fight each other to the death.
 * The game is developed in Java and provides a simple yet engaging command-line interface for the players.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameSettings gameSettings = new GameSettings();

        gameSettings.colored = Arrays.stream(args).anyMatch(arg -> arg.matches("colored"));
        gameSettings.gameFreeze = Arrays.stream(args)
                .filter(arg -> arg.contains("game-freeze"))
                .findAny()
                .map(arg -> Long.parseLong(arg.split("=")[1]))
                .orElse(3000L);

        Game game = new Game(gameSettings, new GameAssets(gameSettings));
        game.start(new Scanner(System.in));
    }
}