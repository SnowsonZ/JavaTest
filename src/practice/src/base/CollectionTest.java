package practice.src.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.naming.Name;

/**
 * @Author: Snowson
 * @Date: 2018/4/3 14:26
 * @Description:
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("snowson");
        list.add("bob");
        list.add("tom");
        ListIterator<String> listIterator = list.listIterator();
        listIterator.next();
        listIterator.add("new man");
        ListIterator<String> listIterator1 = list.listIterator();
        while (listIterator1.hasNext()) {
            System.out.println(listIterator1.next());
        }

        List<String> list1 = new ArrayList<>();
        list1.add("snowson");
        list1.add("bob");
        list1.add("tom");
        list1.add("snowson1");
        list1.add("bob1");
        list1.add("tom1");
        ListIterator<String> listIterator2 = list1.listIterator();
        while (listIterator2.hasNext()) {
            System.out.println(listIterator2.next());
        }

        System.out.println();
        HashMap<String, String> hm = new HashMap<>(64, 0.75f);
        hm.put("name", "heliceptor");
        hm.put("name1", "heliceptor1");
        hm.put("name2", "heliceptor2");
        hm.put("name3", "heliceptor3");
        hm.put("name4", "heliceptor4");
        Collection<String> values = hm.values();
        System.out.println(values);
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> item : entries) {
            System.out.println(item.toString());
        }

        System.out.println(100 ^ 123);

    }
}
