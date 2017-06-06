import java.util.*;

/**
 * Created by lianglab on 2017/6/6.
 * 注意事项
 * 1。如果程序没有什么错误但是一直不通过，一定要考虑是否有多个输入！！！
 * 2.stringBuilder.reverse(); stringBuffer.reverse() 字符串反转 直接用
 * 3。Arrays.sort(letters);直接用
 * 4。System.out.println(letters);顺序打印数组直接用
 * 5.使用scanner.hasNext()或者scanner.hasNextLine(),作为判断是否有多组输入的时候，如果不行就相互替换试试
 */
public class Junior0606 {

    public static void main(String[] args) {
        fun9();
    }
    /**
     * 反转字符串
     */
    public static void fun1(){
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        StringBuffer stringBuffer=new StringBuffer(word);
        String result=stringBuffer.reverse().toString();
        StringBuilder stringBuilder=new StringBuilder(word);
        stringBuilder.reverse();
        System.out.println(result);
    }

    /**
     * 整理图片
     */
    public static void fun2(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String word=scanner.nextLine();
            char[] letters=word.toCharArray();
            Arrays.sort(letters);
            System.out.println(letters);
        }
    }

    /**
     * 名字的漂亮度
     */
    public static void fun3(){
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        List<String> nameList=new ArrayList<>();
        while(number!=0){
            nameList.add(scanner.nextLine());
            number--;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(String s:nameList){
            map.clear();
            char[] letters=s.toCharArray();
            for(char c:letters){
                if(map.containsKey(c)){
                    int count=map.get(c);
                    map.replace(c,++count);
                }else{
                    map.put(c,1);
                }
            }

            Integer[] a=new Integer[map.size()];
            map.values().toArray(a);
            for(int i=0;i<a.length-1;i++){
                for(int j=0;j<a.length-1-i;j++){
                    if(a[j]<a[j+1]){
                        int temp=a[j];
                        a[j]=a[j+1];
                        a[j+1]=temp;
                    }
                }
            }
            int mix=26;
            int sum=0;
            for(int i:a){
                sum+=i*mix;
                mix--;
            }
            System.out.println(sum);
        }
    }

    /**
     * 名字的漂亮度,小写字母a的ascii码为97,优化版
     */
    public static void fun33(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            int number=Integer.parseInt(scanner.nextLine());
            String[] nameList=new String[number];
            for(int i=0;i<number;i++){
                nameList[i]=scanner.nextLine();
            }

            for(String name:nameList){
                int[] count=new int[26];
                for(int j=0;j<name.length();j++){
                    count[name.toLowerCase().charAt(j)-97]++;
                }
                Arrays.sort(count);//这是从小到大的排序，前面是0
                int sum=0;
                for(int i=0;i<count.length;i++){
                    sum+=count[i]*(i+1);
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 挑7
     */
    public static void fun4(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int number=scanner.nextInt();
            int count=0;
            int len=number>30000?30000:number;
            for(int i=7;i<=len;i++){
                String s=Integer.toString(i);
                if(i%7==0||s.contains("7")){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * 最后一个单词的长度
     */
    public static void fun5(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s=scanner.nextLine();
            String[] ss=s.split(" ");
            System.out.println(ss[ss.length-1].length());
        }
    }

    /**
     * 最小公倍数
     */
    public static void fun6(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if(a<=0||b<=0){
                return;
            }
            for(int i=1;i<=a*b;i++){
                if(i%a==0&&i%b==0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    /**
     * 计算字符个数
     */
    public static void fun7(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String ss=scanner.nextLine();
            String s=scanner.nextLine();
            char[] letters=ss.toLowerCase().toCharArray();
            char c=s.charAt(0);
            int count=0;
            for(char i:letters){
                if(i==c)
                    count++;
            }
            System.out.println(count);
        }
    }

    /**
     * 明明的随机数
     */
    public static void fun8(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int num=scanner.nextInt();
            int[] arr=new int[num];
            for(int i=0;i<num;i++){
                arr[i]=scanner.nextInt();
            }
            Arrays.sort(arr);
            int current=arr[0];
            System.out.println(current);
            for(int j=1;j<arr.length;j++){
                if(arr[j]==current)
                    continue;
                else{
                    current=arr[j];
                    System.out.println(current);
                }
            }

        }
    }

    /**
     * 进制转换
     */
    public static void fun9(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String num=scanner.nextLine();
            if(num.toLowerCase().startsWith("ox")){
                char[] letters=num.toLowerCase().substring(2,num.length()).toCharArray();
                int sum=0;
                for(int i=letters.length-1;i>=0;i--){

                }
            }else{

            }
            System.out.println(num);
        }
    }
}
