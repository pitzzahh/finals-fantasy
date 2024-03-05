
/**
 * The Action interface is used to define the actions that a player can do
 *
 * @author Peter John Arao
 */
public interface Action {
    /**
     * A player can attack another player
     *
     * @param player The player to gain damage
     */
    void attack(Player player);

    /**
     * A player can defend
     */
    void defend();

    void rest();
}
