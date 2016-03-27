package com.insightfullogic.java8.learning.chapter4;

import java.util.function.Supplier;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class Logger {
    private boolean debugEnabled = true;

    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    public void debug(String message) {
        System.out.println(message);
    }

    public void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }
}
