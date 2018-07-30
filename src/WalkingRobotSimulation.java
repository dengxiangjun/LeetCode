import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/contest/weekly-contest-94/problems/walking-robot-simulation/
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square
 * instead (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] a : obstacles) {
            set.add(a[0] + "," + a[1]);
        }

        int res = 0, direction = 0, x = 0, y = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) {//right顺时针
                direction = (direction + 1) % 4;
            } else if (command == -2) {//left逆时针
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int x1 = x + directions[direction][0];
                    int y1 = y + directions[direction][1];
                    if (set.contains(x1 + "," + y1)) break;
                    x += directions[direction][0];
                    y += directions[direction][1];
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }

}
