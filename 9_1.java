/*
 首先令f(n)为上n级楼梯总的方法数
 那么呢，上到n级实际可以有3种选择
 从n-3到n
 从n-2到n
 从n-1到n
 而且到n-1,n-2,n-3具体几种，就可以通过递归的方法做了
 也就是
 f(n) = f(n-1)+f(n-2)+f(n-3)
 */
class Test91 {
    public static int countWays(int n) {
        if(n < 0) {
            return 0;
        }
        else if(n == 0) {
            return 1;
        }
        else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
    }
    
    public static int countWaysDP(int n, int[] map) {
        if(n < 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n - 1,map) + countWaysDP(n - 2,map) + countWaysDP(n - 3,map);
            return map[n];
        }
    }
    
    public static void main(String[] args) {
            int[] map = new int[11];
            System.out.println(countWays(10));
            System.out.println(countWaysDP(10,map));
    }
}