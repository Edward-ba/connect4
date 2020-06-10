package com.example;
import java.util.*;
import java.lang.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int readInt(String message) {
        System.out.print(message);
        int ret;

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
            Coordinates coordinates = board.placeAPiece(col, 1);
            while (!coordinates.check) {
                col = readInt("\n" + board.tryMessage + ":");
                coordinates = board.placeAPiece(col, 1);
            }
            board.printBoard();

            if (board.checkForWinner(coordinates))
            {
                break;
            }
            int check = 0;

            while (check < 1) {
                col = random.nextInt(board.width);
                coordinates = board.placeAPiece(col, 1);
                if (!coordinates.check)
                    ++check;
            }
            board.printBoard();

            if (board.checkForWinner(coordinates))
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
            int col = readInt("Player One please enter the column you want to put your piece into:");
            Coordinates coordinates = board.placeAPiece(col, 1);
            while (!coordinates.check) {
                col = readInt("\nPlayer One" + Board.tryMessage + ":");
                coordinates = board.placeAPiece(col, 1);
            }
            board.printBoard();

            if (board.checkForWinner(coordinates))
                break;

                col = readInt("Player One please enter the column you want to put your piece into:");
                coordinates = board.placeAPiece(col, 1);
                while (!coordinates.check) {
                    col = readInt("\nPlayer Two" + board.tryMessage + ":");
                    coordinates = board.placeAPiece(col, 1);
                }
            board.printBoard();

            if (board.checkForWinner(coordinates))
                break;
        }
    }
}