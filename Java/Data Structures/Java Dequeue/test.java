import java.util.*;

/**
 * you are given N integers.
 * task: find out the maximum number of unique integers
 * among all the possible contiguous subarrays of size M
 * sample INPUT:
 *      6 3
 *      5 3 5 2 3 2
 *      (subbarays -> s1 = (535) -> 2 unique numbers,
 *                    s2 = (352) -> 3 unique numbers,
 *                    s3 = (523) -> 3 unique numbers,
 *                    s4 = (232) -> 2 unique numbers,
 *                    => the maximum amount of unique numbers among all possible contiguous subarrays is 3
 * sample OUTPUT:
 *      3
 */

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int n = in.nextInt();               //nr of integers
        int m = in.nextInt();               //the size of a subarray
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            set.add(num);

            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }

                int first = deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
         System.out.println(max);
    }
}
