import java.util.*;

public class Solution {
    public static Set<String> stringSet = new TreeSet<>();
    public static List<Integer> intArr = new ArrayList<>();

    public static void Rearrange(String prefix, String str){
        stringSet.add(prefix);
        for (char ch : str.toCharArray())
            Rearrange(prefix + ch, str.replaceFirst(ch + "", ""));
    }
    public static Map<Integer, Integer> isOneNumDivisionOnOther(List<Integer> set){
        Map<Integer,Integer> result = new HashMap<>();
        int len = set.size()-1;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i!=j){
                    if(set.get(i)%set.get(j)==0) result.put(set.get(i),set.get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Rearrange("", "123456789");
        stringSet.remove("");
        //for (String j : stringSet) System.out.println(j);

        for(String s:stringSet){
            intArr.add(Integer.parseInt(s));
        }
        Map<Integer,Integer> res = isOneNumDivisionOnOther(intArr);
        for(Map.Entry<Integer,Integer> item : res.entrySet()){
            System.out.printf("Делимое: %s  Делитель: %s \n", item.getKey(), item.getValue());
        }
    }
}
