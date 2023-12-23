package com.visithraa23.dungeongame;

import java.util.Scanner;

public class DungeonGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DungeonGame game = new DungeonGame();
		game.Question1();

	}

	private void Question1() {
		System.out.println("Dimensions of Dungeon:");
		int row = sc.nextInt();
		int column = sc.nextInt();
		System.out.println("Position of Adventurer:");
		int adRow = sc.nextInt();
		int adCol = sc.nextInt();
		System.out.println("Position of Gold:");
		int goldRow = sc.nextInt();
		int goldCol = sc.nextInt();

		if (adRow > row && adCol > column) {
			System.out.println("Adventure position is limit exceeded");
		} else if (goldRow > row && goldCol > column) {
			System.out.println("Gold position is limit exceeded");
		} else {
			int res = Math.abs(adRow - goldRow) + Math.abs(adCol - goldCol);
			System.out.println("Minimum Number of Steps " + res);
		}
	}
}
