import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameSettings gameSettings = new GameSettings();

        gameSettings.colored = Arrays.stream(args).anyMatch(arg -> arg.matches("colored"));
        gameSettings.gameFreeze = Arrays.stream(args)
                .filter(arg -> arg.contains("game-freeze"))
                .findAny()
                .map(arg -> Long.parseLong(arg.split("=")[1]))
                .orElse(4000L);

        Game game = new Game(gameSettings, new GameAssets(gameSettings));
        game.start(new Scanner(System.in));
    }
}