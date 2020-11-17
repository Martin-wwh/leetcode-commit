package stack;

import java.util.ArrayList;
import java.util.List;

public class RPNSolution {

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

        public String poll(){
            if (list.size()>0){
                String s = list.get(list.size()-1);
                list.remove(list.size()-1);
                return s;
            }
            return null;
        }

        public String top(){
            if(list.size() > 0){
                String temp = list.get(list.size()-1);
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

    public int evalRPN(String[] tokens) {
        MyStack mystack = new MyStack();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ){
                int b = Integer.parseInt(mystack.poll());
                int a = Integer.parseInt(mystack.poll());
                int c = 0;
                switch(token){
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                mystack.push(c+"");
            }else{
                mystack.push(token);
            }
        }
        return Integer.parseInt(mystack.top());
    }
}
