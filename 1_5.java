/*
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string.
 *
 * 思路：先将字符串拷贝，然后字符串数组，逐项比较，遇到重复字符count++，直到不重复的时候将count变回1。分别append字符和count到新数组copy.最终比较原数组和copy的长度，输出较短的。
 * Test case: "aaab"->"aaab", "aaaab"->"a4b1", "呵呵呵呵啊"->"呵4啊1", "aaaabbbbaaa"->"a4b4a3", "a    bb   aaa"->"a1 4b2 3a3"
 */
class Test {
	public static void main(String[] args) {
		String teststr = "a    bb   aaa";
       		char[] clip = teststr.toCharArray(); 
        	StringBuffer copy = new StringBuffer();
       		char lastchar = teststr.charAt(0);
        	int count = 0;
        	for(char c : clip) {
            		if(lastchar == c) {
                		count ++;
            		}
            	else {
                    copy.append(lastchar);
                	copy.append(count);
                	lastchar = c;
                	count = 1;
            		}		
        	}
       		copy.append(lastchar);
        	copy.append(count);
		if(teststr.length() > copy.length())
            		System.out.println(copy);
        	else 
            		System.out.println(teststr);        
//		System.out.println(teststr.length());
//		System.out.println(copy.length());
    	}
}
