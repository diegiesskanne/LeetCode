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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode rev1;
        ListNode rev2;

        rev1 = reverse(l1, null);
        System.out.println(rev1);
        rev2 = reverse(l2, null);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int[] i1 = toIntArray(rev1, a).stream().mapToInt(i -> i).toArray();
        int[] i2 = toIntArray(rev2, b).stream().mapToInt(i -> i).toArray();

        int diff = i1.length - i2.length;
        ListNode rev3 = null;
        ListNode rev4 = null;
        if(diff < 0) {
            rev3 = addZeros(rev1, Math.abs(diff), null);
        } else if (diff > 0) {
            rev4 = addZeros(rev2, diff, null);
        }
        ListNode res;
        if(rev3 == null && rev4 != null) {
            res = help(l1, rev4, null, 0);
        }else if(rev4 == null && rev3 != null){
            res = help(rev3, l2, null, 0);
        }else{
            res = help(l1, l2, null, 0);
        }

        return reverse(res, null);
    }

    public ListNode addZeros(ListNode node, int diff, ListNode res) {
        if(node == null && diff == 0){
            return res;
        }else {
            if (diff != 0) {
                res = new ListNode(0, res);
                return addZeros(node, diff -1, res);
            }else{
                res = new ListNode(node.val, res);
                return addZeros(node.next, diff, res);
            }

        }
    }

    public ListNode help(ListNode l1, ListNode l2, ListNode res, int overcap){
        if(Objects.equals(l1, null) && Objects.equals(l2, null) && overcap != 0){
            return new ListNode(1, res);
        }
        else if(Objects.equals(l1, null) && Objects.equals(l2, null)){
            return res;
        }else{
            int sum = l1.val + l2.val + overcap;
            if(sum >= 10) {
                overcap = 1;
            } else {
                overcap = 0;
            }
            res = new ListNode(sum%10, res);
            return help(l1.next, l2.next, res, overcap);
        }
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