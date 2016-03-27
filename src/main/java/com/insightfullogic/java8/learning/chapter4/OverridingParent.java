package com.insightfullogic.java8.learning.chapter4;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Parent: Hi!");
    }
}
