public class UniquePathsII {
    public int calculateUniquePaths(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) { // changes the first column
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < C; i++) { // changes the first row
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }

    public void printArray(int[][] obstacleGrid) {
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public int secondTry(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;// row count
        int n = obstacleGrid[0].length;// column count
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) { // changes first column
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public int testing(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) {
                obstacleGrid[i][0] = 1;
            } else obstacleGrid[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) obstacleGrid[0][i] = 1;
            else obstacleGrid[0][i] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else obstacleGrid[i][j] = 0;
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr;
        arr = new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 1, 0}};
        System.out.println();
        System.out.println("expecting 0; getting: " + arr[0][1]);
        System.out.println("expecting 1; getting: " + arr[2][1]);
        for (int i : arr[2]) System.out.printf("%d", i);
        System.out.println();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println("Test 1 - Result of uniquePaths(), Expecting 2, Getting : " + uniquePathsII.calculateUniquePaths(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Test 1 - Result of 2nd Try, Expecting 2, Getting : " + uniquePathsII.secondTry(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Test 1 - Result of testing(), Expecting 2, Getting : " + uniquePathsII.testing(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0}, {0, 1}};
        System.out.println(uniquePathsII.calculateUniquePaths(obstacleGrid));
        System.out.println("Test 2 - Result of uniquePaths(), Expecting 0, Getting : " + uniquePathsII.calculateUniquePaths(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0}, {0, 1}};
        System.out.println("Test 2 - Result of 2nd Try, Expecting 0, Getting : " + uniquePathsII.secondTry(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0}, {0, 1}};
        System.out.println("Test 3 - Result of testing(), Expecting 0, Getting : " + uniquePathsII.testing(obstacleGrid));
        obstacleGrid = new int[][]{{0}, {1}};
        System.out.println(uniquePathsII.calculateUniquePaths(obstacleGrid));
        System.out.println("Test 3 - Result of uniquePaths(), Expecting 0, Getting : " + uniquePathsII.calculateUniquePaths(obstacleGrid));
        obstacleGrid = new int[][]{{0}, {1}};
        System.out.println("Test 3 - Result of 2nd Try, Expecting 0 Getting : " + uniquePathsII.secondTry(obstacleGrid));
        obstacleGrid = new int[][]{{0}, {1}};
        System.out.println("Test 3 - Result of testing(), Expecting 0 Getting : " + uniquePathsII.testing(obstacleGrid));
        int[][] foo = new int[3][4];
        // create a two-dimensional array of 3 rows and 4 columns
        // and assign 1 to all the items in the first row
        for (int i = 0; i < foo[0].length; i++) {
            foo[0][i] = 1;
        }
        System.out.println();
        // now assign 1 to all the items in the first column
        for (int i = 0; i < foo.length; i++) {
            foo[i][0] = 1;
        }
        uniquePathsII.printArray(foo);
        System.out.println();
    }
}
