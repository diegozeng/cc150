/*
 * Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * 思路: 对应关系: i = length - j -1 
 */

class rotate {
	public static void main(String[] args) {
		int[][] image = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("Original Matrix:");
	        for(int i = 0; i<image.length; i++) {
			for(int j = 0; j<image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}	
			System.out.println("");
		}
		rot(image);
		System.out.println("Clockwise-rotated Matrix:");
		for(int i = 0; i<image.length; i++) {
			for(int j = 0; j<image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void rot(int[][] img) {
		if (img == null) {
			return;
		}
		for (int i = 0; i < img.length/2; i++) {
			for (int j = i; j < img.length-i-1; j++) {
				int t = img[i][j];
				img[i][j] = img[img.length-j-1][i];
				img[img.length-j-1][i] = img[img.length-i-1][img.length-j-1];
				img[img.length-i-1][img.length-j-1] = img[j][img.length-i-1];
				img[j][img.length-i-1] = t;
			}
		}
	}	
}
