/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
从头开始遍历两个链表，同位置的值相加，记录进位。直到其中一个遍历完成。
继续将未遍历完的链表加到结果中，记录进位。
若遍历完成后进位仍然为1，连接节点。
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(-1);
      ListNode p = head;
      int remain = 0;
      while (l1 != null && l2 != null) {
        int val = (l1.val + l2.val + remain) % 10;
        remain = (l1.val + l2.val + remain) / 10;
				p.next = new ListNode(val);
        p = p.next;
        l1 = l1.next;
        l2 = l2.next;
			}
      while (l1 != null) {
        int val = (l1.val + remain) % 10;
        remain = (l1.val + + remain) / 10;
        p.next = new ListNode(val);
        p = p.next;
        l1 = l1.next;
			}
      while (l2 != null) {
        int val = (l2.val + remain) % 10;
        remain = (l2.val + + remain) / 10;
        p.next = new ListNode(val);
        p = p.next;
        l2 = l2.next;
			}
      if (remain == 1) {
        p.next = new ListNode(1);
      }
      return head.next;
    }
}
