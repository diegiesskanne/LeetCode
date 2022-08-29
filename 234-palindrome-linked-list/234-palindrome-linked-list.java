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
class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode res;

        res = help(head, null);
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int[] iHead = toIntArra(head, a).stream().mapToInt(i -> i).toArray();
        int[] iRes = toIntArra(res, b).stream().mapToInt(i -> i).toArray();

        return Arrays.equals(iHead, iRes);
    }

    public ListNode help (ListNode head, ListNode res){
        if(head == null){
            return res;
        }else {
            res = new ListNode(head.val, res);
            return help(head.next, res);
        }
    }

    public ArrayList<Integer> toIntArra(ListNode head, ArrayList<Integer> res) {
        if(head == null) {
            return res;
        }else{
            res.add(head.val);
            return toIntArra(head.next, res);
        }
    }
}