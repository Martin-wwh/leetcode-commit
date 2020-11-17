package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * ref : https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/879/
 */
public class PerTemperatureSolution {

    class MyStack{
        private List<Integer> list;

        public MyStack(){
            this.list = new ArrayList<>();
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public void push(Integer s){
            list.add(s);
        }

        public void poll(){
            if (list.size()>0)
                list.remove(list.size()-1);
        }

        public Integer top(){
            if(list.size() > 0){
                Integer temp = list.get(list.size()-1);
                return temp;
            }
            return null;
        }

        public void reset(){
            list.clear();
        }

        public int size(){
            return list.size();
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        MyStack myStack = new MyStack();
        for (int i = T.length-1; i>=0; i--){
            while (!myStack.isEmpty() && T[i] >= T[myStack.top()])
                myStack.poll();
            ans[i] = myStack.isEmpty() ? 0 : myStack.top() - i;
            myStack.push(i);
        }
        return ans;
    }

}
