/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

 class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    Set<String> visited;
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        dfs(robot, 0, 0, 0);
    }

    public void dfs(Robot robot, int i, int j, int curDir) {
        robot.clean();
        visited.add(i+"-"+j);
        for(int k=0; k<4; ++k){
            int ni = i+dirs[curDir][0];
            int nj = j+dirs[curDir][1];
            if(!visited.contains(ni+"-"+nj)&&robot.move()){
                dfs(robot, ni, nj, curDir);
                backWard(robot);
            }
            curDir = (curDir+1)%4;
            robot.turnRight();
        }
    }

    public void backWard(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}