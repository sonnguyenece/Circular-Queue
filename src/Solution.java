public class Solution {
   static void enQueue(Queue queue,int data) {
        Node node = new Node(data);
        if (queue.front == null) {
            queue.front = node;
            queue.rear = queue.front;

        } else {
            queue.rear.link=node;
            node.link=queue.front;
            queue.rear=node ;
        }
    }

   static int deQueue(Queue queue) {
       Node node=new Node();
        if (queue.front == null) {
            return Integer.MIN_VALUE;
        } else {
            node.data=queue.front.data;
            if (queue.rear.equals(queue.front)) {
                queue.front = null;
                queue.rear = null;

            } else {
                queue.front = queue.front.link;
                queue.rear.link = queue.front;
            }
            return node.data;
        }
    }

    static void displayQueue(Queue queue) {
        Node node = queue.front;
        System.out.printf("Elements in Circular Queue are: ");
        while (node.link!=queue.front ) {
            System.out.printf("%d ", node.data);
            node = node.link;
        }
        System.out.printf("%d",node.data);
    }
    public static void main(String args[])
    {
        // Create a queue and initialize front and rear
        Queue  queue = new Queue();
        queue .front = queue .rear =  null;

        // Inserting elements in Circular Queue
        enQueue(queue, 14);
        enQueue(queue, 22);
        enQueue(queue, 6);

        // Display elements present in Circular Queue
        displayQueue(queue);

        // Deleting elements from Circular Queue
        System.out.printf("\n Deleted value = %d", deQueue(queue));
        System.out.printf("\n Deleted value = %d\n", deQueue(queue));

        // Remaining elements in Circular Queue
        displayQueue(queue);
        System.out.println();
        enQueue(queue, 9);
        enQueue(queue, 20);
        displayQueue(queue);

    }
}
