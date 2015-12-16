package invalid.domain.battleship.console;

import java.util.ArrayList;
import java.util.Scanner;

import invalid.domain.battleship.Battleship;
import invalid.domain.battleship.board.SelfBoard;
import invalid.domain.battleship.pieces.Peg;
import invalid.domain.battleship.pieces.Ship;

public class ConsoleManager {
	Scanner in;
	
	public ConsoleManager() {
		in = new Scanner(System.in);
	}
	
	public Peg getMove() {
		System.out.print("Enter move: ");
		char[] moveStr;
		Peg move;
		while (true) { //unorthodox, but it works
			moveStr = in.nextLine().toCharArray();
			if (moveStr.length == 2 && Character.isLetter(moveStr[0]) && Character.isDigit(moveStr[1])
					&& toNum(moveStr[0]) <= 10 && moveStr[1] <= 10) { 
				move = new Peg(1, 1);
				return move;
			} else
				System.out.print("Error: invalid input!");
		}
	}
	
	public void printBoard(SelfBoard b) {
		System.out.print("+---+---+---+---+---+---+---+---+---+---+\n");
		for (int j = 0; j < 10; j++) {
			System.out.print("|");
			for (int i = 0; i < 10; i++) {
				System.out.printf(" %s |", b.getSpaceTxt(j, i));
			}
			System.out.print("\n+---+---+---+---+---+---+---+---+---+---+\n");
		}
	}
	
	private int toNum(char c) {
		if (Character.isLetter(c)) {
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			return alphabet.indexOf(Character.toLowerCase(c)) + 1;
		} else
			return -1; //should never happen, but accounting for all possibilities
	}
}
