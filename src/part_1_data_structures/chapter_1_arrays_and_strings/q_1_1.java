package part_1_data_structures.chapter_1_arrays_and_strings;

import java.util.Scanner;

/*Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?*/
public class q_1_1 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(isUniqueChars2(sc.next()));
		}
	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {

			int val = str.charAt(i);
			char val2 = str.charAt(i);			
			System.out.println(val2);
			if (char_set[val])
				return false;

			char_set[val] = true;
		}
		return true;
	}
}
