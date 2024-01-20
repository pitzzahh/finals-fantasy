public interface Action {
    /**
     * A player can attack another player
     * @param player The player to gain damage
     * @return The player with the damage
     */
    Player attack(Player player);

    /**
     * A player can defend
     * @return The player with the defense
     */
    Player defend();
}
