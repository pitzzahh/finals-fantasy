import java.util.Random;

public class GameSettings {

    protected final Random random = new Random();
    protected final GameAssets assets = new GameAssets();
    protected boolean clearConsole;
    protected GameMode gameMode;
    protected Player playerOne;
    protected Player playerTwo;
    protected boolean exit = false;

    public GameSettings() {
        gameMode = GameMode.SINGLE_PLAYER;
        playerOne = new Player(
                generateHeroName(assets.heroNames, assets.heroNicknames, random),
                assets.generateRandomColor(random)
        );
        playerTwo = new Player(
                generateHeroName(assets.heroNames, assets.heroNicknames, random),
                assets.generateRandomColor(random)
        );
    }

    public GameSettings(GameSettings gameSettings) {
        clearConsole = gameSettings.clearConsole;
        gameMode = gameSettings.gameMode;
        playerOne = gameSettings.playerOne;
        playerTwo = gameSettings.playerTwo;
        exit = gameSettings.exit;
    }

    protected String generateHeroName(String[] names, String[] nickNames, Random random) {
        int nameIndex = random.nextInt(names.length);
        int nickNameIndex = random.nextInt(nickNames.length);
        return names[nameIndex] + " The " + nickNames[nickNameIndex];
    }

    public void clearConsole(long delay) {
        if (clearConsole) {
            System.out.print("\033\143");
            System.out.flush();
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    protected enum GameMode {
        SINGLE_PLAYER,
        MULTI_PLAYER,
        COMPUTER_ONLY
    }

    protected static void printAnimatedText(String text, long delay) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                Thread.sleep(delay);
            }
        } catch (InterruptedException ignored) {

        }
    }
}
