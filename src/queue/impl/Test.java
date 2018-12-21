package queue.impl;

import queue.impl.array.DynamicSizeArrayQueue;
import queue.impl.array.FixedSizeArrayQueue;
import queue.impl.node.NodeQueue;

import static java.lang.System.currentTimeMillis;

public class Test {

    public static void main(String[] args)
    {
        System.out.println("Fixed size");
        testQueue(new FixedSizeArrayQueue());
        System.out.println("Dynamic size");
        testQueue(new DynamicSizeArrayQueue(64));
        System.out.println("Node");
        testQueue(new NodeQueue());
    }

    private static void testQueue(Queue queue)
    {
        long startT = currentTimeMillis();

        int numberOfElements = 100000;
        for (int i = 0; i < numberOfElements; i++) {
            queue.add(i);
        }
        long t = currentTimeMillis() - startT;
        System.out.printf("Time to add %d elements is %dms %n", numberOfElements, t);

        ////////////////////////////////////////////////////////////////////
        startT = currentTimeMillis();

        for (int i = numberOfElements; i > 0; i--) {
            queue.delete();
        }
        t = currentTimeMillis() - startT;
        System.out.printf("Time to delete %d elements is %dms %n", numberOfElements, t);
    }
}
