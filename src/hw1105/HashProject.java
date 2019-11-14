/**
 * Philip Cothery
 * COSC311 FA19
 * HW1105 Hash Project
 * 
 */

package hw1105;

import java.util.Random;

public class HashProject {
	private int[] hash;
	private int[] primeTable;

	public HashProject() {
		hash = new int[11];
		primeTable = new int[] { 1, 2, 3, 5, 7, 9};
		for (int i = 0; i < hash.length; i++) {
			hash[i] = -2;
		}
	}

	public void add(int num) {
		int hashVal = num % 11;
		for (int i = primeTable.length - 1; i >= 0; i--) {
			switch (hash[hashVal]) {
			case (-2)://signifies empty
			case (-1)://signifies tombstone
				hash[hashVal] = num;
				System.out.println("Value: " + num + "     Index: " + hashVal);
				break;
			default:
				hashVal = primeTable[i]-(num % primeTable[i]);
				continue;
			}
			break;
		}
	}
	public void print() {
		System.out.println("-----------");
		System.out.println("|----|----|");
		for(int i = 0; i < hash.length;i++) {
			System.out.printf("| %2d", i);
			if(hash[i] != -2) {
			System.out.printf(" | %2d", hash[i]);
			}else {
				System.out.print(" |   ");
			}
			System.out.println(" |");
			System.out.println("|----|----|");
		}
		System.out.println("-----------");
	}

	public static void main(String[] args) {
		Random ran = new Random(97);
		HashProject hp = new HashProject();
		for(int i = 0; i<8; i++) {
			hp.add(ran.nextInt(99));
		}
		hp.print();
	}
}
