import lombok.*;

import java.util.Arrays;
import java.util.Random;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Grid {
    private char[][] grid;
    private int gridSize;
    private int numberOfJunks;

    public Grid(int gridSize, int numberOfJunks) {
        this.gridSize = gridSize;
        this.numberOfJunks = numberOfJunks;
        createGrid();
        generateRandomnJunks();
    }

    public void createGrid() {
        grid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public int getRandomCoordinate() {
        Random r = new Random();
        int low = 0;
        int high = this.gridSize;
        return r.nextInt(high - low) + low;
    }

    public void generateRandomnJunks(){
        for (int i = 0; i < numberOfJunks; i++) {
            int x = getRandomCoordinate();
            int y = getRandomCoordinate();
            grid[x][y] = 'J';
        }
    }

    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        System.out.println(grid);
    }
}

