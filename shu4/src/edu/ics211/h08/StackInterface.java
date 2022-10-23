package edu.ics211.h08;

import java.util.EmptyStackException;

public interface StackInterface<E> {
    /* @param	value to push onto the stack */
    void push(E value);
    /* @return	and remove the top value on the stack */
    E pop() throws java.util.EmptyStackException;
    /* @return	the top value on the stack */
    E peek() throws java.util.EmptyStackException;
    /* @return	whether the stack is empty */
    boolean empty();
}	