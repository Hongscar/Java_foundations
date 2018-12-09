package myTestComparator;

import someObj.Circle;
import someObj.GeometricObject;
import someObj.Rectangle;

import java.util.*;

public class testComparator {
    public static double max(GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c) {
        if(c.compare(g1, g2) > 0)
            return g1.getArea();
        else
            return g2.getArea();
    }

    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5, 5);
        GeometricObject g2 = new Circle(5);

        //System.out.println(max(g1, g2, new MyComparator()));
        List<String> list = Arrays.asList("yellow", "green", "red", "blue", "orange");
        List<Integer> integerList = Arrays.asList(4, 6, 12, 1, 3, 77, 54);
        //Collections.reverse(list);
        //Collections.sort(integerList, Collections.reverseOrder());
        Collections.reverse(integerList);
        System.out.println(integerList);

        List<GregorianCalendar> list1 =
                Collections.nCopies(5, new GregorianCalendar(2005, 0, 1));

        Queue<Integer> queue = new PriorityQueue<>(100, Collections.reverseOrder());
        queue.offer(34);
        queue.offer(4);
        queue.offer(30);
        while(queue.size() > 0)
            System.out.println(queue.poll());

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        set.add(5);
        set.add(7);
        set.add(1);
        set.add(1);
        set.add(8);
        set.add(2);
        System.out.println(set);

        Map<String, Integer> map = new TreeMap<>();
        map.put("qq", 4356);
        map.put("asd", 1435);
        map.put("tg", 654);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            String key;
            int value;
            Map.Entry<String, Integer> entry = iterator.next();
            key = entry.getKey();
            value = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("value = " + value);
        }
    }
}
