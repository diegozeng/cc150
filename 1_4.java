/**
 * Created by Readman on 6/16/14.
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
        for (char c : ary) {
            if (c == ' ')
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
