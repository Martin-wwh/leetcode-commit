package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * ref:https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/878/
 */
public class RightBracketsSolution {

    class MyStack{
        private List<String> list;

        public MyStack(){
            this.list = new ArrayList<>();
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public void push(String s){
            list.add(s);
        }

        public void poll(){
            if (list.size()>0)
                list.remove(list.size()-1);
        }

        public String top(){
            if(list.size() > 0){
                String temp = list.get(list.size()-1);

                return temp;
            }
            return null;
        }
    }

    public boolean isValid(String s) {
        MyStack myStack = new MyStack();
        char[] chars = s.toCharArray();
        for (Character c : chars){
            String temp = c+"";
            if ( myStack.isEmpty() ){
                myStack.push(temp);
            }else {
                String str = myStack.top();
                if ( (temp.equals(")")&&str.equals("(")) || (temp.equals("}")&&str.equals("{")) || (temp.equals("]")&&str.equals("[")) ){
                    myStack.poll();
                }else {
                    myStack.push(temp);
                }
            }

        }
        return myStack.isEmpty();
    }

}
