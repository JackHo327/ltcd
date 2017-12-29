package Algos;

import java.util.Map;

public class ThreeFiveNine_Logger_Rate_Limiter {
    Map<String, Integer> mp;
    int lastSecond = 0;

    /**
     * Initialize your data structure here.
     */
    public ThreeFiveNine_Logger_Rate_Limiter() {
        mp = new java.util.LinkedHashMap<String, Integer>(100, 0.6f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return lastSecond - eldest.getValue() >= 10;
            }
        };
    }

    public Map<String, Integer> getMp() {
        return mp;
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        lastSecond = timestamp;
        if (!mp.containsKey(message)) {
            mp.put(message, timestamp);
            return true;
        } else {
            if (timestamp - mp.get(message) < 10) {
                return false;
            } else {
                mp.put(message, timestamp);
                return true;
            }
        }
    }
}
