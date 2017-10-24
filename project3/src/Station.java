/**
 * Created by Eric Wolfe on 10/24/17.
 */

import java.util.LinkedList;
import java.util.Queue;

public interface Station {
    Queue<Float> queue = new LinkedList();
    void service();
    void addCall(float newTime);
}
