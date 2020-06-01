package com.example;

public class Board {
    int width = 7;
    int height = 7;
    char[][] grid = new char[height][width];
    int[] numInEachCol = new int[width];

    public void clearBoard() {
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                grid[y][x] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("0123456");
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    public boolean placeAPiece(int col)
    {
        if (col > width || col < 0)
        {
            return false;
        }
        return true;
    }
}
