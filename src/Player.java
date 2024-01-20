import java.util.Objects;
import java.util.Random;

public class Player implements Action {
    private String name;
    private Color color;
    private int score;
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

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
    public Player attack(Player player) {
        setDamage(new Random().nextInt(player.getLives() - (player.getLives() / 2)));
        player.setLives(player.getLives() - getDamage());
        return player.defend();
    }

    @Override
    public Player defend() {
        setDamage(0);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() && getLives() == player.getLives() && Objects.equals(getName(), player.getName()) && Objects.equals(getColor(), player.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getScore(), getLives());
    }
}
