package com.example;
import java.util.*;
import java.lang.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int readInt(String message) {
        Board board = new Board();
        System.out.print(message);
        int ret = 0;
        try {
            String string = scanner.nextLine();
            ret = Integer.parseInt(string);
            return ret;
        } catch (Exception e) {
            return -1;
        }
    }

    public void onePlayerGame() {
        Board board = new Board();
        board.onePlayer = true;
        board.clearBoard();
        board.printBoard();
        while (true)
        {
            int col = readInt("column to put your piece into:");
            while (!board.placeAPiece(col, 1))
            {
                col = readInt("\n" + board.tryMessage + ":");
            }
            board.printBoard();
            if (board.checkForWinner())
            {
                System.out.println("You win!");
                break;
            }

            int check = 0;
            while (check < 1) {
                col = random.nextInt(board.width);
                if (board.placeAPiece(col, 2)) {
                    ++check;
                }
            }
            board.printBoard();
            if (board.checkForWinner())
            {
                System.out.println("Computer wins :(");
                break;
            }
        }
    }

    public void twoPlayerGame() {
        Board board = new Board();
        board.onePlayer = true;
        board.clearBoard();
        board.printBoard();
        while (true)
        {
            int col = readInt("Player one please enter the column you want to put your piece into:");
            while (!board.placeAPiece(col, 1))
            {
                col = readInt("\nPlayer One" + board.tryMessage + ":");
            }
            board.printBoard();
            if (board.checkForWinner())
            {
                break;
            }

            col = readInt("Player two please enter the column you want to put your piece into:");
            while (!board.placeAPiece(col, 1))
            {
                col = readInt("\nPlayer Two" + board.tryMessage + ":");
            }
            board.printBoard();
            if (board.checkForWinner())
            {
                break;
            }
        }
    }
}
