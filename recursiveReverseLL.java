import java.util.Scanner;

public class recursiveReverseLL {
  static class Node {
      int val;
      Node next;

      Node(int val) {
          this.val = val;
      }
  }

  static Node recursiveReverseLinkedList(Node head) {
    if (head == null || head.next == null)
        return head;
    Node revNode = recursiveReverseLinkedList(head.next);
    head.next.next = head;
    head.next = null;
    return revNode;
  }

  static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.val + " ");
        temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];

    Node head = null;

    for (int i = 0; i < n; i++) {
      int value = sc.nextInt();
      Node newNode = new Node(value);
      if (head == null)
        head = newNode;
      else {
        Node curr = head;
        while (curr.next != null)
          curr = curr.next;
        curr.next = newNode;
      }
    }

    System.out.println("Original LL:");
    printLL(head);
    
    head = recursiveReverseLinkedList(head);

    System.out.println("Reversed LL:");
    printLL(head);
  }
}
