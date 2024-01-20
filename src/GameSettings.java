import java.util.Random;

public class GameSettings {

    protected final Random random = new Random();
    protected GameAssets assets;
    protected boolean clearConsole;
    protected boolean colored;
    protected GameMode gameMode;
    protected Player playerOne;
    protected Player playerTwo;
    protected boolean exit;

    public GameSettings() {
        assets = new GameAssets(this);
    }

    public GameSettings(GameSettings gameSettings) {
        clearConsole = gameSettings.clearConsole;
        colored = gameSettings.colored;
        gameMode = gameSettings.gameMode;
        playerOne = gameSettings.playerOne;
        playerTwo = gameSettings.playerTwo;
        exit = gameSettings.exit;
        assets = new GameAssets(this);
    }

    protected String generateHeroName(String[] names, String[] nickNames, Random random) {
        return names[random.nextInt(names.length)] + " The " + nickNames[random.nextInt(nickNames.length)];
    }

    public void clearConsole(long delay) {
        if (clearConsole) {
            System.out.print("\033\143");
            System.out.flush();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
    }

    protected enum GameMode {
        SINGLE_PLAYER,
        MULTI_PLAYER,
        COMPUTER_ONLY
    }


}
