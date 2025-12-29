// public class test {
//     public static void main(String[] args) {
//         int a[] = { 10, 30, 100, 585};
//         int b[] = { 50, 50, 100, 520};
//         int s1 = 0;
//         int s2 = 0;
//         for (int i = 0; i < a.length; i++) {
//             s1 += a[i];
//             s2 += b[i];
//         }
//         if (s1 >= s2) {
//             System.out.println(0);
//             return;
//         }
//         int r = s2 - s1;
//         System.out.println(r);
//         int p = 0;
//         p = r / 100 + 1;
//         System.out.println(p);
//     }
// }
class test{
    static int solve(int r,int target,Integer dp[][])
    {
        if(target==0)
        {
            return 1;

        }
        if(target<0||r<=0)
        {
            return 0;
        }
        if(dp[target][r]!=null)
        {
            return dp[target][r];
        }
        int inc=solve(r,target-r,dp);
        int exc=solve(r-1,target,dp);
        return dp[target][r]=inc+exc;
    }
    public static int cur(int r,int n) {
        //code here
        Integer dp[][]=new Integer[n+1][r+1];
        return solve(r,n,dp);
    }
    public static void main(String[] args) {
        System.out.println(cur(2,2));

    }
}
