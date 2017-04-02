package Design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Harish Malik on 4/2/17.
 * <p>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * Calling the Next Repeatedly an until hasNext By returns A false, at The Elements returned by
 * the Order of the Next Should BE: [1, 3, 2, 4, 5, 6].
 * <p>
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * <p>
 * Solution:
 * 1. The two lists will be provided to the constructor when an object for the class is initialized.
 * 2. The two lists will be added in a queue to perform ZigZag iteration.
 * 3. For next(), we will first check if the queue is still empty or not. If yes, return -1 else
 * first poll() a list from the queue (This will give us the first list in the queue).
 * 4. Remove the first element from the polled list and then add the list in the (rear of) queue if it still has elements.
 */
public class ZigZagIteratorLC281 {

    Queue<List<Integer>> queue; // This queuw will have the 2 lists
    List<Integer> list;

    public ZigZagIteratorLC281(List<Integer> list1, List<Integer> list2) {

        queue = new ArrayDeque<>();
        queue.add(list1);
        queue.add(list2);
    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            if (i < 11)
                list1.add(i);
            else
                list2.add(i);

        }

        ZigZagIteratorLC281 z = new ZigZagIteratorLC281(list1, list2);
        while (z.hasNext()) {
            System.out.println(z.next());
        }

        System.out.println(z.next());
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public int next() {

        if (queue.isEmpty())
            return -1; //Considering that lists contains non-negative values and we return -1 if there are not elements to return

        list = queue.poll();
        int result = list.remove(0);
        if (list.size() != 0)
            queue.offer(list);

        return result;

    }


}
