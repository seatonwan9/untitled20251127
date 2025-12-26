package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
/*        String s1 = 1 + 2 + "3";
        String s2 = "中国";
        System.out.println(s1.concat(s2));

        String s3 = "中国";
        String s4 = "中国";
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        // new String 会创建内容相同而引用地址不同的对象
        String s5 = new String("中国");
        String s6 = new String("中国");
        System.out.println(s5.equals(s6));

        // 不同对象 → == 返回 false
        System.out.println(s5 == s6);

        // hashCode() 相同内容 → 相同哈希码
        // equals() 和 hashCode() 保持一致
        System.out.println(s5.hashCode());
        System.out.println(s6.hashCode());

        System.out.println(s5.compareToIgnoreCase(s6));*/

/*        // 日期类
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        System.out.println(sdf.format(date));
        System.out.println(sdf.format(System.currentTimeMillis()));

        System.out.println(sdf.parse("2021-09-08 09:09:09.999"));

        // 日历类
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH) + 1);
        System.out.println(instance.get(Calendar.DATE));
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        instance.set(Calendar.YEAR, 2021);
        instance.setTime(date);
        System.out.println(instance.get(Calendar.YEAR));*/


/*        String s = "ab,c";

        System.out.println(s.charAt(2));

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }*/

/*        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
//        Arrays.sort();
        Object[] l1 = list1.toArray();
        Object[] l2 = list2.toArray();
        System.out.println(Arrays.equals(l1,0,3, l2, 0, 3));*/


        /*HashMap<String, String> map = new HashMap<>();
        map.put("1", "10001");
        map.put("2", "20002");
        map.put("3", "30003");

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if ("2".equals(key)) {
                iterator.remove();
            }
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println(map);*/

        // 新语法：""" 开头结尾
        String json = """
            {
              "name": "Alice",
              "age": 30
            }
            """;
        System.out.println(json);
    }
}
