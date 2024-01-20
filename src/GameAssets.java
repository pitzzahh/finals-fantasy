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
        return colored(Color.RED_BOLD) +
                "██     ██ ███████ ██       ██████  ██████  ███    ███ ███████     ████████  ██████  \n" + colored(Color.GREEN_BOLD) +
                "██     ██ ██      ██      ██      ██    ██ ████  ████ ██             ██    ██    ██ \n" + colored(Color.BLUE_BOLD) +
                "██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████          ██    ██    ██ \n" + colored(Color.PURPLE_BOLD) +
                "██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██             ██    ██    ██ \n" + colored(Color.YELLOW_BOLD) +
                " ███ ███  ███████ ███████  ██████  ██████  ██      ██ ███████        ██     ██████  \n" + colored(Color.RESET);
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

    protected String playerOneAttack() {
        return String.format("%s%s %sＡＴＴＡＣＫＳ %s%s with %d Damage\n", colored(settings.playerOne.getColor()), settings.playerOne.getName(), colored(Color.RED_BRIGHT), colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerOne.getDamage()) +
                colored(settings.playerOne.getColor()) + "\t\t  0   /" + "\t\t" + colored(settings.playerTwo.getColor()) + "|  0 \n" +
                colored(settings.playerOne.getColor()) + "\t\t--+--/ " + "\t\t" + colored(settings.playerTwo.getColor()) + "|--+-- " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t / \\  " + "\t\t" + colored(settings.playerTwo.getColor()) + "  / \\ " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t/   \\ " + "\t\t" + colored(settings.playerTwo.getColor()) + " /   \\\n" +
                colored(settings.playerOne.getColor()) + settings.playerOne.getName() + colored(Color.RESET) + " vs " + colored(settings.playerTwo.getColor()) + settings.playerTwo.getName() + "\n" +
                colored(Color.RED_BRIGHT) + "\t\t (Attack)\t\t\t " + colored(Color.BLUE_BRIGHT) + "(Defend)\n" + colored(Color.RESET);
    }

    protected String playerTwoAttack() {
        return
                String.format("%s%s %sＡＴＴＡＣＫＳ %s%s with %d Damage\n", colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), colored(Color.RED_BRIGHT), colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerTwo.getDamage()) +
                        colored(settings.playerOne.getColor()) + "\t\t  0  |" + "\t\t" + colored(settings.playerTwo.getColor()) + "\\   0  \n" +
                        colored(settings.playerOne.getColor()) + "\t\t--+--|" + "\t\t" + colored(settings.playerTwo.getColor()) + " \\--+--  " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                        colored(settings.playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(settings.playerTwo.getColor()) + "   / \\   " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                        colored(settings.playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(settings.playerTwo.getColor()) + "  /   \\\n" +
                        colored(settings.playerOne.getColor()) + settings.playerOne.getName() + colored(Color.RESET) + " vs " + colored(settings.playerTwo.getColor()) + settings.playerTwo.getName() + "\n" +
                        colored(Color.BLUE_BRIGHT) + "\t\t (Defend)\t\t\t " + colored(Color.RED_BRIGHT) + "(Attack)\n" + colored(Color.RESET);
    }

    protected String bothAttack() {
        return
                String.format("Both Player %sＡＴＴＡＣＫＳ %s%s - %d Damage %s| %s%s - %d Damage\n", colored(Color.RED_BRIGHT), colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getDamage(), colored(Color.RESET), colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getDamage()) +
                        colored(settings.playerOne.getColor()) + "\t\t  0   /" + "\t\t" + colored(settings.playerTwo.getColor()) + "\\   0  \n" +
                        colored(settings.playerOne.getColor()) + "\t\t--+--/ " + "\t\t" + colored(settings.playerTwo.getColor()) + " \\--+--  " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                        colored(settings.playerOne.getColor()) + "\t\t / \\  " + "\t\t" + colored(settings.playerTwo.getColor()) + "   / \\   " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                        colored(settings.playerOne.getColor()) + "\t\t/   \\ " + "\t\t" + colored(settings.playerTwo.getColor()) + "  /   \\\n" +
                        colored(settings.playerOne.getColor()) + settings.playerOne.getName() + colored(Color.RESET) + " vs " + colored(settings.playerTwo.getColor()) + settings.playerTwo.getName() + "\n" +
                        colored(Color.RED_BRIGHT) + "\t\t (Attack)\t\t\t " + colored(Color.RED_BRIGHT) + "(Attack)\n" + colored(Color.RESET);
    }

    protected String bothDefend() {
        return String.format("Both Player %sＤＥＦＥＮＤＳ %s%s - %d Damage %s| %s%s - %d Damage\n", colored(Color.BLUE_BRIGHT), colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getDamage(), colored(Color.RESET), colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getDamage()) +
                colored(settings.playerOne.getColor()) + "\t\t  0  |" + "\t\t" + colored(settings.playerTwo.getColor()) + "|  0 \n" +
                colored(settings.playerOne.getColor()) + "\t\t--+--|" + "\t\t" + colored(settings.playerTwo.getColor()) + "|--+-- " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(settings.playerTwo.getColor()) + "  / \\ " + String.format("\t%s%s - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(settings.playerTwo.getColor()) + " /   \\\n" +
                colored(settings.playerOne.getColor()) + settings.playerOne.getName() + colored(Color.RESET) + " vs " + colored(settings.playerTwo.getColor()) + settings.playerTwo.getName() + "\n" +
                colored(Color.BLUE_BRIGHT) + "\t\t (Defend)\t\t\t " + colored(Color.BLUE_BRIGHT) + "(Defend)\n" + colored(Color.RESET);
    }

    protected String bothRest() {
        return String.format("Both Player %sＲＥＳＴＳ %s%s - %d HP %s| %s%s - %d HP\n", colored(Color.BLUE_BRIGHT), colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getLives(), colored(Color.RESET), colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getLives()) +
                colored(settings.playerOne.getColor()) + "\t\t  0   " + "\t\t" + colored(settings.playerTwo.getColor()) + "  0 \n" +
                colored(settings.playerOne.getColor()) + "\t\t--+-- " + "\t\t" + colored(settings.playerTwo.getColor()) + "--+-- " + String.format("\t%s%s - No Damage - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t / \\ " + "\t\t" + colored(settings.playerTwo.getColor()) + " / \\ " + String.format("\t%s%s - No Damage - %d HP:%s\n", colored(Color.BLUE_BRIGHT), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t/   \\" + "\t\t" + colored(settings.playerTwo.getColor()) + "/   \\\n" +
                colored(settings.playerOne.getColor()) + settings.playerOne.getName() + colored(Color.RESET) + " vs " + colored(settings.playerTwo.getColor()) + settings.playerTwo.getName() + "\n" +
                colored(Color.GREEN_BRIGHT) + "\t\t (Rest)\t\t\t " + colored(Color.GREEN_BRIGHT) + "(Rest)\n" + colored(Color.RESET);
    }

    protected String playerOneWins() {
        return String.format("%s%s %sＷＩＮＳ\n", colored(settings.playerOne.getColor()), settings.playerOne.getName(), colored(Color.BLUE_BOLD)) +
                colored(settings.playerOne.getColor()) + "\t\t\\  0  /" + "\n" +
                colored(settings.playerOne.getColor()) + "\t\t --+-- " + String.format("\t\t\t\t%s%s: %d HP:%s\n", colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t  / \\ " + String.format("\t\t\t\t%s%s: %d HP:%s\n", colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t /   \\" + "\t\t" + colored(settings.playerTwo.getColor()) + "/--+--0\n" + colored(Color.RESET);
    }

    protected String playerTwoWins() {
        return String.format("%s%s %sＷＩＮＳ\n", colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), colored(Color.BLUE_BOLD)) +
                colored(settings.playerOne.getColor()) + "\t\t\t" + colored(settings.playerTwo.getColor()) + "\\  0  /\n" +
                colored(settings.playerOne.getColor()) + "\t\t\t" + colored(settings.playerTwo.getColor()) + " --+-- " + String.format("\t\t%s%s: %d HP:%s\n", colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                colored(settings.playerOne.getColor()) + "\t\t\t" + colored(settings.playerTwo.getColor()) + "  / \\ " + String.format("\t\t%s%s: %d HP:%s\n", colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "/--+--0" + "\t\t" + colored(settings.playerTwo.getColor()) + " /   \\\n" + colored(Color.RESET);
    }

    protected String bothLost() {
        return String.format("Both Players %sＬＯＳＴ\n", colored(Color.RED_BOLD)) +
                String.format("\t\t\t\t\t%s%s: %d HP:%s\n", colored(settings.playerOne.getColor()), settings.playerOne.getName(), settings.playerOne.getLives(), generateHealthBar(settings.playerOne.getLives())) +
                String.format("\t\t\t\t\t%s%s: %d HP:%s\n", colored(settings.playerTwo.getColor()), settings.playerTwo.getName(), settings.playerTwo.getLives(), generateHealthBar(settings.playerTwo.getLives())) +
                colored(settings.playerOne.getColor()) + "/--+--0" + "\t\t" + colored(settings.playerTwo.getColor()) + "/--+--0" + colored(Color.RESET);
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
        int barLength = 30;
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
