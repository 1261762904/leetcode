package org.example.hot100.链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author yixin
 * @since 2024/7/26
 */
public class 反转链表 {

    public static void main(String[] args) {
    }

    /**
     * 定义前置prev和当前cur节点 prev=null,cur=head
     * 遍历知道cur等于null跳出循环
     *      暂存当前节点的下个节点
     *      当前节点的next=prev
     *      prev = 当前节点
     *      cur = 暂存的节点
     * 返回prev
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
