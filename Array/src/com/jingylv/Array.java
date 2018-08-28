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

    //查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找数组中元素e的索引 如果不存在元素e返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置上的元素并返回该元素
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failde. Index is illegal.");

        int ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return ret;
    }

    //从数组中删除第一个元素并返回该元素
    public int removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素并返回该元素
    public int removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Aarry: size = %d ,capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
