
import java.util.*;

/**
 * Created by lianglab on 2017/6/13.
 */
public class Junior0613 {
    /**
     * 质数因子
     */
    public static void fun1(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLong()){
            long input=scanner.nextLong();
            while(input!=1){
                for(int i=0;i<=input;i++){
                    if(input%i==0){
                        input/=i;
                        System.out.print(i+" ");
                        break;
                    }
                }
            }
        }
    }

    /**
     * 取近似值
     */
    public static void fun2(){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextDouble()){
            System.out.println(scanner.nextDouble());
            int n=(int)scanner.nextDouble();
            System.out.println(n);
        }
    }

    /**
     * 合并表记录
     * 牛客网上是java1.7 貌似没有map和table的replace方法
     * map中不允许有相同key值存在，所以put相同key值的时候会直接覆盖，所以本题如果想覆盖就可以直接put
     */
    public static void fun3(){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        while(n>0){
            int key=scanner.nextInt();
            int value=scanner.nextInt();
            if(map.containsKey(key)){
                map.put(key,map.get(key)+value);
            }else {
                map.put(key,value);
            }
            n--;
        }

        List<Integer> list1=new ArrayList<>(map.keySet());
        Integer[] ks=new Integer[list1.size()];
        list1.toArray(ks);
        Arrays.sort(ks);
        for (Integer i:ks) {
            System.out.println(i+" "+map.get(i));
        }
    }

    /**
     * 合并表记录优化版，直接使用TreeMap,因为TreeMap是自动有序的
     */
    public static void fun4(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int s=sc.nextInt();
                int value=sc.nextInt();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + value);
                } else
                    map.put(s, value);
            }
            for (Integer key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }

    /**
     * 提取不重复的整数
     */
    public static void fun5(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String number=sc.nextLine();
            char[] numbers=number.toCharArray();
            for (int i=numbers.length-1;i>=0;i--){
                for(int j=i-1;j>=0;j--){
                    if(numbers[i]==numbers[j])
                        numbers[j]='a';
                }
            }
            for(int i=numbers.length-1;i>=0;i--){
                if(numbers[i]!='a')
                    System.out.print(numbers[i]);
            }
        }
    }

    /**
     * 提取不重复的整数优化版
     * 利用set中元素不允许重复的特性，再利用LinkedHashSet保留插入顺序的特性结合
     */
    public static void fun6(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            char[] nums=str.toCharArray();
            Set<Character> set=new LinkedHashSet<>();
            for(int i=nums.length-1;i>=0;i--){
                set.add(nums[i]);
            }
            String result="";
            for(Character c:set){
                result+=c;
            }
            System.out.println(result);
        }
    }

    /**
     * 字符个数统计
     * 所要注意的是，如果出现相同的字符，只能算一次，不能多算
     */
    public static void fun7(){
        Scanner sc = new Scanner(System.in);
        int[] table=new int[128];

        while(sc.hasNextLine()){
            String str=sc.nextLine();
            char[] letters=str.toCharArray();
            for(char c:letters){
                if((int)c>=0&&(int)c<=127){
                    table[c]++;
                }

            }
            int count=0;
            for(int i:table){
                if(i!=0)
                    count++;
            }
            System.out.println(count);
        }
    }

    /**
     * 数字颠倒
     */
    public static void fun8(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str=sc.nextLine();
            StringBuilder stringBuilder=new StringBuilder(str);
            System.out.println(stringBuilder.reverse().toString());
        }
    }

    /**
     * 句子逆序
     */
    public static void fun9(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str=sc.nextLine();
            String[] ss=str.split(" ");
            for(int i=ss.length-1;i>=0;i--){
                if(i==0){
                    System.out.print(ss[i]);
                }else
                    System.out.print(ss[i]+" ");

            }

        }
    }

    /**
     * 字符串的链接最长路径查找
     * 就是按照字典排序word
     */
    public static void fun10(){
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] strs=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=sc.nextLine();
        }
        Arrays.sort(strs);
        for(String s:strs){
            System.out.println(s);
        }
    }

    /**
     * 求int型整数在的二进制中1的个数
     */
    public static  void fun11(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            String s=Integer.toBinaryString(n);
            char[] chars=s.toCharArray();
            int count=0;
            for(char c:chars){
                if(c=='1')
                    count++;
            }
            System.out.println(count);
        }
    }
}
