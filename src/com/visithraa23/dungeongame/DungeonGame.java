package com.visithraa23.dungeongame;

import java.util.ArrayList;
import java.util.Arrays;
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
		int[][] arr = new int[row][column];
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
		System.out.println("Enter the number of pits");
		int pits = sc.nextInt();
		for (int i = 0; i < pits; i++) {
			System.out.println("Enter the Position of pit" + (i + 1));
			int pitRow = sc.nextInt();
			int pitCol = sc.nextInt();
			if (pitRow > row || pitRow <= 0 || pitCol > column || pitCol <= 0)
				System.out.println("Pits are not in the limit");
			else
				arr[pitRow - 1][pitCol - 1] = 1;
		}

		if (row <= 0 || column <= 0)
			System.out.println("dont accept negative values");
		else if (adRow > row || adCol > column || adRow <= 0 || adCol <= 0) {
			System.out.println("Adventure position is limit exceeded");
		} else if (goldRow > row || goldCol > column || goldRow <= 0 || goldCol <= 0) {
			System.out.println("Gold position is limit exceeded");
		} else if (monRow > row || monCol > column || monRow <= 0 || monCol <= 0) {
			System.out.println("monster position is limit exceeded");
		} else if (trigRow > row || trigCol > column || trigRow <= 0 || trigCol <= 0) {
			System.out.println("Trigger position is limit exceeded");
		} else {
//			int adventurePath = Math.abs(adRow - goldRow) + Math.abs(adCol - goldCol);
			int monsterPath = Math.abs(monRow - 1 - goldRow) + Math.abs(monCol - 1 - goldCol);

//			if (monsterPath < adventurePath) {
//				// System.out.println("No Possible solution");
//				int advenToTrigPath = Math.abs(adRow - trigRow) + Math.abs(adCol - trigCol);
//				int monToTrigPath = Math.abs(monRow - trigRow) + Math.abs(monCol - trigCol);
//				int trigTOGoldPath = Math.abs(trigRow - goldRow) + Math.abs(trigCol - goldCol);
//
//				System.out.println("Minimum number of Steps " + (advenToTrigPath + trigTOGoldPath));
//			}
//
//			else {
//				// game.PrintPath(adRow, adCol, goldRow, goldCol);
//				System.out.println("Minimum number of Steps " + adventurePath);
//			}
			game.findMinPath(row - 1, column - 1, adRow - 1, adCol - 1, goldRow - 1, goldCol - 1, arr, monsterPath,
					trigRow - 1, trigCol - 1);
		}
	}

	private void findMinPath(int row, int col, int adRow, int adCol, int goldRow, int goldCol, int[][] arr,
			int monsterPath, int trigRow, int trigCol) {
		if ((adRow + 1 < arr.length && arr[adRow + 1][adCol] == 1) && (adRow - 1 >= 0 && arr[adRow - 1][adCol] == 1)
				&& (adCol + 1 < arr[0].length && arr[adRow][adCol + 1] == 1)
				&& (adCol - 1 >= 0 && arr[adRow][adCol - 1] == 1))
			System.out.println("No Possible Solution");
		else {
			List<List<Integer>> list = new ArrayList<>();
			if (adRow < goldRow)
				leftToRight(arr, adRow, adCol, goldRow, goldCol, list);
			else
				rightToLeft(arr, adRow, adCol, goldRow, goldCol, list);
			if (list.size() < monsterPath)
				System.out.println("Minimum Number of Steps " + (list.size() - 1));
			else {
				List<List<Integer>> list2 = new ArrayList<>();
				if (adRow < trigRow) {
					leftToRight(arr, adRow, adCol, trigRow, trigCol, list2);
					if (trigRow < goldRow)
						leftToRight(arr, trigRow, trigCol, goldRow, goldCol, list2);
					else
						rightToLeft(arr, trigRow, trigCol, goldRow, goldCol, list2);
				} else {
					rightToLeft(arr, adRow, adCol, trigRow, trigCol, list2);
					if (trigRow < goldRow)
						leftToRight(arr, trigRow, trigCol, goldRow, goldCol, list2);
					else
						rightToLeft(arr, trigRow, trigCol, goldRow, goldCol, list2);
				}
				System.out.println("Minimum Number of Steps " + list2.size());
			}
		}

	}

	private void leftToRight(int[][] arr, int startRow, int startCol, int endRow, int endCol,
			List<List<Integer>> list) {
		List<Integer> li;
		while (startCol < arr[0].length) {
			li = new ArrayList<>();
			li.add(startRow + 1);
			li.add(startCol + 1);
			if (!list.contains(li))
				list.add(li);
			if (startCol == endCol)
				break;
			else if (startCol < endCol) {
				if (startCol + 1 < arr[0].length && arr[startRow][startCol + 1] != 1)
					startCol++;
				else if (startRow - 1 >= 0 && arr[startRow - 1][startCol] != 1)
					startRow--;
				else if (startRow + 1 < arr.length && arr[startRow + 1][startCol] != 1)
					startRow++;
				else if (startCol - 1 >= 0 && arr[startRow][startCol - 1] != 1)
					startCol--;
			}

			else {
				if (startCol - 1 >= 0 && arr[startRow][startCol - 1] != 1)
					startCol--;
				else if (startRow - 1 >= 0 && arr[startRow - 1][startCol] != 1)
					startRow--;
				else if (startRow + 1 < arr.length && arr[startRow + 1][startCol] != 1)
					startRow++;
				else if (startCol + 1 < arr[0].length && arr[startRow][startCol + 1] != 1)
					startCol++;
			}
		}
		while (startRow < arr.length) {
			li = new ArrayList<>();
			li.add(startRow + 1);
			li.add(startCol + 1);
			if (!list.contains(li))
				list.add(li);
			if (startRow == endRow)
				break;
			else if (startRow < endRow) {
				if (startRow + 1 < arr.length && arr[startRow + 1][startCol] != 1)
					startRow++;
				else if (startCol + 1 < arr[0].length && arr[startRow][startCol + 1] != 1)
					startCol++;
				else if (startCol - 1 >= 0 && arr[startRow][startCol - 1] != 1)
					startCol--;
				else if (startRow - 1 >= 0 && arr[startRow - 1][startCol] != 0)
					startRow--;
			} else {
				if (startRow - 1 >= 0 && arr[startRow - 1][startCol] != 1)
					startRow--;
				else if (startCol + 1 < arr[0].length && arr[startRow][startCol + 1] != 1)
					startCol++;
				else if (startCol - 1 >= 0 && arr[startRow][startCol - 1] != 1)
					startCol--;
				else if (startRow + 1 < arr.length && arr[startRow + 1][startCol] != 1)
					startRow++;
			}
		}

	}

	private void rightToLeft(int[][] arr, int adRow, int adCol, int goldRow, int goldCol, List<List<Integer>> list) {

		List<Integer> li;
		while (adRow < arr.length) {
			li = new ArrayList<>();
			li.add(adRow + 1);
			li.add(adCol + 1);
			if (!list.contains(li))
				list.add(li);
			if (adRow == goldRow)
				break;
			if (adRow < goldRow) {
				if (adRow + 1 < arr.length && arr[adRow + 1][adCol] != 1)
					adRow++;
				else if (adCol + 1 < arr[0].length && arr[adRow][adCol + 1] != 1)
					adCol++;
				else if (adCol - 1 >= 0 && arr[adRow][adCol - 1] != 1)
					adCol--;
				else if (adRow - 1 >= 0 && arr[adRow - 1][adCol] != 1)
					adRow--;
			}
			if (goldRow < adRow) {
				if (adRow - 1 >= 0 && arr[adRow - 1][adCol] != 1)
					adRow--;
				else if (adCol + 1 < arr[0].length && arr[adRow][adCol + 1] != 1)
					adCol++;
				else if (adCol - 1 >= 0 && arr[adRow][adCol - 1] != 1)
					adCol--;
				else if (adRow + 1 < arr.length && arr[adRow + 1][adCol] != 1)
					adRow++;
			}
		}
		while (adCol < arr[0].length) {
			li = new ArrayList<>();
			li.add(adRow + 1);
			li.add(adCol + 1);
			if (!list.contains(li))
				list.add(li);
			if (adCol == goldCol)
				break;
			if (adCol < goldCol) {
				if (adCol + 1 < arr[0].length && arr[adRow][adCol + 1] != 1)
					adCol++;
				else if (adRow - 1 >= 0 && arr[adRow - 1][adCol] != 1)
					adRow--;
				else if (adRow + 1 < arr.length && arr[adRow + 1][adCol] != 1)
					adRow++;
				else if (adCol - 1 >= 0 && arr[adRow][adCol - 1] != 0)
					adCol--;
			}

			if (goldCol < adCol) {
				if (adCol - 1 >= 0 && arr[adRow][adCol - 1] != 1)
					adCol--;
				else if (adRow - 1 >= 0 && arr[adRow - 1][adCol] != 1)
					adRow--;
				else if (adRow + 1 < arr.length && arr[adRow + 1][adCol] != 1)
					adRow++;
				else if (adCol + 1 < arr[0].length && arr[adRow][adCol + 1] != 1)
					adCol++;
			}
		}

	}

	private void PrintPath(int adRow, int adCol, int goldRow, int goldCol) {

		List<List<Integer>> list = new ArrayList<>();
		Boolean b = true;

		// if(adRow<)
		while (b) {
			List<Integer> li = new ArrayList<>();
			li.add(adRow);
			li.add(adCol);
			if (!list.contains(li)) {
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
			li.add(adRow);
			li.add(adCol);
			if (!list.containsAll(li)) {
				list.add(li);
			}
		}
		System.out.println(list);
	}
}
