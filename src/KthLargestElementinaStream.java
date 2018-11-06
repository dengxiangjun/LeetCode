import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an
 * integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add,
 * return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 * @author dengxiangjun@jd.com
 * @date 2018/11/6 15:27
 **/
public class KthLargestElementinaStream {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargestElementinaStream(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int item : nums) {
            add(item);
        }
    }


    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
    //private int[] heap;
//    public KthLargestElementinaStream(int k, int[] nums) {
//        this.heap = Arrays.copyOfRange(nums, 0, k);
//        bulidMinHeap(heap);
//        for (int i = k; i < nums.length; i++) {
//            if (heap[0] < nums[i]) {
//                heap[0] = nums[i];
//                minHeapFixDown(heap, 0, k);
//            }
//        }
//    }
//
//    private static void bulidMinHeap(int[] arr) {
//        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
//            minHeapFixDown(arr, i, arr.length);
//        }
//    }
//
//    private static void minHeapFixDown(int[] arr, int i, int n) {
//        int temp = arr[i];
//        int j = 2 * i + 1;
//        while (j < n) {
//            if (j + 1 < n && arr[j] > arr[j + 1]) j++;
//            if (arr[j] >= temp) break;
//            arr[i] = arr[j];
//            i = j;
//            j = 2 * i + 1;
//        }
//        arr[i] = temp;
//    }
//
//    public int add(int val) {
//        if (heap[0] < val) {
//            heap[0] = val;
//            minHeapFixDown(heap, 0, heap.length);
//        }
//        return heap[0];
//    }


    public static void main(String[] args) {
        int[] arr = {};
        KthLargestElementinaStream kthLargest = new KthLargestElementinaStream(1, arr);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }
}
