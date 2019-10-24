package jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work1 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        Stream<String> stream = one.stream();
        Stream<String> stream1 = stream.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });
        //流转为List
        List<String> one1 = stream1.collect(Collectors.toList());
        System.out.println(one1);
        Stream<String> stream2 = one.stream().limit(3);
        List<String> one2 = stream2.collect(Collectors.toList());
        System.out.println(one2);
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
        Stream<String> stream3 = two.stream().filter((s) -> s.charAt(0) == '张');
        List<String> two1 = stream3.collect(Collectors.toList());
        System.out.println(two1);
        //跳过前两个元素
        Stream<String> stream4 = two.stream().skip(2);
        List<String> two2 = stream4.collect(Collectors.toList());
        System.out.println(two2);
        one.addAll(two);
        System.out.println(one);
        Stream<Person> stream5 = one.stream().map(Person::new);
        List<Person> personList = stream5.collect(Collectors.toList());
        System.out.println(personList);
    }
}
class Person{
    private String name;
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
