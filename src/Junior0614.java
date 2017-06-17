import java.util.*;

/**
 * Created by lianglab on 2017/6/14.
 * 1. String的split()方法在遇到一符号的时候需要转义
 * .->\\.  \->\\\\
 */
public class Junior0614 {
    /**
     * 购物单,没做出来  需要学习背包算法
     */
    public static void fun1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] v = new int[n];
            int[] p = new int[n];
            int[] q = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt() / 10;
                p[i] = sc.nextInt() * v[i];
                q[i] = sc.nextInt();
            }
        }
    }

    public static int getMaxValue(int[] v, int[] p, int[] q, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m / 10; j++) {
                if (q[i - 1] == 0) {//说明是主件
                    if (p[i - 1] <= j) {
                        //用j这么多钱去买前i件商品可以获得的最大价值,就是比较把第i 个放进来还是不放进来总价值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i - 1]] + v[i - 1]);
                    }

                }
            }
        }
        return 0;
    }

    /**
     * 坐标变换
     */
    public static void fun2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] operations = str.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < operations.length; i++) {
                if (operations[i] == null || operations[i].isEmpty())//如果两个；之间是空或者空格
                    continue;
                char c = operations[i].charAt(0);
                int n = 0;
                try {
                    n = Integer.parseInt(operations[i].substring(1)); //如果后面的字符不能转换为数字
                } catch (Exception e) {
                    continue;
                }
                switch (c) {
                    case 'A':
                        x -= n;
                        break;
                    case 'S':
                        y -= n;
                        break;
                    case 'W':
                        y += n;
                        break;
                    case 'D':
                        x += n;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x + "," + y);
        }
    }

    public static void fun3() {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, h = 0;
        while (sc.hasNext()) {
            int ff = f;
            String str = sc.next();
            String[] ss = str.split("~");
            String[] ip = ss[0].split("\\.");   //点号需要转义
            String[] code = ss[1].split("\\.");
            int i1, i2, i3, i4;
            int c1, c2, c3, c4;
            try {
                c1 = Integer.parseInt(code[0]);
                c2 = Integer.parseInt(code[1]);
                c3 = Integer.parseInt(code[2]);
                c4 = Integer.parseInt(code[3]);

                if (!idMark(c1, c2, c3, c4)) {
                    f++;
                    continue;
                }

            } catch (Exception exception) {
                f++;
                continue;
            }
            try {
                i1 = Integer.parseInt(ip[0]);
                i2 = Integer.parseInt(ip[1]);
                i3 = Integer.parseInt(ip[2]);
                i4 = Integer.parseInt(ip[3]);
                if (i2 >= 0 && i2 <= 255 && i3 >= 0 && i3 <= 255 && i4 >= 0 && i4 <= 255) {
                    if (i1 >= 1 && i1 <= 126) {//A类
                        a++;
                        if (i1 == 10)
                            h++;
                    } else if (i1 >= 128 && i1 <= 191) {//B类
                        b++;
                        if (i1 == 172 && i2 >= 16 && i2 <= 31)
                            h++;
                    } else if (i1 >= 192 && i1 <= 223) {//C类
                        c++;
                        if (i2 == 168)
                            h++;
                    } else if (i1 >= 224 && i1 <= 239) {//D类
                        d++;
                    } else if (i1 >= 240 && i1 <= 255) {//E类
                        e++;
                    } else if (i1 == 0) {

                    } else
                        f++;
                } else {
                    f++;
                }
            } catch (Exception exception) {
                f++;
                continue;
            }


        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + h);
    }

    /**
     * 判断是否为子网掩码
     *
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @return
     */
    public static boolean idMark(int c1, int c2, int c3, int c4) {
        int[] lll = {254, 252, 248, 240, 224, 192, 128, 0};
        if (c1 == 255) {
            if (c2 == 255) {
                if (c3 == 255) {
                    for (int i : lll) {
                        if (c4 == i) {
                            return true;
                        }
                    }
                } else {
                    for (int i : lll) {
                        if (c3 == i && c4 == 0) {
                            return true;
                        }
                    }
                }
            } else {
                for (int i : lll) {
                    if (c2 == i && c3 == 0 && c4 == 0) {
                        return true;
                    }
                }
            }
        } else {
            for (int i : lll) {
                if (c1 == i && c2 == 0 && c3 == 0 && c4 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 简单错误记录
     */
    public static void fun4() {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();//保证顺序
        while (sc.hasNext()) {
            String str = sc.next();
            int l = sc.nextInt();
            int last = str.lastIndexOf("\\");
            String filename = str.substring(last + 1);
            if (filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            filename = filename + " " + l;    //把名字加行号作为键值
            if (map.containsKey(filename)) {
                int c = map.get(filename);
                map.put(filename, ++c);
            } else {
                map.put(filename, 1);
            }
        }

        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8)) //输出最后八个记录
                System.out.println(string + " " + map.get(string));
        }
    }

    /**
     * 密码验证合格程序
     */
    public static void fun5() {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNextLine()) {
            String pass = sc.nextLine();
            if (pass.length() <= 8) {
                System.out.println("NG");
            } else {
                int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
                char[] chars = pass.toCharArray();
                for (char c : chars) {
                    if (c >= 48 && c <= 57) {
                        c1 = 1;
                    } else if (c >= 97 && c <= 122) {
                        c2 = 1;
                    } else if (c >= 65 && c <= 90) {
                        c3 = 1;
                    } else {
                        c4 = 1;
                    }
                }
                int sum = c1 + c2 + c3 + c4;
                if (sum < 3) {
                    System.out.println("NG");
                } else {
                    boolean b = true;
                    for (int i = 0; i < pass.length() - 2; i++) {
                        //一个密码当中，不能有长度超过2的子串重复，例如zxcvbnmzxc,这个密码就不行，因为有zxc重复了
                        if (pass.substring(i + 1).contains(pass.substring(i, i + 3))) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        set.add(pass);
                        System.out.println("OK");
                    } else {
                        System.out.println("NG");
                    }


                }
            }
        }
    }
}

