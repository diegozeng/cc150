/*
 * 1.1 Implement an algorithm to determine if a string has all unique characters
 * What if you cannot use additional data structures?
 *
 * 思路：假设输入是ascii字符，创建一个长度为256的array,遍历输入的字符串，若重复返回false，不重复返回true
 * 特殊情况: null和空字符串都认为是unique的输入，即返回true. 若字符串长度大于256，则返回false.
 * 时间复杂度: O(n)
 * 空间复杂度：O(1)
 * 拓展：1）String的character之间两两比较；2）sort之后。。。
 */
import java.io.*;

class UniqueCharacters {
	public static boolean UniqueCharactersFinder(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		int len = s.length();
		if (len > 256) {
			return false;
		}
		boolean[] ASCII_TABLE = new boolean[256]; //Default values are false
		for(int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (ASCII_TABLE[c]) {
				return false;
			}
			else {
				ASCII_TABLE[c] = true;
			}
		}
		return true;
	}

	public static void main(String[] args)throws Exception {		
		System.out.println("Please type the string:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		if (UniqueCharactersFinder(s)) {
			System.out.println("String with unique characters!");
		}
		else {
			System.out.println("String with repeat characters!");
		}
	}
}
