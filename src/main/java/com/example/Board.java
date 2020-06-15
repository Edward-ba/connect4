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
        for (int x = 0; x < width; ++x) {
            nxtAvailRow[x] = 0;
            for (int y = 0; y < height; ++y)
                 grid[x][y] = ' ';
        }
    }

    public void printBoard() {
        for (int i = 0; i < width; ++i) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int y = height-1; y >= 0; --y) {
            System.out.print("|");
            for (int x = 0; x < width; ++x)
                System.out.print(grid[x][y]+" ");
            System.out.println("|");
        }
        for (int i = 0; i < width; ++i) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public Coordinates placeAPiece(int col, int player) {
        Coordinates coordinates = new Coordinates();
        if ((col >= width)
                || (col < 0)
                || (nxtAvailRow[col] >= height)
                || (player > 2)
                || (player < 1)) {
            if (onePlayer && player == 2) {
                coordinates.check = false;
                return coordinates;
            }
            coordinates.check = false;
            return coordinates;
        }

        grid[col][nxtAvailRow[col]] = (player == 1) ? player1piece : player2piece;
        nxtAvailRow[col] += 1;
        coordinates.x = col;
        coordinates.check = true;
        return coordinates;
    }

    public boolean checkForWinnerNorthEastDiagonal(Coordinates cor)
    {
        int player1MaxNumInARow = 0;
        int player1NumInARow = 0;
        int player2MaxNumInARow = 0;
        int player2NumInARow = 0;

        Coordinates start = new Coordinates();
        start.x = cor.x - 4;
        start.y = cor.y - 4;
        Coordinates end = new Coordinates();
        end.x = cor.x + 4;
        end.y = cor.x + 4;

        if (start.x < 0)
            start.x = 0;
        if (start.y < 0)
            start.y = 0;
        if (end.x > width)
            end.x = width;
        if (end.y > height)
            end.y = height;

        while (start.x < end.x || start.y < end.y) {
            if (grid[start.x][start.y] == player1piece) {
                ++player1NumInARow;
                if (player1NumInARow > player1MaxNumInARow) {
                    player1MaxNumInARow = player1NumInARow;
                    if (player1MaxNumInARow >= 4) {
                        if (onePlayer)
                            System.out.println("You Win! :)");
                        else
                            System.out.println("Player 1 Wins");
                        return true;
                    }
                }
            }
            if (grid[start.x][start.y] == player2piece) {
                ++player2NumInARow;
                if (player2NumInARow > player2MaxNumInARow) {
                    player2MaxNumInARow = player2NumInARow;
                    if (player2MaxNumInARow >= 4) {
                        System.out.println("Player 2 Wins");
                        return true;
                    }
                }
            }
            else {
                player1NumInARow = 0;
                player2NumInARow = 0;
            }
            ++start.y;
            ++start.x;
        }

        return false;
    }

    public boolean checkForWinnerHorizontal(Coordinates cor) {
        int player1MaxNumInARow = 0;
        int player1NumInARow = 0;
        int player2MaxNumInARow = 0;
        int player2NumInARow = 0;
        int start = cor.x - 4;
        int end = cor.x + 4;

        if (start < 0)
            start = 0;
        if (end > width)
            end = width;

        for ( ; start < end; ++start) {
            if (grid[start][cor.y] == player1piece) {
                ++player1NumInARow;
                if (player1NumInARow > player1MaxNumInARow) {
                    player1MaxNumInARow = player1NumInARow;
                    if (player1MaxNumInARow >= 4) {
                        if (onePlayer)
                            System.out.println("You Win! :)");
                        else
                            System.out.println("Player 1 Wins");
                        return true;
                    }
                }
            }
            if (grid[start][cor.y] == player2piece) {
                ++player2NumInARow;
                if (player2NumInARow > player2MaxNumInARow) {
                    player2MaxNumInARow = player2NumInARow;
                    if (player2MaxNumInARow >= 4) {
                        System.out.println("Player 2 Wins");
                        return true;
                    }
                }
            }
            else {
                player1NumInARow = 0;
                player2NumInARow = 0;
            }
        }
        return false;
    }

    public boolean checkForWinnerVertical(Coordinates cor) {
        int player1MaxNumInARow = 0;
        int player1NumInARow = 0;
        int player2MaxNumInARow = 0;
        int player2NumInARow = 0;
        int start = cor.y - 4;
        int end = cor.y + 4;
        if (start < 0)
            start = 0;
        if (end > height)
            end = height;
        for ( ; start < end; ++start) {
            if (grid[cor.x][start] == player1piece) {
                ++player1NumInARow;
                if (player1NumInARow > player1MaxNumInARow) {
                    player1MaxNumInARow = player1NumInARow;
                    if (player1MaxNumInARow >= 4) {
                        if (onePlayer)
                            System.out.println("You Win! :)");
                        else
                            System.out.println("Player 1 Wins");
                        return true;
                    }
                }
            }
            if (grid[cor.x][start] == player2piece) {
                ++player2NumInARow;
                if (player2NumInARow > player2MaxNumInARow) {
                    player2MaxNumInARow = player2NumInARow;
                    if (player2MaxNumInARow >= 4) {
                        System.out.println("Player 2 Wins");
                        return true;
                    }
                }
            }
            else {
                player1NumInARow = 0;
                player2NumInARow = 0;
            }
        }
        return false;
    }

    public boolean checkForWinner(Coordinates cor) {
        if (checkForWinnerVertical(cor))
            return true;
        else if (checkForWinnerHorizontal(cor))
            return true;
        else if (checkForWinnerNorthEastDiagonal(cor))
            return true;
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
