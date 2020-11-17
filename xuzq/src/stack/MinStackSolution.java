package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/877/
 */
public class MinStackSolution {
    class MinStack {

        List<Integer> stack;
        List<Integer> minStack;
//        int min;
//        boolean flag;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayList<Integer>();
//            min = Integer.MAX_VALUE;
//            flag = false;
            minStack = new ArrayList<>();
        }

        public void push(int x) {
//            if (x < min){
//                min = x;
//            }
            stack.add(x);
            if (minStack.size() == 0){
                minStack.add(x);
            }else {
                int min = minStack.get(minStack.size()-1);
                if (min > x){
                    minStack.add(x);
                }else {
                    minStack.add(min);
                }
            }

        }

        public void pop() {
//            int a = top();
//            flag = true;
            if (stack.size() > 0){
                stack.remove(stack.size()-1);
                minStack.remove(minStack.size()-1);
            }
        }

        public int top() {
            return stack.get(stack.size()-1);
        }

        public int getMin() {
            if (minStack.size() > 0){
                return minStack.get(stack.size() - 1);
            }
            return -1;
//            if (!flag)
//                return min;
//            else {
//                return Collections.min(stack);
//            }
        }
    }
}
