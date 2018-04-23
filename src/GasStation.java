/**
 * https://leetcode.com/problems/gas-station/description/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Note:
 * The solution is guaranteed to be unique.
 * Created by deng on 2018/4/9.
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 2, 6};
        int[] cost = {2, 1, 2, 5, 3};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        return 0;
    }
}
