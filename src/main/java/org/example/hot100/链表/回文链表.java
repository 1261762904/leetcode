package org.example.hot100.链表;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 回文：序列是向前和向后读都相同的序列
 * @author yixin
 * @since 2024/7/26
 */
public class 回文链表 {

    public static void main(String[] args) {
    }

    /**
     * 变成数组，左右指正遍历
     */
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int left = 0;
        int right = size-1;
        while(left<right){
            if(!list.get(left++).equals(list.get(right--))){
                return false;
            }
        }
        return true;
    }

    private ListNode frontPointer;

    /**
     * 递归操作
     * 定义frontPointer 为头节点，通过递归一直到末尾，然后判断头结点和末尾节点，然后一次往内靠
     * 缺点：要遍历一个来回，有一般的判断是多余的
     */
    public boolean isPalindrome1(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
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
