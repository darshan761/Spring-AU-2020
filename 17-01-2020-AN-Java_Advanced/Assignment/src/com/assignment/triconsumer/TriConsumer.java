package com.assignment.triconsumer;

@FunctionalInterface
public interface TriConsumer<T ,U ,S  > {
 
   void apply(T t, U u, S s);
}

