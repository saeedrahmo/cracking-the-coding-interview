package part_1_data_structures.chapter_1_arrays_and_strings;

public class q_1_6 {
	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is
	 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	 * place?
	 */
	public static void main(String[] args) {
		int[][] mtx = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(mtx[0][0]);
		System.out.println(mtx[2][0]);
	}

	// https://stackoverflow.com/a/25882585/4549285
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {

			int first = layer;

			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {

				int offset = i - first;

				int top = matrix[first][i]; // save top

				// left -> top

				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
}
