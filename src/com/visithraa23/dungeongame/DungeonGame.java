package com.visithraa23.dungeongame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DungeonGame game = new DungeonGame();
		game.Question2();

	}

	private void Question2() {
		DungeonGame game = new DungeonGame();
		System.out.println("Dimensions of Dungeon:");
		int row = sc.nextInt();
		int column = sc.nextInt();
		System.out.println("Position of Adventurer:");
		int adRow = sc.nextInt();
		int adCol = sc.nextInt();
		System.out.println("Position of Monster");
		int monRow = sc.nextInt();
		int monCol = sc.nextInt();
		System.out.println("Position of Trigger:");
		int trigRow = sc.nextInt();
		int trigCol = sc.nextInt();
		System.out.println("Position of Gold:");
		int goldRow = sc.nextInt();
		int goldCol = sc.nextInt();

		if (adRow > row || adCol > column) {
			System.out.println("Adventure position is limit exceeded");
		} else if (goldRow > row || goldCol > column) {
			System.out.println("Gold position is limit exceeded");
		} else if (monRow > row || monCol > column) {
			System.out.println("monster position is limit exceeded");
		} 
		else if (trigRow > row || trigCol > column) {
			System.out.println("Trigger position is limit exceeded");
		} 
		else {
			int adventurePath = Math.abs(adRow - goldRow) + Math.abs(adCol - goldCol);
			int monsterPath = Math.abs(monRow - goldRow) + Math.abs(monCol - goldCol);

			if (monsterPath < adventurePath) {
				//System.out.println("No Possible solution");
				int advenToTrigPath=Math.abs(adRow-trigRow)+Math.abs(adCol-trigCol);
				int trigTOGoldPath=Math.abs(trigRow-goldRow)+Math.abs(trigCol-goldCol);
				
				System.out.println("Minimum number of Steps "+(advenToTrigPath+trigTOGoldPath));
			}
				
			else {
				//game.PrintPath(adRow, adCol, goldRow, goldCol);
				System.out.println("Minimum number of Steps "+adventurePath);
			}

		}
	}

	private void PrintPath(int adRow, int adCol, int goldRow, int goldCol) {

		List<List<Integer>> list = new ArrayList<>();
		Boolean b = true;
		
		//if(adRow<)
		while (b) {
			List<Integer> li = new ArrayList<>();
			li.add(adRow );
			li.add(adCol );
			if (!list.contains(li))
			{
				list.add(li);
			}
			if (adCol < goldCol)
				adCol++;
			else if (adCol > goldCol)
				adCol--;
			else
				break;
		}
		while (b) {	
			if (adRow < goldRow)
				adRow++;
			else if (adRow > goldRow)
				adRow--;
			else
				break;
			List<Integer> li = new ArrayList<>();
			li.add(adRow );
			li.add(adCol );
			if (!list.containsAll(li))
			{
				list.add(li);
			}
		}
		System.out.println(list);
	}
}
