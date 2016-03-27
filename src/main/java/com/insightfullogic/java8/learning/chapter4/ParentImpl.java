package com.insightfullogic.java8.learning.chapter4;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class ParentImpl implements Parent {
    private String lastMessage;

    @Override
    public void message(String body) {
        this.lastMessage = body;
        System.out.println(body);
    }

    @Override
    public String getLastMessage() {
        return lastMessage;
    }
}
