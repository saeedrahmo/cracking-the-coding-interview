package part_1_data_structures.chapter_1_arrays_and_strings;

import java.util.Scanner;

/*Write code to reverse a C-Style String. (C-String means that â€œabcdâ€? is represented as
five characters, including the null character.)*/
public class q_1_2 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(reverseString(sc.next()));
			sc.nextLine();
		}
	}

	public static String reverseString(String s) {
		StringBuffer s2 = new StringBuffer();
		for (int i = s.length(); i == 0; i--) {
			// s2.append(String.valueOf(i));
			s2.append(s.charAt(i));
		}
		System.out.println(s2.toString());
		return s2.toString();
	}
}
