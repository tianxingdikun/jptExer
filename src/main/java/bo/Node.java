package bo;

import lombok.Data;

@Data
public class Node {

    private int val;
    private Node next;
    private Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
