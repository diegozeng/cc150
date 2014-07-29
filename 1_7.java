/*
 * Write an algorthm such that if an element in an M*N matrix is 0, its entire row and column are set to 0.
 *
 * 思路: 先遍历二维矩阵，把0所在的元素位置设为TRUE(boolean), 再次遍历，元素满足所在行或列有元素为Ture的情况就置0.
 */
class setzero {
	public static void main(String[] args) {
		int [][] image = new int [][] {{1,2,0},{4,5,6},{7,8,9}};
		rotate(image);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println(" ");
	}

	public static void rotate (int[][] ary) {
		boolean[] row = new boolean[ary.length];
		boolean[] col = new boolean[ary[0].length];

		for (int i = 0; i < ary.length;i++) {
			for (int j = 0; j < ary[0].length; j++) {
				if (ary[i][j] == 0)
				{
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for (int i = 0; i < ary.length;i++) {
			for (int j = 0; j < ary[0].length; j++) {
				if (row[i] || col[j])
				{
					ary[i][j] = 0;	
				}
			}
		}
	}
}


