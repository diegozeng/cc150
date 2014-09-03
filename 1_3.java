/*
 * 1.3 Given two Stirngs, write a method to decide if one is a permutation of the other.
 *
 * 思路：类似1.1的思路，建一个int数组，根据index记录字符出现次数。
 *
 * 时间复杂度: O(n)[若采用排序逐次比较，则为nlogn]
 * 空间复杂度: O(1)[确定了自符类型，比如unicode, 256为常量]
 */ 

import java.io.*;
import java.util.*;

class PermutationStr {
	public static void main(String[] args) {
		String str1 = "1a2b3c";
		String str2 = "b2c3a1";
		if(permutation(str1,str2)) {
			System.out.println("True!");
		}
		else {
			System.out.println("False!");
		}
	}

	public static boolean permutation(String str1, String str2) {
		int[] ascii_table = new int[256];
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2)
			return false;
		boolean status = true;
		for (int i = 0; i < len1; i++) {
			ascii_table[str1.charAt(i)] ++;
		}
		for (int i = 0; i < len2; i++) {
			ascii_table[str2.charAt(i)] --;
		}
		for (int i = 0; i < 256; i++) {
			if(ascii_table[i] != 0) {
				status = false;
			}
		}
		return status;
	}
}

						
