package com.qianfeng.day0409.homework;
/*
* 1.使用迭代器遍历Set、List
* */
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Random random=new Random();
        Set<Integer> hashSet=new HashSet<>();
        Set<Integer> treeSet=new TreeSet<>();
        List<Integer> arrayList=new ArrayList<>();
        List<Integer> linkedList=new LinkedList<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i=0;i<10;i++){
            int t=random.nextInt(1000)+1;
            hashSet.add(t);
            treeSet.add(t);
            arrayList.add(t);
            linkedList.add(t);
            linkedHashSet.add(t);
        }
        printCollection(hashSet);
        printCollection(treeSet);
        printCollection(arrayList);
        printCollection(linkedList);
        printCollection(linkedHashSet);

    }
    public static <T> void printCollection(Collection<T> collection){
        Iterator<T> iterable=collection.iterator();
        while (iterable.hasNext()) {
            System.out.print(iterable.next());
            if(!iterable.hasNext())break;
            System.out.print(",");
        }
        System.out.println();
    }
}
