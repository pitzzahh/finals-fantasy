import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameAssets {

    private final GameSettings settings;

    protected GameAssets(GameSettings settings) {
        this.settings = settings;
    }

    protected String welcomeText() {
        return colored(Color.RED) +
                "┬ ┬┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐ ┌┬┐┌─┐\n" + colored(Color.GREEN) +
                "│││├┤ │  │  │ ││││├┤   │ │ │\n" + colored(Color.BLUE) +
                "└┴┘└─┘┴─┘└─┘└─┘┴ ┴└─┘  ┴ └─┘\n" + colored(Color.RESET);
    }

    protected String gameTitle() {
        return colored(Color.PURPLE_BRIGHT) +
                "███████╗██╗███╗   ██╗ █████╗ ██╗     ███████╗               \n" +
                "██╔════╝██║████╗  ██║██╔══██╗██║     ██╔════╝               \n" +
                "█████╗  ██║██╔██╗ ██║███████║██║     ███████╗               \n" +
                "██╔══╝  ██║██║╚██╗██║██╔══██║██║     ╚════██║               \n" +
                "██║     ██║██║ ╚████║██║  ██║███████╗███████║               \n" +
                "╚═╝     ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝╚══════╝               \n" +
                "                                                            \n" + colored(Color.BLUE_BRIGHT) +
                "███████╗ █████╗ ███╗   ██╗████████╗ █████╗ ███████╗██╗   ██╗\n" +
                "██╔════╝██╔══██╗████╗  ██║╚══██╔══╝██╔══██╗██╔════╝╚██╗ ██╔╝\n" +
                "█████╗  ███████║██╔██╗ ██║   ██║   ███████║███████╗ ╚████╔╝ \n" +
                "██╔══╝  ██╔══██║██║╚██╗██║   ██║   ██╔══██║╚════██║  ╚██╔╝  \n" +
                "██║     ██║  ██║██║ ╚████║   ██║   ██║  ██║███████║   ██║   \n" +
                "╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝   ╚═╝   \n" + colored(Color.RESET);
    }


    protected String[] heroNames = new String[]
            {
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
        return String.format("%s%s %sＡＴＴＡＣＫＳ %s%s with %d Damage\n", colored(playerOne.getColor()), playerOne.getName(), colored(Color.RED_BRIGHT), colored(playerTwo.getColor()), playerTwo.getName(), playerOne.getDamage()) +
                colored(playerOne.getColor()) + "\t\t  0   /" + "\t\t" + colored(playerTwo.getColor()) + "|  0 \n" +
                colored(playerOne.getColor()) + "\t\t--+--/ " + "\t\t" + colored(playerTwo.getColor()) + "|--+-- " +
                String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                colored(playerOne.getColor()) + "\t\t / \\  " + "\t\t" + colored(playerTwo.getColor()) + "  / \\ " +
                String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                colored(playerOne.getColor()) + "\t\t/   \\ " + "\t\t" + colored(playerTwo.getColor()) + " /   \\\n" +
                colored(playerOne.getColor()) + playerOne.getName() + colored(Color.RESET) + " vs " + colored(playerTwo.getColor()) + playerTwo.getName() + "\n" +
                colored(Color.RED_BRIGHT) + "\t\t (Attack)\t\t\t " + colored(Color.BLUE_BRIGHT) + "(Defend)" + colored(Color.RESET);
    }

    protected String playerTwoAttack(Player playerOne, Player playerTwo) {
        return
                String.format("%s%s %sＡＴＴＡＣＫＳ %s%s with %d Damage\n", colored(playerTwo.getColor()), playerTwo.getName(), colored(Color.RED_BRIGHT), colored(playerOne.getColor()), playerOne.getName(), playerTwo.getDamage()) +
                        colored(playerOne.getColor()) + "\t\t  0  |" + "\t\t" + colored(playerTwo.getColor()) + "\\   0  \n" +
                        colored(playerOne.getColor()) + "\t\t--+--|" + "\t\t" + colored(playerTwo.getColor()) + " \\--+--  " +
                        String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                        colored(playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(playerTwo.getColor()) + "   / \\   " +
                        String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                        colored(playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(playerTwo.getColor()) + "  /   \\\n" +
                        colored(playerOne.getColor()) + playerOne.getName() + colored(Color.RESET) + " vs " + colored(playerTwo.getColor()) + playerTwo.getName() + "\n" +
                        colored(Color.BLUE_BRIGHT) + "\t\t (Defend)\t\t\t " + colored(Color.RED_BRIGHT) + "(Attack)" + colored(Color.RESET);
    }

    protected String bothAttack(Player playerOne, Player playerTwo) {
        return
                String.format("Both Player %sＡＴＴＡＣＫＳ %s%s - %d Damage %s| %s%s - %d Damage\n", colored(Color.RED_BRIGHT), colored(playerOne.getColor()), playerOne.getName(), playerOne.getDamage(), colored(Color.RESET), colored(playerTwo.getColor()), playerTwo.getName(), playerTwo.getDamage()) +
                        colored(playerOne.getColor()) + "\t\t  0   /" + "\t\t" + colored(playerTwo.getColor()) + "\\   0  \n" +
                        colored(playerOne.getColor()) + "\t\t--+--/ " + "\t\t" + colored(playerTwo.getColor()) + " \\--+--  " +
                        String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                        colored(playerOne.getColor()) + "\t\t / \\  " + "\t\t" + colored(playerTwo.getColor()) + "   / \\   " +
                        String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                        colored(playerOne.getColor()) + "\t\t/   \\ " + "\t\t" + colored(playerTwo.getColor()) + "  /   \\\n" +
                        colored(playerOne.getColor()) + playerOne.getName() + colored(Color.RESET) + " vs " + colored(playerTwo.getColor()) + playerTwo.getName() + "\n" +
                        colored(Color.RED_BRIGHT) + "\t\t (Attack)\t\t\t " + colored(Color.RED_BRIGHT) + "(Attack)" + colored(Color.RESET);
    }

    protected String bothDefend(Player playerOne, Player playerTwo) {
        return String.format("Both Player %sＤＥＦＥＮＤＳ %s%s - %d Damage %s| %s%s - %d Damage\n", colored(Color.BLUE_BRIGHT), colored(playerOne.getColor()), playerOne.getName(), playerOne.getDamage(), colored(Color.RESET), colored(playerTwo.getColor()), playerTwo.getName(), playerTwo.getDamage()) +
                colored(playerOne.getColor()) + "\t\t  0  |" + "\t\t" + colored(playerTwo.getColor()) + "|  0 \n" +
                colored(playerOne.getColor()) + "\t\t--+--|" + "\t\t" + colored(playerTwo.getColor()) + "|--+-- " +
                String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                colored(playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(playerTwo.getColor()) + "  / \\ " +
                String.format("\t%s%s - HP: %s\n", colored(Color.BLUE_BRIGHT), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                colored(playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(playerTwo.getColor()) + " /   \\\n" +
                colored(playerOne.getColor()) + playerOne.getName() + colored(Color.RESET) + " vs " + colored(playerTwo.getColor()) + playerTwo.getName() + "\n" +
                colored(Color.BLUE_BRIGHT) + "\t\t (Defend)\t\t\t " + colored(Color.BLUE_BRIGHT) + "(Defend)" + colored(Color.RESET);
    }

    protected String bothRest(Player playerOne, Player playerTwo) {
        return String.format("Both Player %sＲＥＳＴＳ %s%s - %d HP %s| %s%s - %d HP\n", colored(Color.BLUE_BRIGHT), colored(playerOne.getColor()), playerOne.getName(), playerOne.getLives(), colored(Color.RESET), colored(playerTwo.getColor()), playerTwo.getName(), playerTwo.getLives()) +
                colored(playerOne.getColor()) + "\t\t  0   " + "\t\t" + colored(playerTwo.getColor()) + "  0 \n" +
                colored(playerOne.getColor()) + "\t\t--+-- " + "\t\t" + colored(playerTwo.getColor()) + "--+-- " +
                String.format("\t%s%s - No Damage - HP: %s\n", colored(Color.BLUE_BRIGHT), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                colored(playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(playerTwo.getColor()) + " / \\ " +
                String.format("\t%s%s - No Damage - HP: %s\n", colored(Color.BLUE_BRIGHT), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                colored(playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(playerTwo.getColor()) + "/   \\\n" +
                colored(playerOne.getColor()) + playerOne.getName() + colored(Color.RESET) + " vs " + colored(playerTwo.getColor()) + playerTwo.getName() + "\n" +
                colored(Color.GREEN_BRIGHT) + "\t\t (Rest)\t\t\t " + colored(Color.GREEN_BRIGHT) + "(Rest)" + colored(Color.RESET);
    }

    protected String playerOneWins(Player playerOne, Player playerTwo) {
        return String.format("%s%s %sＷＩＮＳ\n", colored(playerOne.getColor()), playerOne.getName(), colored(Color.BLUE_BOLD)) +
                colored(playerOne.getColor()) + "\t\t\\  0  /" + "\n" +
                colored(playerOne.getColor()) + "\t\t --+-- " +
                String.format("\t\t%s%s: %s\n", colored(playerOne.getColor()), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                colored(playerOne.getColor()) + "\t\t  / \\ " +
                String.format("\t\t%s%s: %s\n", colored(playerTwo.getColor()), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                colored(playerOne.getColor()) + "\t\t /   \\" + "\t\t" + colored(playerTwo.getColor()) + "/--+--0\n" + colored(Color.RESET);
    }

    protected String playerTwoWins(Player playerOne, Player playerTwo) {
        return String.format("%s%s %sＷＩＮＳ\n", colored(playerTwo.getColor()), playerTwo.getName(), colored(Color.BLUE_BOLD)) +
                colored(playerOne.getColor()) + "\t\t\t" + colored(playerTwo.getColor()) + "\\  0  /\n" +
                colored(playerOne.getColor()) + "\t\t\t" + colored(playerTwo.getColor()) + " --+-- " +
                String.format("\t\t%s%s: %s\n", colored(playerOne.getColor()), playerOne.getName(), generateHealthBar(playerOne.getLives())) +
                colored(playerOne.getColor()) + "\t\t\t" + colored(playerTwo.getColor()) + "  / \\ " +
                String.format("\t\t%s%s: %s\n", colored(playerTwo.getColor()), playerTwo.getName(), generateHealthBar(playerTwo.getLives())) +
                colored(playerOne.getColor()) + "/--+--0" + "\t\t" + colored(playerTwo.getColor()) + " /   \\\n" + colored(Color.RESET);
    }

    protected Color generateRandomColor(Random random) {
        List<Color> colors = Arrays.stream(Color.values())
                .filter(color -> !color.name().matches(".*UNDERLINED.*|.*BACKGROUND|.*BACKGROUND.*|RED.*|BLUE_BRIGHT|CYAN.*|WHITE.*|RESET"))
                .filter(color -> color.name().matches(".*BRIGHT"))
                .collect(Collectors.toList());
        Collections.shuffle(colors);
        return colors.get(random.nextInt(colors.size()));
    }

    protected String generateHealthBar(int health) {
        int barLength = 20;
        int filledBlocks = (int) Math.ceil((double) health / 100 * barLength);
        String color = health >= 70 ? colored(Color.GREEN) : health >= 40 ? colored(Color.YELLOW) : colored(Color.RED);
        StringBuilder healthBar = new StringBuilder(color);
        for (int i1 = 0; i1 < filledBlocks; i1++) {
            healthBar.append('█');
        }
        healthBar.append(colored(Color.RESET));
        for (int i = 0; i < (barLength - filledBlocks); i++) {
            healthBar.append(' ');
        }
        return healthBar.toString();
    }

    protected String colored(Color color) {
        return settings.colored ? color.value() : "";
    }
}
