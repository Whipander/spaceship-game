import java.util.Scanner;

public class Game {
    private final int GRID_SIZE = 10;
    private final int maxMoves;
    private final int targetJunks;

    private int score = 0;
    private int moves = 0;

    public Game(int maxMoves, int targetJunks) {
        this.maxMoves = maxMoves;
        this.targetJunks = targetJunks;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Spaceship spaceship = new Spaceship(0, 0);
        Grid grid = new Grid(GRID_SIZE);
        grid.placeJunks(spaceship.getX(), spaceship.getY(), targetJunks);

        while (score < targetJunks && moves < maxMoves) {
            System.out.println("\nScore: " + score + " / " + targetJunks);
            System.out.println("Moves left: " + (maxMoves - moves));
            grid.render(spaceship.getX(), spaceship.getY());

            System.out.print("Move (W/A/S/D): ");
            String input = scanner.nextLine();
            if (input.length() == 0) continue;

            char move = input.charAt(0);
            int oldX = spaceship.getX();
            int oldY = spaceship.getY();

            spaceship.move(move, GRID_SIZE);

            if (spaceship.getX() != oldX || spaceship.getY() != oldY) {
                moves++;
            }

            if (grid.checkJunkCollected(spaceship.getX(), spaceship.getY())) {
                score++;
                System.out.println("You collected a junk! 🎉");
            }
        }

        grid.render(spaceship.getX(), spaceship.getY());

        if (score >= targetJunks) {
            System.out.println("\nCongratulations! You collected all junks! 🏆");
        } else {
            System.out.println("\nGame Over! You ran out of moves. 💀");
        }

        System.out.println("Final Score: " + score + " / " + targetJunks);
        scanner.close();
    }

    public static void main(String[] args) {
        int maxMoves = 30;
        int targetJunks = 5;
        new Game(maxMoves, targetJunks).start();
    }
}
