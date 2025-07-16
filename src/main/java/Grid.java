import lombok.Getter;

import java.util.*;
    @Getter

public class Grid {
    private final int size;
    private final char[][] cells;
    private final Set<String> junkPositions = new HashSet<>();
    private final Random random = new Random();

    public Grid(int size) {
        this.size = size;
        this.cells = new char[size][size];
        initializeGrid();
    }

    public void initializeGrid() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cells[i][j] = '.';
    }

    public void placeJunks(int spaceshipX, int spaceshipY, int numberOfJunks) {
        junkPositions.clear();
        while (junkPositions.size() < numberOfJunks) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            String pos = x + "," + y;
            if ((x != spaceshipX || y != spaceshipY) && !junkPositions.contains(pos)) {
                junkPositions.add(pos);
            }
        }
    }

    public boolean checkJunkCollected(int x, int y) {
        String pos = x + "," + y;
        if (junkPositions.contains(pos)) {
            junkPositions.remove(pos);
            return true;
        }
        return false;
    }

    public void render(int spaceshipX, int spaceshipY) {
        initializeGrid(); // clear grid
        for (String pos : junkPositions) {
            String[] parts = pos.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            cells[x][y] = 'J';
        }
        cells[spaceshipX][spaceshipY] = 'S';

        for (char[] row : cells) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public boolean allJunksCollected() {
        return junkPositions.isEmpty();
    }
}
