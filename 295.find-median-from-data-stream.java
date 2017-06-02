import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream
 *
 * Hard (25.43%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5 
 * 
 * 
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * double findMedian() - Return the median of all elements so far.
 * 
 * 
 * 
 * For example:
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 
 * Credits:Special thanks to @Louis1992 for adding this problem and creating
 * all test cases.
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(num);
        } else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - 1 > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() / 1.0;
        } else {
            return minHeap.peek() / 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
