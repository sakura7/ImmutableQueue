package com.codingchallenge.myanswer;

public final class  ImmutableQueue<T> implements Queue<T> {
    private final Stack<T> front; //keeps track of the elements being deQueued
    private final Stack<T> back; //keeps track of the elements being enQueued

    private static final class EmptyQueue<T> implements Queue<T>{

        private final static EmptyQueue emptyQueue = new EmptyQueue();
        public final static EmptyQueue getInstance(){
            return emptyQueue;
        }
        public final Queue<T> enQueue(T t){
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        public final Queue<T> deQueue(){
            System.out.println("Queue is empty.");
            return this;
        }

        public final T head(){
            System.out.println("Queue is empty.");
            return null;
        }

        public final boolean isEmpty(){
            return true;
        }
    }

    private ImmutableQueue(Stack<T> front, Stack<T> back)
    {
        this.front = front;
        this.back = back;
    }

    /**
     * method to reverse the stack
     * @param stack
     * @return
     */
    public final static Stack reverseStack(Stack stack)
    {
        Stack r = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty()){
            r = r.push(stack.head());
            stack = stack.pop();
        }
        return r;
    }

    public final static Queue getEmptyQueue(){
        return EmptyQueue.getInstance();
    }

    public final Queue<T> enQueue(T t){
        return new ImmutableQueue<T>(front, back.push(t));
    }

    //removes the element at the beginning of the immutable queue, and returns the new queue.
    public final Queue<T> deQueue(){
        Stack<T> f = front.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, back);
        }
        else if (back.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(back), ImmutableStack.getEmptyStack());
        }
    }

    public final T head(){
        return front.head();
    }

    public final boolean isEmpty(){
        return false;
    }
}