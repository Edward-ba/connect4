package com.example;
import java.lang.*;
import java.util.*;

public class Board {
    private String tryMessage = "Try Again";
    Random random = new Random();
    int width = 7;
    int height = 7;
    char[][] grid = new char[height][width];
    int[] numInEachCol = new int[width];
    char player1piece = '@';
    char player2piece = 'O';
    public void clearBoard() {
        for (int x = 0; x < width; ++x)
        {
            numInEachCol[x] = height - 1;
            for (int y = 0; y < height; ++y)
            {
                grid[y][x] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println(" 0123456");
        for (int x = 0; x < width; ++x)
        {
            System.out.print("|");
            for (int y = 0; y < height; ++y)
            {
                System.out.print(grid[y][x]);
            }
            System.out.println("|");
        }
        System.out.println(" 0123456");
    }

    public boolean placeAPiecePlayer(int col, int player)
    {
        if (col >= width
                || col < 0
                || numInEachCol[col] < 0
                || player > 2
                || player < 1)
        {
            System.out.println(tryMessage);
            return false;
        }
        if (player == 1)
        {
            grid[col][numInEachCol[col]] = player1piece;
        }
        if (player == 2)
        {
            grid[col][numInEachCol[col]] = player2piece;
        }
        numInEachCol[col] -= 1;
        return true;
    }
    public boolean placeAPieceComputer()
    {
        int col = random.nextInt(width);
        if (numInEachCol[col] < 0)
        {
            return false;
        }
        grid[col][numInEachCol[col]] = player2piece;
        numInEachCol[col] -= 1;
        return true;
    }

    public boolean checkForWinner() {
        int player1MaxNumInARow = 0;
        int player1NumInARow = 0;
        int player2MaxNumInARow = 0;
        int player2NumInARow = 0;
        for (int x = 0; x < width; ++x)
        {
            player1NumInARow = 0;
            player2NumInARow = 0;
            for (int y = 0; y < height; ++y)
            {

                if (grid[y][x] == player1piece)
                {
                    ++player1NumInARow;
                    if (player1NumInARow > player1MaxNumInARow)
                    {
                        player1MaxNumInARow = player1NumInARow;
                    }
                }
                else
                {
                    player1NumInARow = 0;
                }
                if (grid[y][x] == player2piece)
                {
                    ++player2NumInARow;
                    if (player2NumInARow > player2MaxNumInARow)
                    {
                        player2MaxNumInARow = player2NumInARow;
                    }
                }
                else
                {
                    player2NumInARow = 0;
                }
            }
        }
        for (int y = 0; y < height; ++y)
        {
            player1NumInARow = 0;
            player2NumInARow = 0;
            for (int x = 0; x < width; ++x)
            {
                if (grid[y][x] == player1piece)
                {
                    ++player1NumInARow;
                    if (player1NumInARow > player1MaxNumInARow)
                    {
                        player1MaxNumInARow = player1NumInARow;
                    }
                }
                else
                {
                    player1NumInARow = 0;
                }
                if (grid[y][x] == player2piece)
                {
                    ++player2NumInARow;
                    if (player2NumInARow > player2MaxNumInARow)
                    {
                        player2MaxNumInARow = player2NumInARow;
                    }
                }
                else
                {
                    player2NumInARow = 0;
                }
            }
        }
        if (player1MaxNumInARow >= 4)
        {
            System.out.println("Player 1 Wins");
            return true;
        }
        if (player2MaxNumInARow >= 4)
        {
            System.out.println("Player 2 Wins");
        }
        return false;
    }
}
