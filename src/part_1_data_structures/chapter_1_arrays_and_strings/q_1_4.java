package part_1_data_structures.chapter_1_arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Write a method to decide if two strings are anagrams or not.*/
public class q_1_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.next();
		String s2 = scanner.next();
		System.out.println(isAnagram2(s1, s2));
	}

	/*
	 * If you sort either array, the solution becomes O(n log n). but if you use a
	 * hashmap, it's O(n). tested and working.
	 */
	public static boolean isAnagram2(String firstWord, String secondWord) {
		char[] word1 = firstWord.toCharArray();
		char[] word2 = secondWord.toCharArray();

		Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();

		for (char c : word1) {
			int count = 1;
			if (lettersInWord1.containsKey(c)) {
				count = lettersInWord1.get(c) + 1;
			}
			lettersInWord1.put(c, count);
		}

		for (char c : word2) {
			int count = -1;
			if (lettersInWord1.containsKey(c)) {
				count = lettersInWord1.get(c) - 1;
			}
			lettersInWord1.put(c, count);
		}

		for (char c : lettersInWord1.keySet()) {
			if (lettersInWord1.get(c) != 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean isAnagram(String firstWord, String secondWord) {
		char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	// Check if the two strings have identical counts for each unique char.
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

}
