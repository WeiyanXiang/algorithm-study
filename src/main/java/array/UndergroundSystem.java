package array;/**
 * @author Weiyan Xiang on 2022/4/24
 */

import java.util.*;

/**
 * https://leetcode.com/problems/design-underground-system/
 * <p>
 * 1396. Design Underground System
 * <p>
 * maps to track necessar info
 */
public class UndergroundSystem {

    Map<Integer, List<Integer>> times;
    Map<Integer, List<String>> stops;
    Map<String, List<Double>> average;

    public UndergroundSystem() {
        this.times = new HashMap<>();
        this.stops = new HashMap<>();
        this.average = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        List<Integer> times = new ArrayList<>();
        times.add(0 - t);
        this.times.put(id, times);
        stops.put(id, new ArrayList<>(Arrays.asList(stationName)));
    }

    public void checkOut(int id, String stationName, int t) {
        List<Integer> curTimes = times.get(id);
        double curTime = (double) curTimes.get(curTimes.size() - 1) + t;
        List<String> curStops = stops.get(id);
        String curTrip = curStops.get(curStops.size() - 1) + "->" + stationName;
        if (average.containsKey(curTrip)) {
            average.get(curTrip).add(curTime);
        } else {
            average.put(curTrip, new ArrayList<>(Arrays.asList(curTime)));
        }
        times.get(id).add(t);
        stops.get(id).add(stationName);

    }

    public double getAverageTime(String startStation, String endStation) {
        return average.get(startStation + "->" + endStation).stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }
}
