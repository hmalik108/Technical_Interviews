package Design;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Harish Malik on 4/2/17.
 * <p>
 * This is the solution to the follow up question - LC281 ZigZagIterator
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
public class ZigZagIteratorLC281_II {

    List<Integer>[] lists; // This array will have all the lists provided to the constructor
    int listNumber; // This will keep the listNumber or list index in lists array for the current list to print value from.
    int[] indices; // This array will keep the current index of element in each list to be returned when next() is called
    int count; // This will keep the count of elements already returned by the next() method.
    int length; // This will have the total number of elements in k lists.


    public ZigZagIteratorLC281_II(List<Integer>... lists) {

        this.lists = lists;
        indices = new int[lists.length];
        listNumber = 0;

        for (List l : lists) {
            length += l.size();
        }
    }

    public static void main(String[] args) {

        ZigZagIteratorLC281_II z = new ZigZagIteratorLC281_II(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8));
        while (z.hasNext()) {
            System.out.println(z.next());
        }
        System.out.println(z.next());
    }

    /**
     * 1. We get the list from the lists array with listNumber as the index.
     * 2. Now that we have the right list, we find the current index in that list from indices array.
     * 3. We update listNumber, count and indices.
     * 4. We update listNumber as such so that it doesn't points to a list whose all the elements has been accessed.
     * For this we implement a while loop which checks if the listNumber is at the right list.
     *
     * @return next element in ZigZag iteration.
     */
    public int next() {

        if (count >= length)
            return -1;

        int result = lists[listNumber].get(indices[listNumber]);
        indices[listNumber]++;
        listNumber++;
        listNumber = listNumber % lists.length;
        count++;
        while (count < length && (indices[listNumber] >= lists[listNumber].size())) {
            listNumber++;
            listNumber = listNumber % lists.length;
        }
        return result;
    }

    /**
     * @return true if iterator hasNext value else false
     */
    public boolean hasNext() {
        return count < length;
    }


}
