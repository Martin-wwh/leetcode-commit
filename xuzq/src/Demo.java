import org.junit.Test;

import java.util.Stack;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuzq11
 * @CreateTime: 2020-06-21 13:20
 * @Description:
 */
public class Demo {

    public int getResult(String str){
        Stack<String> st = new Stack<>();
        Stack<Integer> res = new Stack<>();

        boolean flag = true;
        int N = str.length();
        for (int i = N - 1; i >=0;)
        {
            if (str.charAt(i) == ')' || str.charAt(i) == ' '||str.charAt(i) == '('){
                i=i-1;
            }
            else if (str.charAt(i) >= 'a'&&str.charAt(i) <= 'z')
            {
                String op = str.substring(i - 2, i+1);
                st.add(op);
                i -= 3;
            }
            else
            {
                int spaceIndex = str.lastIndexOf(' ', i);
                if ((spaceIndex<0)||(str.charAt(spaceIndex+1)<='z'&&str.charAt(spaceIndex+1) >= 'a'))
                    spaceIndex = str.lastIndexOf('(', i);
                String num = str.substring(spaceIndex + 1, i +1);
                st.add(num);
                i = spaceIndex;
            }
        }
        int n = st.size();
        for (int j = 0; j<n; ++j)
        {
            String s = st.get(j);
            if (s.equals("add") || s.equals("sub")|| s.equals("mul") || s.equals("div"))
            {
                if (res.size()<2)
                    return 0;
                int num2 = res.peek(); res.pop();
                int num1 = res.peek(); res.pop();
                int result = 0;

                if (s.equals("add") )
                    result = num1 + num2;
                else if (s.equals("sub"))
                    result = num2 - num1;
                else if (s.equals("mul"))
                    result = num1 * num2;
                else if (s.equals("div"))
                {
                    if (num1 == 0)
                        flag = false;
                    else
                        result = num2 / num1;
                }

                res.push(result);
            }
            else
            {
                res.push(Integer.parseInt(s));
            }
        }

        if (!flag)
            throw new RuntimeException("error");
        else
            return res.peek();
    }


    @Test
    public void test(){
        System.out.println(getResult("(mul 3 -7)"));
    }
}
