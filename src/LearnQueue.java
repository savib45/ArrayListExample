
import java.util.*;
/**
 *
 * @author savibpandey
 */
public class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>() {};
        queue.offer(10);
        queue.offer(32);
        queue.offer(3);
        
        System.out.println(queue);
        
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
        
    }
}
