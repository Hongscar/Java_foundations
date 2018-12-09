package datastructure.package_list;

import java.util.Arrays;

public class TestMyArrayList {
    public static void main(String[] args) {

        MyList<String> list = new MyArrayList<>();

        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada");
        System.out.println("(2) " + list);

        list.add("Russia");
        System.out.println("(3) " + list);

        list.add("France");
        System.out.println("(4) " + list);

        list.add(2, "Germany");
        System.out.println("(5) " + list);

        list.add(5, "Norway");
        System.out.println("(6) " + list);

        list.remove("Canada");
        System.out.println("(7) " + list);

        list.remove(2);
        System.out.println("(8) " + list);

        list.remove(list.size() - 1);   //remove the last element
        System.out.print("(9) " + list + "\n(10)");

        for (String s: list)
            System.out.print(s.toUpperCase() + " ");

        System.out.println();
        System.out.println(list.contains("Germany"));
        list.remove("Germany");
        System.out.println(list.contains("Germany"));

        list.add(1, "Germany");
        list.add("Germany");
        System.out.println(list);

        System.out.println(list.indexOf("Germany"));
        System.out.println(list.lastIndexOf("Germany"));

        list.set(1, "America");
        list.set(0, "China");
        System.out.println(list.remove(3));
        System.out.println(list);
       // System.out.println(list.remove(6));


        /*  test for the secure hole
        Integer[] integers = {4,6,8,2,9};
        System.out.println(Arrays.toString(integers));

        MyArrayList<Integer> list1 = new MyArrayList<>(integers);
        System.out.println(list1.get(3));
        list1.set(1,99);
        System.out.println(Arrays.toString(integers));

        System.out.println(list1.indexOf(100));
       //list1.add(1);

        System.out.println(list1);

        System.out.println(Arrays.toString(integers));

        integers[3] = 123456;
        System.out.println(list1);

        System.out.println(Arrays.toString(integers));
        */


    }
}
