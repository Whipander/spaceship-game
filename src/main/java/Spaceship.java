import lombok.*;

@Getter
@Setter
@ToString


public class Spaceship {
    private int x;
    private int y;

    public Spaceship(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void move(char direction, int gridSize) {
        switch (Character.toUpperCase(direction)) {
            case 'W': if (x > 0) x--; break;
            case 'S': if (x < gridSize - 1) x++; break;
            case 'A': if (y > 0) y--; break;
            case 'D': if (y < gridSize - 1) y++; break;
            default:
                System.out.println("Invalid input. Use W/A/S/D.");
        }
    }
}
