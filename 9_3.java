// since sorted and distinct, we can use binary search
class Test93 {
    public static int magicFast(int[] array, int start, int end) {
        int len = array.length;
        if(start > end || start < 0 || end > len - 1)
            return -1;
        int mid = (start + end)/2;
        if(array[mid] == mid) {
            return mid;
        } else if(array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid+1, end);
        }
    }
    
    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length-1);
    }
    
    public static void main(String[] args) {
        int[] test = {6,5,4,3,2,1,0};
        System.out.println(magicFast(test));
    }
}