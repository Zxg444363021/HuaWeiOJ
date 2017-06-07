import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lianglab on 2017/6/7.
 * 1.其他进制转换到十进制直接用Integer.parseInt(num,16);
 * 2。十进制转换到其他进制可以直接用Integer.toHexString();toBinaryString()
 */
public class Junior0607 {
    /**
     * 字符串分隔
     */
    public  static void fun1(){
        Scanner scanner=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        for(int i=0;i<2;i++){
            String s=scanner.nextLine();
            list.add(s);
        }
        for(String s:list){
            if(s.length()<=8){
                System.out.print(s);
                for(int i=s.length();i<8;i++){
                    System.out.print("0");
                }
                System.out.print("\n");
            }else{
                while(s.length()>8){
                    String ss=s.substring(0,8);
                    System.out.println(ss);
                    s=s.substring(8,s.length());
                }
                System.out.print(s);
                for(int i=s.length();i<8;i++){
                    System.out.print("0");
                }
                System.out.print("\n");
            }
        }

    }
    /**
     * 进制转换16to10
     */
    public static void fun2(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String num=scanner.nextLine();
            if(num.toLowerCase().startsWith("ox")){
                int result=Integer.parseInt(num,16);
                System.out.println(result);
            }
        }
    }

    public static void fun3(){
        Scanner scanner=new Scanner(System.in);
        List<Long> list=new ArrayList<>();
        long z=2;
        while(scanner.hasNext()) {
            long number=scanner.nextLong();
            while(number%z==0){
                list.add(z);
                for(int i=2;i<z/2;i++){
                    if((z+1)/i==0){
                        break;
                    }
                }
            }
        }
    }
}

