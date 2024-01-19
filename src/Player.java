public class Player {
    private String name;
    private String color;
    private int score;
    private int lives;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Player(String name, String color, int score, int lives) {
        this.name = name;
        this.color = color;
        this.score = score;
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
}
