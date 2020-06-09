package com.example;
import java.lang.*;
import java.util.*;

public class Board {
    static final public String tryMessage = "Try Again";
    static final int width = 7;
    static final int height = 6;
    static final char player1piece = '@';
    static final char player2piece = 'O';

    boolean onePlayer;
    Random random = new Random();
    char[][] grid = new char[width][height];
    int[] nxtAvailRow = new int[width];

    public void clearBoard() {
        for (int x = 0; x < width; ++x)
        {
            nxtAvailRow[x] = 0;
            for (int y = 0; y < height; ++y)
                 grid[x][y] = ' ';
        }
    }

    public void printBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int y = height-1; y >= 0; --y)
        {
            System.out.print("|");
            for (int x = 0; x < width; ++x)
                System.out.print(grid[x][y]+" ");
            System.out.println("|");
        }
        System.out.println(" 0 1 2 3 4 5 6 ");
    }

    public boolean placeAPiece(int col, int player)
    {
        if ((col >= width)
                || (col < 0)
                || (nxtAvailRow[col] >= height)
                || (player > 2)
                || (player < 1)) {
            if (onePlayer && player == 2)
                return false;
            return false;
        }

        grid[col][nxtAvailRow[col]] = (player == 1) ? player1piece : player2piece;
        nxtAvailRow[col] += 1;
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
                if (grid[x][y] == player1piece) {
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
                else if (grid[x][y] == player2piece) {
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
                if (grid[x][y] == player1piece) {
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
                else if (grid[x][y] == player2piece) {
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

                if (grid[x][y] == player1piece)
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
                else if (grid[x][y] == player2piece)
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
                if (grid[x][y] == player1piece)
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
                else if (grid[x][y] == player2piece)
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

    public int piecesToWin(int col, int player)
    {
        // temp put piece

        // calc score

        // remove piece
        return 0;
    }
}
