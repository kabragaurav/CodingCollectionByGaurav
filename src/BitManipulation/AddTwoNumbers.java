/**
 * Given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit (0-9).
 * The two numbers do not contain any leading zero, except the number 0 itself.
 * Add the two numbers and since the result overall can exceed integer bounds, return the sum as a linked list.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since 12 Sept 2021
 **/

public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Logic:
         * The maximum numbers we will be adding once are : 9 and 9.
         * That sums to 18. So 1 will be carried to next digits addition,
         * which can again be 9 and 9.
         * Hence at any time, any sum value can, at maximum, give us 9 + 9 + 1 (as carry) = 19.
         */
        ListNode l = new ListNode(), temp = l, prev = null;
        int d1, d2, sum, carry = 0;
        while(l1 != null && l2 != null) {
            d1 = l1.val;
            d2 = l2.val;
            sum = d1 + d2 + carry;
            if(sum > 9) {
                carry = 1;
                l.val = sum-10;
            } else {
                carry = 0;
                l.val = sum;
            }
            l.next = new ListNode();
            prev = l;
            l = l.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            d1 = l1.val;
            sum = d1 + carry;
            if(sum > 9) {
                carry = 1;
                l.val = sum-10;
            } else {
                carry = 0;
                l.val = sum;
            }
            l.next = new ListNode();
            prev = l;
            l = l.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            d2 = l2.val;
            sum = d2 + carry;
            if(sum > 9) {
                carry = 1;
                l.val = sum-10;
            } else {
                carry = 0;
                l.val = sum;
            }
            l.next = new ListNode();
            prev = l;
            l = l.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            l.val = carry;
        } else {
            prev.next = null;
        }

        return temp;
    }

    public static void main(String[] args) {
      // TESTCASE
        ListNode ln11 = new ListNode(9);
        ListNode ln12 = new ListNode(9);
        ln11.next = ln12;
        ListNode ln21 = new ListNode(9);

        ListNode ans = addTwoNumbers(ln11, ln21);
        while(ans.next != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.print(ans.val + " ");
    }
}
