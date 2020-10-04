package part_1_data_structures.chapter_1_arrays_and_strings;

public class q_1_5 {
	// Write a method to replace all spaces in a string with ‘%20’.
	public static void main(String[] args) {

	}

	// https://stackoverflow.com/a/49969373/4549285
	public static String urlencode(String str) {
		str = str.trim();
		System.out.println("trim =>" + str);

		if (!str.contains(" ")) {
			return str;
		}

		char[] ca = str.toCharArray();

		int spaces = 0;
		for (char c : ca) {
			if (c == ' ') {
				spaces++;
			}
		}

		char[] newca = new char[ca.length + 2 * spaces];
		// a pointer x has been added
		for (int i = 0, x = 0; i < ca.length; i++) {
			char c = ca[i];
			if (c == ' ') {
				newca[x] = '%';
				newca[x + 1] = '2';
				newca[x + 2] = '0';
				x += 3;
			} else {
				newca[x] = c;
				x++;
			}
		}
		return new String(newca);
	}

	// https://stackoverflow.com/a/46809547/4549285
	public static String replace2(String s) {

		char arr[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 32)
				sb.append("%20");
			else
				sb.append(arr[i]);

		}

		return sb.toString();
	}

	// https://stackoverflow.com/a/32914185/4549285
	public static String replace(String str) {
		String[] words = str.split(" ");
		StringBuilder sentence = new StringBuilder(words[0]);

		for (int i = 1; i < words.length; ++i) {
			sentence.append("%20");
			sentence.append(words[i]);
		}

		return sentence.toString();
	}

	// https://stackoverflow.com/a/24241167/4549285
	public static char[] replaceSpaceInString(char[] str, int length) {
		int spaceCounter = 0;

		// First lets calculate number of spaces
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaceCounter++;
		}

		// calculate new size
		int newLength = length + 2 * spaceCounter;

		char[] newArray = new char[newLength + 1];
		newArray[newLength] = '\0';

		int newArrayPosition = 0;

		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				newArray[newArrayPosition] = '%';
				newArray[newArrayPosition + 1] = '2';
				newArray[newArrayPosition + 2] = '0';
				newArrayPosition = newArrayPosition + 3;
			} else {
				newArray[newArrayPosition] = str[i];
				newArrayPosition++;
			}
		}
		return newArray;
	}

	// Change space count to 2 [since length already includes 1 of the 3 characters
	// you need for %20]
	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		// First lets calculate number of spaces
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		// calculate new size
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
}
