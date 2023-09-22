import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] newArray = {1, 3, 4, 5, 5, 6, 2, 7};

        System.out.println(notContains(newArray));

        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.println("tavidan listi:");
        list.printList();
        Node nodeToDelete = list.head.next;
        list.delete(nodeToDelete);

        System.out.println("element amoshlili listi:");
        list.printList();

    }

    public static int countVariants(int stearsCount){

        int[] variants = new int[stearsCount + 1];
        variants[0] = 1;
        variants[1] = 1;
        for (int i = 2; i <= stearsCount; i++) {
            variants[i] = variants[i - 1] + variants[i - 2];
        }
        return variants[stearsCount];
//        shevamchnie ro fibonachi sequence aris
    }

    public static String binary(String a, String b){

        int one = Integer.parseInt(a, 2);
        int two = Integer.parseInt(b, 2);

        int sum = one + two;

        return Integer.toBinaryString(sum);
    }

    public static int notContains(int[] array){

        Arrays.sort(array);

        for(int a = 0; a < array.length - 1; a++){
            if(array[a] + 1 < array[a + 1]){// 1 2 3 4 4  7
                return array[a] + 1;
            }
        }

        return array[array.length - 1] + 1;
    }

    public static int minSplit(int amount){

        int[] coins = {50, 20, 10, 5, 1};
        int count = 0;

        for(int a = 0; a < coins.length; a++){
            while(amount - coins[a] >= 0){
                amount -= coins[a];
                count++;
            }
        }

        return count;
    }

    public static int singleNumber(int[] nums){

        for(int a = 0; a < nums.length; a++){
            int check = 0;
            for(int b = a; b < nums.length; b++){
                if(a != b && nums[a] == nums[b]) {
                    check++;
                }
            }
            if (check == 0){
                return nums[a];
            }
        }

        return 0;
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // wasashleli methodi O(1) droshi
    public void delete(Node nodeToDelete) {
        if (nodeToDelete == null || head == null) {
            return;
        }

        if (nodeToDelete == head) {
            head = head.next;
        } else {
            nodeToDelete.prev.next = nodeToDelete.next;
        }

        if (nodeToDelete == tail) {
            tail = tail.prev;
        } else {
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
