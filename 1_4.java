/* 
 * 1.4 Write a method to replace all spaces in string with "%20". You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "ture" length of string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * 思路:先遍历字符串，数出空格的个数，新字符串的长度＝原字符串的长度＋2*空格的个数，迭代赋值运算：1.遇到字符，copy老字符串的字符到新字符串. 2遇到空格，多插入两个空格，分别放入“％”，“2”，“0”.｀：
 */
class replaceSpace {
    /*
     time: n
     space n
     * */
    public static void main(String[] args) {
        String s = "Mr John Smith  ";
        System.out.println(replaceSpace(s.toCharArray()));
    }
    public static String replaceSpace (char[] ary) {
        int count = 0;
        for (char blank : ary) {
            if (blank == ' ')
                count ++;
        }
        return rec(ary,new char[count*2 + ary.length], 0, 0);
    }
    public static String rec (char[] old, char [] ary, int ary_pos, int old_pos) {
        if (ary_pos >= ary.length || old_pos >= old.length) {
            return String.valueOf(ary);
        }
        if(old[old_pos] == ' ') {
            ary_pos = ary_pos + 2;
            ary[ary_pos] = '0';
            ary[ary_pos-1] = '2';
            ary[ary_pos-2] = '%';
        }
        else{
            ary[ary_pos] = old[old_pos];
        }
        return rec (old, ary,++ary_pos,++old_pos);
    }
}
