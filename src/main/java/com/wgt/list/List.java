package com.wgt.list;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface List<T> {
    boolean isEmpty();
    boolean contain(T object);
    int getSize();
    void set(int i,T object);
    void add(T object);
    void add(int i,T object);
    void removeAll();
    T get(int i);
    T remove(int i);
    boolean remove(T object);
    int indexOf(T key);
}
