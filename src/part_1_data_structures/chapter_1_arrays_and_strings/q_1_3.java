package part_1_data_structures.chapter_1_arrays_and_strings;

import java.util.Arrays;
import java.util.Scanner;

/*Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer. NOTE: One or two additional variables are fine.
An extra copy of the array is not.
FOLLOW UP
Write the test cases for this method.*/
public class q_1_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(removeDuplicate(s.toCharArray(),s.length()));
	}
	
	// https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
	 static String removeDuplicate(char str[], int n) 
	    { 
	        // Used as index in the modified string 
	        int index = 0; 
	  
	        // Traverse through all characters 
	        for (int i = 0; i < n; i++) 
	        { 
	  
	            // Check if str[i] is present before it  
	            int j; 
	            for (j = 0; j < i; j++)  
	            { 
	                if (str[i] == str[j]) 
	                { 
	                    break; 
	                } 
	            } 
	  
	            // If not present, then add it to 
	            // result. 
	            if (j == i)  
	            { 
	                str[index++] = str[i]; 
	            } 
	        } 
	        return String.valueOf(Arrays.copyOf(str, index)); 
	    } 

	// https://stackoverflow.com/a/29855633/4549285\
	public static char[] removeDupes(char[] arr){
        if (arr == null || arr.length < 2)
            return arr;
        int len = arr.length;
        int tail = 1;
        for(int x = 1; x < len; x++){
            int y;
            for(y = 0; y < tail; y++){
                if (arr[x] == arr[y]) break;
            }
            if (y == tail){
                arr[tail] = arr[x];
                tail++;
            }
        }
        return Arrays.copyOfRange(arr, 0, tail);
    }
	
	public static String removeDuplicates(char[] str) {
		if (str == null)
			return str.toString();
		int len = str.length;
		if (len < 2)
			return str.toString();
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}

			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		char[] a2 = Arrays.copyOfRange(str, 0, tail);
		return a2.toString();
	}

	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {

			hit[i] = false;
		}
		hit[str[0]] = true;

		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
}
