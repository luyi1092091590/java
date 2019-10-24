package zong;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Work1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("student");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Student student = new Student("luyi",22,90);
//        oos.writeObject(student);
        TreeSet<Student> treeSet = new TreeSet<>(new MyCompare());
        Student student1 = new Student("scout",5,  95);
        Student student2 = new Student("iboy",4,  90);
        Student student3 = new Student("clearlove", 1, 97);
        Student student4 = new Student("korol",2,  85);
        Student student5 = new Student("ray",2,  80);
        Student student6 = new Student("korol",2,  83);
        Student student7 = new Student("tom",8,  50);
        treeSet.add(student1);
        treeSet.add(student2);
        treeSet.add(student3);
        treeSet.add(student4);
        treeSet.add(student5);
        treeSet.add(student6);
        treeSet.add(student7);
        oos.writeObject(treeSet);
        oos.close();
        FileInputStream fis = new FileInputStream("student");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        System.out.println(o);
    }
}

class Student implements Serializable {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class MyCompare implements Comparator<Student>,Serializable {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().compareTo(o2.getName()) == 0 && o1.getAge() == o2.getAge()) {
            return o1.getScore() - o2.getScore();
        } else if (o1.getName().compareTo(o2.getName()) == 0) {
            return o1.getAge() - o2.getAge();
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
