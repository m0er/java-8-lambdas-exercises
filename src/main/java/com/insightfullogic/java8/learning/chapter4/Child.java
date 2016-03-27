package com.insightfullogic.java8.learning.chapter4;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public interface Child extends Parent {

    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}
