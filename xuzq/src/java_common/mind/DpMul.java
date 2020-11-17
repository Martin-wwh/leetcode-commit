package java_common.mind;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.mind
 * @Author: xuzq11
 * @CreateTime: 2020-09-30 16:36
 * @Description:
 */
public class DpMul {

    int res = 0;

    public int multiply(int A, int B) {

        int max = A > B ? A : B;
        int min = A > B ? B : A;
        int i = 1;
        mul(i,min,max,0);
        return res;
    }

    public void mul(int i, int min, int max, int index){
        if (i > min) return;
        int temp = (i & min) >> index;
        if (temp == 1){
            res += max << index;
        }
        mul(i<<1, min, max, ++index);
    }

    @Test
    public void test(){
        System.out.println(multiply(5,5));
    }
}
