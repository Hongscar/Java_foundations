import java.util.*;

public class Sort {
//    public static <E extends Number> int max(ArrayList<E> list) {
//        int max = list.get(0).intValue();
//
//        for(int i = 0; i < list.size(); i++) {
//            int value = list.get(i).intValue();
//            if(value > max)
//                max = value;
//        }
//        return max;
//    }

    public static <E> void testGen() {
        Integer[] ints = {3,5,6};
        String[] strings = {"asd", "e3r", "vdx", "rtt"};
        Object[] objects = {3,5,7,88,9};
        E[] elements = (E[])new Object[]{4, 3, 11, 75};
        System.out.println(Arrays.toString(elements));
    }

    public static int max(ArrayList<? extends  Number> list) {
        int max = list.get(0).intValue();

        for(int i = 0; i < list.size(); i++) {
            int value = list.get(i).intValue();
            if(value > max)
                max = value;
        }
        return max;
    }

    public static <E extends Comparable<E>> void sort(E[] obj1) {
        E currentMin;           //当前最小值
        int currentMin_index;   //最小值的下标
        int k = 3;

        for(int i = 0; i < obj1.length - 1; i++) {  //-1与否都可以，因为最后一个肯定是最大值
            currentMin = obj1[i];
            currentMin_index = i;

            for(int j = i + 1; j < obj1.length; j++) {
                if(obj1[j].compareTo(currentMin) < 0) {
                    currentMin = obj1[j];
                    currentMin_index = j;
                }
            }

            if(currentMin_index != i) {
                obj1[currentMin_index] = obj1[i];
                obj1[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
       // int[] a = new int[]{1,2,3};
       // System.out.println(Arrays.toString(a));
        Integer[] integers = new Integer[]{new Integer(4), new Integer(6), 1, 10, new Integer(2)};
        Double[] doubles = new Double[]{3.5, 5.6, 4.1, 2.2, new Double(2.4)};
        Character[] characters = new Character[]{'s', 'c', 'q', 'a'};
        String[] strings = {"asd", "vdf", "rwe", "qwv", new String("asdc")};

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(characters));
        System.out.println(Arrays.toString(strings));
        System.out.println("--------");

        sort(integers);
        sort(doubles);
        sort(characters);
        sort(strings);

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(doubles));
        System.out.println(Arrays.toString(characters));
        System.out.println(Arrays.toString(strings));

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(4);
        integerArrayList.add(2);
        integerArrayList.add(6);
        integerArrayList.add(9);
        integerArrayList.add(1);
        System.out.println(max(integerArrayList));

//        ArrayList list = new ArrayList<Double>();
//        list.add(23);
//        list.add("asd");
//        System.out.println(list.toString());
//        Integer s = 2;
//        System.out.println(s.floatValue());

        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Double> l4 = new ArrayList<>();
        l4.add(3.5);
        l4.add(6.6);

        l1.add("asd");
        l1.add("zxc");
        l1.add("eee");
        l2.add(4);
        l2.add(5);
        System.out.println(l1);
        System.out.println(l2.toString());
       // Collection<Integer> l3 = (ArrayList<Integer>)(l1.clone());
        Collection<String> l3 = (ArrayList<String>)(l2.clone());
        System.out.println(l3);
        System.out.println(l1 instanceof  Collection);
        System.out.println(l2 instanceof Collection);

        Sort.<String>testGen();

        Collection<Integer> collection = new PriorityQueue<>();
        collection.add(3);
        collection.add(5);
        collection.add(1);
        Iterator<Integer> iterator = collection.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<Integer> iterator1 = l2.listIterator();

//        String str = "sdfv";
//        Integer num = Integer.parseInt(str);
    //    System.out.println(l1 instanceof ArrayList<String>);
    }
}
