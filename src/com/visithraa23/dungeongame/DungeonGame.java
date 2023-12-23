package com.visithraa23.dungeongame;

import java.util.Scanner;

public class DungeonGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DungeonGame game = new DungeonGame();
		game.Question2();

	}

	private void Question2() {
		System.out.println("Dimensions of Dungeon:");
		int row = sc.nextInt();
		int column = sc.nextInt();
		System.out.println("Position of Adventurer:");
		int adRow = sc.nextInt();
		int adCol = sc.nextInt();
		System.out.println("Position of Monster");
		int monRow=sc.nextInt();
		int monCol=sc.nextInt();
		System.out.println("Position of Gold:");
		int goldRow = sc.nextInt();        
		int goldCol = sc.nextInt();

		if (adRow > row || adCol > column) {
			System.out.println("Adventure position is limit exceeded");
		} else if (goldRow > row || goldCol > column) {
			System.out.println("Gold position is limit exceeded");
		} 
		else if(monRow>row||monCol>column){
			System.out.println("monster position is limit exceeded");
		}
		else {
			int AdventurePath = Math.abs(adRow - goldRow) + Math.abs(adCol - goldCol);
			int MonsterPath=Math.abs(monRow-goldRow)+Math.abs(monCol-goldCol);
			
			if(MonsterPath<AdventurePath)
				System.out.println("No Possible solution" );
			else {
				System.out.println("Minimum Number of Steps "+AdventurePath);
			}
			
		}
	}
}
