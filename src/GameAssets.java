import java.util.Random;

public class GameAssets implements Colors {

    protected String welcomeText =
            RED + "┬ ┬┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐ ┌┬┐┌─┐\n" + GREEN +
                    "│││├┤ │  │  │ ││││├┤   │ │ │\n" + BLUE +
                    "└┴┘└─┘┴─┘└─┘└─┘┴ ┴└─┘  ┴ └─┘\n" + RESET;

    protected String gameTitle = RED + "____ ____ ___ ___ __   ____" + GREEN + " ____ ____ ____ _  _ _  _ ___  \n" +
            RED + "|__] |__|  |   |  |    |___ " + GREEN + "| __ |__/ |  | |  | |\\ | |  \\ \n" +
            RED + "|__] |  |  |   |  |___ |___ " + GREEN + "|__] |  \\ |__| |__| | \\| |__/ \n" +
            RED + "                                                          \n" + RESET;

    protected String[] heroNames = new String[]{
            "Bayani",
            "Lakandula",
            "Diwata",
            "Haraya",
            "Lakambini",
            "Alamat",
            "Sagisag",
            "Liwayway",
            "Tala",
            "Bathala",
            "Katipunan",
            "Kalayaan",
            "Dalisay",
            "Linggo",
            "Maganda",
            "Tagumpay",
            "Daliri",
            "Hiwaga",
            "Lakapati",
            "Lakan"
    };

    protected String[] heroNicknames = {
            "Valiant",
            "Astral",
            "Shadowblade",
            "Ember",
            "Frostbite",
            "Thunderstrike",
            "Solaris",
            "Mystic",
            "Ironclad",
            "Sapphire",
            "Rogue",
            "Eternal",
            "Duskblade",
            "Radiant",
            "Stormbringer",
            "Lunar",
            "Celestial",
            "Phoenix",
            "Blizzard",
            "Nebula"
    };

    protected String playerOneAttack(Player playerOne, Player playerTwo) {
        return playerOne.getColor() + "\t\t  0   /" + "\t\t" + playerTwo.getColor() + "|  0  \n" +
               playerOne.getColor() + "\t\t--+--/ " + "\t\t" + playerTwo.getColor() + "|--+--\n" +
               playerOne.getColor() + "\t\t / \\  " + "\t\t" + playerTwo.getColor() + "  / \\\n" +
               playerOne.getColor() + "\t\t/   \\ " + "\t\t" + playerTwo.getColor() + " /   \\\n"+
               playerOne.getColor() + playerOne.getName() + RESET + " vs " + playerTwo.getColor() + playerTwo.getName() + "\n" +
               generateHealthBar(playerOne.getLives()) + "||" + generateHealthBar(playerTwo.getLives()) + "\n" +
               RED_BRIGHT + "\t\t (Attack)\t\t\t " + BLUE_BRIGHT + "(Defend)" + RESET;
    }

    private final String playerTwoAttack =
            "  0  | \\   0  \n" +
                    "--+--|  \\--+--\n" +
                    " / \\      / \\\n" +
                    "/   \\    /   \\\n";

    private final String bothAttack =
            "  0   / \\   0  \n" +
                    "--+--/   \\--+--\n" +
                    " / \\      / \\\n" +
                    "/   \\    /   \\\n";

    private final String bothDefend =
            "  0  | |  0  \n" +
                    "--+--| |--+--\n" +
                    " / \\     / \\\n" +
                    "/   \\   /   \\\n";

    private final String bothRest =
            "  0      0   \n" +
                    "--+--  --+-- \n" +
                    " / \\    / \\ \n" +
                    "/   \\  /   \\\n";


    protected String generateRandomColor(Random random) {
        int colorIndex = random.nextInt(Colors.COLORS.length);
        return Colors.COLORS[colorIndex];
    }

    protected String generateHealthBar(int health) {
        int barLength = 20;
        int filledBlocks = (int) Math.ceil((double) health / 100 * barLength);
        String color = health >= 70 ? GREEN : health >= 40 ? YELLOW : RED;
        StringBuilder healthBar = new StringBuilder(color);
        for (int i1 = 0; i1 < filledBlocks; i1++) {
            healthBar.append('█');
        }
        healthBar.append(RESET);
        for (int i = 0; i < (barLength - filledBlocks); i++) {
            healthBar.append(' ');
        }
        return healthBar.toString();
    }
}
