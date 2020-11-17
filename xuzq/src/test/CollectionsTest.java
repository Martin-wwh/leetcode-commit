package test;

import org.junit.Test;

import java.util.*;

public class CollectionsTest {

    public static void main(String[] args) {
        String[] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = new ArrayList<>(Arrays.asList(s));
        Collections.reverse(list);
        s = list.toArray(new String[0]);
        for (String str : s){
            System.out.println(str);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("11111");
            }
        },2000);

        System.out.println("-----------------------");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if ("quick".equals(iterator.next())){
                iterator.remove();
            }
        }
        for (String str : list){
            System.out.println(str);
        }

    }

    @Test
    public void test(){
        String S = "vmokgggqzp";
        int[] indexes = new int[]{3,5,1};
        String[] sources = new String[]{"kg","ggq","mo"};
        String[] targets = new String[]{"s","so","bfr"};
        System.out.println(findReplaceString(S,indexes,sources,targets));
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        sort(indexes,sources,targets);
        boolean[] isChanges = new boolean[indexes.length];
        for(int i=0; i<sources.length; i++){
            int index = indexes[i];
            String tempStr = sources[i];
            isChanges[i] = tempStr.equals(S.substring(index, index+tempStr.length()));
        }
        String result = "";
        String temp = S;
        for(int i=0; i<sources.length; i++){
            if (isChanges[i]){
                String[] strs = temp.split(sources[i]);
                if (strs.length == 0){
                    result = result + targets[i];
                }else {
                    result = result + temp.split(sources[i])[0] + targets[i];
                }

                if (strs.length > 1)
                    temp = S.substring(indexes[i] + sources[i].length());
                else
                    break;
            }
            if (i == sources.length-1){
                result = result + temp;
            }
        }
        if ("".equals(result)){
            result = S;
        }

        return result ;
    }

    private void sort(int[] indexes, String[] sources, String[] targets){
        //选择排序
        for (int i=0; i<indexes.length-1; i++){
            int min = i;
            for (int j=i+1; j<indexes.length; j++){
                if (indexes[j] <indexes[min]){
                    min = j;
                }
            }
            int temp = indexes[min];
            indexes[min] = indexes[i];
            indexes[i] = temp;
            String tempStr = sources[min];
            sources[min] = sources[i];
            sources[i] = tempStr;
            tempStr = targets[min];
            targets[min] = targets[i];
            targets[i] = tempStr;
        }
    }

    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i=1; i<nums.length; i++){
            int top = stack.peek();
            if (nums[i] > top){
                stack.push(nums[i]);
                if (stack.size() == 3){
                    return true;
                }
            }else {
                stack.clear();
                stack.push(nums[i]);
            }
        }
        return false;
    }

}
