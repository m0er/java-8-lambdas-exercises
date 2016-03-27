package com.insightfullogic.java8.learning.chapter4;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public interface Parent {

    void message(String body);

    default void welcome() {
        message("Parent: Hi!");
    }

    String getLastMessage();

}
