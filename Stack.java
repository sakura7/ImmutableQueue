package com.codingchallenge.myanswer;

public interface Stack<T> {
    public Stack<T> push(T t);
    public Stack<T> pop() ;
    public T head();
    public boolean isEmpty();
}
