package Algos;

import java.util.ArrayDeque;
import java.util.Deque;

public class ThreeFourSix_Moving_Average_from_Data_Stream {


    // a neater version
    private class MovingAverage {

        Deque <Integer> moveAvgDQ;
        int size;
        double tmp;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.moveAvgDQ = new ArrayDeque <> (size);
            this.size = size;
        }

        public double next(int val) {
            // test whether the queue is full.
            // if it is already full, then need to poll the head and add the new data in.
            // also, the tmp need to subtract the element which was just excluded from queue
            if(moveAvgDQ.size()>=this.size){
                tmp-= moveAvgDQ.poll();
                moveAvgDQ.offer(val);
            }else{
                moveAvgDQ.offer(val);
            }
            // update the tmp
            tmp+=val;
            return tmp/moveAvgDQ.size();
        }
    }

    private class MovingAverage_01 {

        Deque<Integer> moveAvgDQ;
        // ArrayDeque <Integer> moveAvgDQ;
        int size;
        double tmp;
        /** Initialize your data structure here. */
        public MovingAverage_01(int size) {
            this.moveAvgDQ = new ArrayDeque<>(size);
            this.size = size;
        }

        public double next(int val) {
            if(moveAvgDQ.isEmpty()){
                moveAvgDQ.offer(val);
                tmp = val;
                return tmp;
            }else{
                if(moveAvgDQ.size() >= this.size){
                    tmp -= moveAvgDQ.poll();
                    moveAvgDQ.offer(val);
                    tmp+=val;
                }else{
                    moveAvgDQ.offer(val);
                    tmp+=val;
                }
                return tmp/moveAvgDQ.size();
            }
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
