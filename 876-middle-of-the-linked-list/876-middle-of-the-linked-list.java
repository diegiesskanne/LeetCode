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
    public ListNode middleNode(ListNode head) {
        ArrayList<Integer> a = new ArrayList<>();
        ListNode res = null;
        int[] i1 = toIntArray(head, a).stream().mapToInt(i -> i).toArray();
        int len = i1.length;
        for(int i = 0; i < len; i++){
            if (i >= len/2){
                res = new ListNode(i1[i], res);
            }
        }
        return reverse(res, null);
    }

    public ListNode reverse (ListNode head, ListNode res){
        if(head == null){
            return res;
        }else {
            res = new ListNode(head.val, res);
            return reverse(head.next, res);
        }
    }


    public ArrayList<Integer> toIntArray(ListNode head, ArrayList<Integer> res) {
        if(head == null) {
            return res;
        }else{
            res.add(head.val);
            return toIntArray(head.next, res);
        }
    }
}