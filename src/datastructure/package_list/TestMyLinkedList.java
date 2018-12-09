package datastructure.package_list;

import java.lang.reflect.Method;
import java.util.Iterator;

public class TestMyLinkedList {
    public static void main(String[] args) throws Exception{
        MyLinkedList<String> myList = new MyLinkedList<>();

        //myList.addFirst(5);

//        System.out.println(myList.getClass());
//        Class<?> clazz = Class.forName("datastructure.package_list.MyLinkedList");
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method: methods)
//            System.out.println("method name:" + method.getName());

        myList.add("America");
        System.out.println("(1) " + myList);

        myList.add(0, "Canada");
        System.out.println("(2) " + myList);

        myList.add("Russia");
        System.out.println("(3) " + myList);

        myList.addLast("France");
        System.out.println("(4) " + myList);

        myList.add(2, "Germany");
        System.out.println("(5) " + myList);

        myList.add(5, "Norway");
        System.out.println("(6) " + myList);

        myList.add(0, "Poland");
        System.out.println("(7) " + myList);

        myList.remove(0);
        System.out.println("(8) " + myList);

        myList.remove(2);
        System.out.println("(9) " + myList);

        myList.remove(myList.size() - 1);
        System.out.println("(10) " + myList);

        for (String s: myList)
            System.out.print(s.toUpperCase() + " ");
        System.out.println();

        myList.removeFirst();
        System.out.println(myList);
        myList.addFirst("China");
        myList.add(3, "America");
        System.out.println(myList);
        System.out.println(myList.contains("France"));
        myList.removeLast();
        System.out.println(myList.contains("France"));
        System.out.println(myList);
        System.out.println(myList.indexOf("America"));
        System.out.println(myList.lastIndexOf("America"));
        myList.set(1, "Japan");
        System.out.println(myList);

        Iterator<String> iterator = myList.iterator();

//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

            System.out.println(iterator.next());
           // iterator.next();

        iterator.remove();
        iterator.remove();
        iterator.remove();


        System.out.println(myList);

    }
}
