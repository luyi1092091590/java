package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work2 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        Stream<Integer> stream = list.stream().map(num -> num * num);
        List<Integer> newList = stream.collect(Collectors.toList());
        System.out.println(newList);
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {3, 4};
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        Stream<int[]> stream1 = list1.stream().flatMap(
                i -> {
                    System.out.println("flagmap中");
                    return list2.stream().map(
                        j -> {
                        System.out.println("map中");
                        return new int[]{i, j};
                        });
                });
//        Stream<int[]> stream1 = list1.stream().flatMap(i->
//                list2.stream().map(
//                        j-> new int[]{i,j}));
        List<int[]> newlist1 = stream1.collect(Collectors.toList());
        newlist1.forEach((e)-> System.out.println(Arrays.toString(e)));
        System.out.println("======================");
        //返回能被3整除的
        Stream<int[]> stream2 = list1.stream().flatMap(
                a-> list2.stream().map(
                        b-> new int[]{a,b}))
                .filter(elem->(elem[0]+elem[1])%3==0);
        List<int[]> newlist2 = stream2.collect(Collectors.toList());
        newlist2.forEach(yuansu-> System.out.println(Arrays.toString(yuansu)));
    }
}
