package com.example;
import java.lang.*;
import java.util.*;

public class Board1 {
    static final public String tryMessage = "Try Again";
    static final int width = 7;
    static final int height = 6;
    static final char player1piece = '@';
    static final char player2piece = 'O';

    boolean onePlayer;
    Random random = new Random();
    char[][] grid = new char[height][width];
    int[] numInEachCol = new int[width];

    public void clearBoard() {
        for (int x = 0; x < width; ++x)
        {
            numInEachCol[x] = height - 1;
            for (int y = 0; y < height; ++y)
                 grid[y][x] = ' ';
        }
    }

    public void printBoard() {
        System.out.println(" 0123456");
        for (int x = 0; x < width; ++x)
        {
            System.out.print("|");
            for (int y = 0; y < height; ++y)
                System.out.print(grid[y][x]);
            System.out.println("|");
        }
        System.out.println(" 0123456");
    }

    public boolean placeAPiece(int col, int player)
    {
        if ((col >= width)
                || (col < 0)
                || (numInEachCol[col] < 0)
                || (player > 2)
                || (player < 1)) {
            if (onePlayer && player == 2)
                return false;
            return false;
        }

        grid[col][numInEachCol[col]] = (player == 1) ? player1piece : player2piece;

        numInEachCol[col] -= 1;
        return true;
    }
    public boolean checkForWinnerHorizontal() {
        int player1MaxNumInARow = 0;
        int player1NumInARow;
        int player2MaxNumInARow = 0;
        int player2NumInARow;

        for (int y = 0; y < height; ++y) {
            player1NumInARow = 0;
            player2NumInARow = 0;

            for (int x = 0; x < width; ++x) {
                if (grid[y][x] == player1piece) {
                    ++player1NumInARow;

                    if (player1NumInARow > player1MaxNumInARow) {
                        player1MaxNumInARow = player1NumInARow;

                        if (player1MaxNumInARow >= 4) {
                            System.out.println("Player 1 Wins");
                            return true;
                        }
                    }
                    player2NumInARow = 0;
                }
                else if (grid[y][x] == player2piece) {
                    ++player2NumInARow;

                    if (player2NumInARow > player2MaxNumInARow) {
                        player2MaxNumInARow = player2NumInARow;

                        if (player2MaxNumInARow >= 4) {
                            System.out.println("Player 2 Wins");
                            return true;
                        }
                    }
                    player1NumInARow = 0;
                }
                else {
                    player2NumInARow = 0;
                    player1NumInARow = 0;
                }
            }
        }
        return false;
    }

    public boolean checkForWinnerVertical() {
        int player1MaxNumInARow = 0;
        int player1NumInARow;
        int player2MaxNumInARow = 0;
        int player2NumInARow;

        for (int x = 0; x < width; ++x) {
            player1NumInARow = 0;
            player2NumInARow = 0;

            for (int y = 0; y < height; ++y) {
                if (grid[y][x] == player1piece) {
                    ++player1NumInARow;

                    if (player1NumInARow > player1MaxNumInARow) {
                        player1MaxNumInARow = player1NumInARow;

                        if (player1MaxNumInARow >= 4) {
                            System.out.println("Player 1 Wins");
                            return true;
                        }
                    }
                    player2NumInARow = 0;
                }
                else if (grid[y][x] == player2piece) {
                    ++player2NumInARow;

                    if (player2NumInARow > player2MaxNumInARow) {
                        player2MaxNumInARow = player2NumInARow;

                        if (player2MaxNumInARow >= 4) {
                            System.out.println("Player 2 Wins");
                            return true;
                        }
                    }
                    player1NumInARow = 0;
                }
                else {
                    player2NumInARow = 0;
                    player1NumInARow = 0;
                }
            }
        }
        return false;
    }

    public boolean checkForWinner() {
        int player1MaxNumInARow = 0;
        int player1NumInARow;
        int player2MaxNumInARow = 0;
        int player2NumInARow;

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

                        if (player1MaxNumInARow >= 4)
                        {
                            System.out.println("Player 1 Wins");
                            return true;
                        }
                    }
                    player2NumInARow = 0;
                }
                else if (grid[y][x] == player2piece)
                {
                    ++player2NumInARow;

                    if (player2NumInARow > player2MaxNumInARow)
                    {
                        player2MaxNumInARow = player2NumInARow;
                        if (player2MaxNumInARow >= 4)
                        {
                            System.out.println("Player 2 Wins");
                            return true;
                        }
                    }
                    player1NumInARow = 0;
                }
                else
                {
                    player2NumInARow = 0;
                    player1NumInARow = 0;
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

                        if (player1MaxNumInARow >= 4)
                        {
                            System.out.println("Player 1 Wins");
                            return true;
                        }
                    }
                    player2NumInARow = 0;
                }
                else if (grid[y][x] == player2piece)
                {
                    ++player2NumInARow;

                    if (player2NumInARow > player2MaxNumInARow)
                    {
                        player2MaxNumInARow = player2NumInARow;

                        if (player2MaxNumInARow >= 4) {
                            System.out.println("Player 2 Wins");
                            return true;
                        }
                    }
                    player1NumInARow = 0;
                }
                else
                {
                    player2NumInARow = 0;
                    player1NumInARow = 0;
                }
            }
        }

        return false;
    }
}
