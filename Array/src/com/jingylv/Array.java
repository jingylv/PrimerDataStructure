package com.jingylv;


/**
 * 自定义动态数组类
 */

public class Array {
    private int[] data;
    private int size;

    //有参构造函数  构造容量为capacity的数组
    public Array(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    //无参构造函数  默认数组容量为10
    public Array() {
        this(10);
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //获取元素个数
    public int getSize() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个元素
    public void addLast(int e) {
        /*if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. Array is full ");

        data[size] = e;
        size++;*/

        addIndex(size, e);
    }

    //向所有元素前添加一个新元素
    public void addFirst(int e) {
        addIndex(0, e);
    }

    //在index索引的位置添加一个元素
    public void addIndex(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    //获取index位置的元素
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Require index >= 0 and index <= size");

        return data[index];
    }

    //修改index位置的元素
    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index <= size");

        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Aarry: size = %d ,capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
