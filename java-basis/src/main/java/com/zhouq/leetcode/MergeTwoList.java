package com.zhouq.leetcode;

/**
 * leetcode 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(4);

        ListNode mergeTwoLists = mergeTwoLists2(l1, list2);

        System.out.println(mergeTwoLists);

    }

    /**
     * 递归方式
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 == null) return list2;
       if (list2 == null) return list1;

       //定义一个头节点
       ListNode mergeHead = null;

       if (list1.val < list2.val){
           mergeHead = list1;
           mergeHead.next = mergeTwoLists(list1.next,list2);
       }else{
           mergeHead = list2;
           mergeHead.next = mergeTwoLists(list2.next,list1);
       }

       return mergeHead;
    }

    /**
     * 非递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 定义一个虚拟的头节点
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null){
            cur.next = l2;
        }

        if (l2 == null){
            cur.next = l1;
        }

        return dummyHead.next;
    }


}
