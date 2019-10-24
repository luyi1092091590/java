package datastruct;

import java.util.Arrays;

public class MyArray {
    public int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    //输出所有元素
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    //末尾增加元素
    public void add(int elem) {
        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = elem;
        elements = newArray;
    }

    //删除数组中的元素
    public void delete(int index) {
        int[] newArray = new int[elements.length - 1];
        if (index < 0 || index > elements.length - 1) {
            System.out.println("下标越界！");
        }
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else {
                newArray[i] = elements[i + 1];
            }
        }
        elements = newArray;
    }

    //插入元素到指定位置
    public void insert(int index, int elem) {
        int[] newArray = new int[elements.length + 1];
        if(index>elements.length){
            System.out.println("下标越界！");
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else {
                newArray[i + 1] = elements[i];
            }
        }
        newArray[index] = elem;
        elements = newArray;
    }
}
