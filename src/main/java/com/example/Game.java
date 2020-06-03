package com.example;
import java.util.*;
import java.lang.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int readInt(String message) {
        int ret;
        System.out.print(message);
        try {
            ret = scanner.nextInt();
            return ret;
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void onePlayerGame() throws InterruptedException {
        Board board = new Board();
        board.clearBoard();
        board.printBoard();
        while (true)
        {
            int c = 0;
            while (c <= 1) {
                int col = readInt("column to put your piece into:");
                if (board.placeAPiecePlayer(col, 1))
                {
                    ++c;
                }

            }
        }
    }
}
