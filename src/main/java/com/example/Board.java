package com.example;
import java.lang.*;
import java.util.*;

public class Board {
    int width = 7;
    int height = 7;
    char[][] grid = new char[height][width];
    int[] numInEachCol = new int[width];
    char player1piece = '@';
    char player2piece = 'O';
    public void clearBoard() {
        for (int x = 0; x <= width; ++x)
        {
            for (int y = 0; y <= height; ++y)
            {
                grid[y][x] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("0123456");
        for (int x = 0; x <= width; ++x)
        {
            for (int y = 0; y <= height; ++y)
            {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    public boolean placeAPiece(int col, int player)
    {
        if (col >= width
                || col < 0
                || numInEachCol[col] >= height
                || player > 2
                || player < 1)
        {
            return false;
        }
        ++numInEachCol[col];
        if (player == 1)
        {
            grid[numInEachCol[col]][col] = player1piece;
        }
        if (player == 2)
        {
            grid[numInEachCol[col]][col] = player2piece;
        }
        return true;
    }

    public boolean checkForWinner() {
        int player1MaxNumInARow = 0;
        int player1NumInARow = 0;
        int player2MaxNumInARow = 0;
        int player2NumInARow = 0;
        for (int x = 0; x <= width; ++x)
        {
            for (int y = 0; y <= height; ++y)
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
        for (int y = 0; y <= height; ++y)
        {
            for (int x = 0; x <= width; ++x)
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
            System.out.println("Player1Wins");
            return true;
        }
        return false;
    }
}
