package com.kkzhang.medium;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    // f[i] 表示以 i 结尾的子串最大解码方式
    // f[i] = f[i-2] + f[i-1]; 如果 s[i] + 10*s[i-1] 属于 (10, 20),(20,26]; f[i] 可以和
    // f[i-1] 合并解码或者单独解码
    // f[i] = f[i-1]; 如果 s[i] + 10*s[i-1] 属于 (26,max),(01,10); f[i] 只能单独解码
    // f[i] = f[i-2]; 如果 s[i] + 10*s[i-1] 等于 10/20; f[i] 只能与 f[i-1] 合并解码
    // f[i] = 0; 如果 s[i] + 10*s[i-1] 等于 00; 无法解码
    // 最终通过 245/269；暂时放弃
    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n];
        if (s.startsWith("0")) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        f[0] = 1;
        int curSum = convertInt(s.charAt(0)) * 10 + convertInt(s.charAt(1));
        if ((curSum > 10 && curSum < 20) || (curSum > 20 && curSum <= 26)) {
            f[1] = 2;
        } else if (curSum > 26) {
            f[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            int sum = convertInt(s.charAt(i - 1)) * 10 + convertInt(s.charAt(i));
            if ((sum > 10 && sum < 20) || (sum > 20 && sum <= 26)) {
                f[i] = f[i - 1] + f[i - 2];
            } else if (convertInt(s.charAt(i)) == 0) {
                if (sum == 10 || sum == 20) {
                    f[i] = f[i - 2];
                } else {
                    return 0;
                }
            } else if (sum > 26 || (sum >= 1 && sum < 10)) {
                if (convertInt(s.charAt(i)) == 0) {
                    f[i] = f[i - 2];
                } else {
                    f[i] = f[i - 1];
                }
            } else if (sum == 10 || sum == 20) {
                f[i] = f[i - 2];
            } else {
                return 0;
            }
        }
        return f[n - 1];
    }

    /**
     * 答案
     * @param s
     * @return
     */
    public int numDecodings_1(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')) 
					dp[i]+=dp[i+2];
            }
        return dp[0];   
    }

    private static int convertInt(char c) {
        return c - '0';
    }
}
