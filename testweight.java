public void testweightbagproblem(int[] weight, int[] value, int bagSize) {
        int m = weight.length, n = bagSize;
        //1.确认dp数组以及下标的含义 dp[i][j]表示从下标为[0-i]的物品里任取，放入容量为j的背包里，价值总和最大
        int[][] dp = new int[m][n + 1];
        //3.对dp数组第一列初始化，背包容量为0时，能获得的价值为0
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        //3.对dp数组第一行初始化，weight[0]>j时为值为0，否则值为value[0]
        for (int j = weight[0]; j <= n; j++) {
            dp[0][j] = value[0];
        }
        //4.确认遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        //5.打印dp数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
