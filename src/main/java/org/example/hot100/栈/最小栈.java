package org.example.hot100.栈;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @author yixin
 * @since 2024/8/10
 */
public class 最小栈 {
    class MinStack {
        List<Integer> list = new ArrayList<>();
        int head;
        int min;

        List<Integer> minList = new ArrayList<>();

        public MinStack() {

        }

        public void push(int val) {
            if(head>0){
                min = Math.min(minList.get(head-1),val);
            }else{
                min = val;
            }
            minList.add(head,min);
            list.add(head,val);
            head++;
        }

        public void pop() {
            head-=1;
            minList.remove(head);
            list.remove(head);
        }

        public int top() {
            return list.get(head-1);
        }

        public int getMin() {
            return minList.get(head-1);
        }
    }


    class MinStackNew {
        Node topNode;

        public MinStackNew() {
        }

        public void push(int val) {
            Node node = new Node(val);
            if(topNode==null){
                topNode = node;
                topNode.min=val;
            }else{
                node.min = Math.min(topNode.min, val);
                node.pre = topNode;
                topNode = node;
            }
        }

        public void pop() {
            topNode = topNode.pre;
        }

        public int top() {
            return topNode.val;
        }

        public int getMin() {
            return topNode.min;
        }
    }

    class Node{
        int val;
        int min;
        Node pre;


        public Node(int val){
            this.val = val;
        }

        // public Node(int val)


    }
}
