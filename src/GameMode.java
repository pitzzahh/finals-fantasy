/**
 * GameMode enum. This enum is used to define the game mode
 *
 * @author Peter John Arao
 */
public enum GameMode {
    HUMAN_VS_COMPUTER("Human vs Computer"),
    COMPUTER_VS_COMPUTER("Computer vs Computer");
    private final String value;

    GameMode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
