package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionsExample {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> list = new ArrayList();
//        list.add("Jack");
//        list.add("Mary");
//        list.add("John");
//        list.add("Peter");
//        list.add("Andy");

//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        String filename = "C:\\Users\\filippos\\Documents\\javaExamples\\lordOfRings.txt";
        File file = new File(filename);
        Scanner input = new Scanner(file);
//        
        int sizeOfList = wordCount(input, list);
        System.out.println("sizeOfList is " + sizeOfList);
        input.close();
        Set<Integer> numbers = new LinkedHashSet();
//        numbers.add(12);
//        numbers.add(12);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//        numbers.add(30);
//        System.out.println(numbers);
//        numbers.add(-3);
//        System.out.println(numbers);

//        for(int num:numbers){
//            if(num<10){
//                System.out.println(num);
//            }
//        }
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            int i = it.next();
            //System.out.println(i);
            if (i < 10) {
                it.remove();
            }
        }
//        System.out.println("numbers more than 10 are "+numbers);
        Set<String> set = new HashSet();
        input = new Scanner(file);
        int sizeOfSet = wordCount(input, set);
        System.out.println("size of set is " + sizeOfSet);
        input.close();

        Map<String, Integer> map = new HashMap();
        map.put("Helen", 15);
        map.put("Jack", 30);
        map.put("Jack", 40);
        System.out.println(map);

//        boolean exists;
//        exists = map.containsKey("Helen");
//        System.out.println("value of exists = " + exists);
//        exists = map.containsValue(45);
//        System.out.println("value of exists2 = "+ exists);
//        
//        int age = map.get("Helen");
//        System.out.println("age is "+age);
        System.out.println("\nPrinting with iterator");
        Set<String> kleidia = map.keySet();
        Iterator<String> it2 = kleidia.iterator();
        while (it2.hasNext()) {
            String name = it2.next();
            int age = map.get(name);
            System.out.println(name + " is " + age + " years old!");
        }
        System.out.println("\nPrinting with for-enhanced");
        for (String name : map.keySet()) {
            int age = map.get(name);
            System.out.println(name + " is " + age + " years old!");
        }

        Collection<Integer> values = map.values();
        for (int i : values) {
            System.out.println(i);
        }

        Set<Map.Entry<String, Integer>> setOfEntries = map.entrySet();

        for (Map.Entry me : setOfEntries) {
            System.out.println("key:" + me.getKey() + " with value:" + me.getValue());
        }

        //System.out.println("setOfEntries = "+setOfEntries);
        Map<String, Integer> mapOfWords = new HashMap();
        input = new Scanner(file);
        putInMap(input, mapOfWords);
        input.close();
        System.out.println("mapOfWords=" + mapOfWords.size());

        printMap(mapOfWords);
    }

    static void printList(List<String> list) {
        for (String x : list) {
            System.out.println("x is " + x);
        }
    }

    static int wordCount(Scanner input, Collection c) throws FileNotFoundException {
        while (input.hasNext()) {
            String leksi = input.next();
            c.add(leksi);
        }
        return c.size();
    }

    public static void putInMap(Scanner input, Map<String, Integer> map) {
        while (input.hasNext()) {
            String word = input.next();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.replace(word, count, count + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    public static void printMap(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> setOfEntries = map.entrySet();
        for (Map.Entry me : setOfEntries) {
            if ((Integer) me.getValue() > 5) {
                System.out.println("word \"" + me.getKey() + "\" is found " + me.getValue()+" times.");
            }

        }
    }

}
