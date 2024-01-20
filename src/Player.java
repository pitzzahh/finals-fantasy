import java.util.Random;

public class Player implements Action {
    private final String name;
    private final Color color;
    private int lives;
    private int damage;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        setLives(100);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void attack(Player player) {
        setDamage(new Random().nextInt(player.getLives()) + 1);
        player.setLives(player.getLives() - getDamage());
    }

    @Override
    public void defend() {
        setDamage(0);
    }
}
