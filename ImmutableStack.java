package com.codingchallenge.myanswer;

public final class ImmutableStack<T> implements Stack<T> {
    private final T head;
    private final Stack<T> tail;

    private static final class EmptyStack<T> implements Stack<T>{
        private final static EmptyStack emptyStack = new EmptyStack();

        public final static EmptyStack getInstance(){
            return emptyStack;
        }
        public final Stack<T> push(T t){
            return new ImmutableStack<T>(t, this);
        }
        public final Stack<T> pop(){
            System.out.println("Stack is empty.");
            return this;
        }
        public final T head() {
            System.out.println("Stack is empty.");
            return null;
        }
        public final boolean isEmpty(){
            return true;
        }
    }

    private ImmutableStack(T head, Stack<T> tail){
        this.head = head;
        this.tail = tail;
    }
    public final Stack<T> push(T t){ return new ImmutableStack<T>(t,this);}
    public final Stack<T> pop(){
        return tail;
    }
    public final T head(){
        return head;
    }
    public final boolean isEmpty(){
        return false;
    }
    public final static Stack getEmptyStack(){
        return EmptyStack.getInstance();
    }
}