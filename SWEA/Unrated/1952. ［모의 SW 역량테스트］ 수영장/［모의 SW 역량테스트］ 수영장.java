import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dp = new int[12];

    static int costOf1day;
    static int costOf1Month;
    static int costOf3Month;
    static int costOfYear;

    static int[] plan = new int[12];
    public static void main(String args[]) throws IOException {

        int T = Integer.parseInt(br.readLine());


        for(int t = 1; t <= T; t++){

            st = new StringTokenizer(br.readLine());
            int costOf1Day = Integer.parseInt(st.nextToken());
            int costOf1Month = Integer.parseInt(st.nextToken());
            int costOf3Month = Integer.parseInt(st.nextToken());
            int costOfYear = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 12; i++)
                plan[i] = Integer.parseInt(st.nextToken());



            dp[0] = Math.min(costOf1Day*plan[0] , costOf1Month);
            dp[0] = Math.min(dp[0] , costOf1Month);
            dp[0] = Math.min(dp[0] , costOf3Month);
            dp[0] = Math.min(dp[0] , costOfYear);

            dp[1] = dp[0] + costOf1Day * plan[1];
            dp[1] = Math.min(dp[1] , dp[0] + costOf1Month);
            dp[1] = Math.min(dp[1] , costOf3Month);
            dp[1] = Math.min(dp[1] , costOfYear);

            dp[2] = dp[1] + costOf1Day * plan[2];
            dp[2] = Math.min(dp[2] , dp[1] + costOf1Month);
            dp[2] = Math.min(dp[2] , costOf3Month);
            dp[2] = Math.min(dp[2] , costOfYear);

            for(int i = 3; i< 12; i++){
                dp[i] = dp[i-1] + costOf1Day * plan[i];
                dp[i] = Math.min(dp[i], dp[i-1] + costOf1Month);
                dp[i] = Math.min(dp[i], dp[i-3] + costOf3Month);
                dp[i] = Math.min(dp[i], costOfYear);


            }

            System.out.println("#" + t + " " + dp[11]);
        }
    }





}
