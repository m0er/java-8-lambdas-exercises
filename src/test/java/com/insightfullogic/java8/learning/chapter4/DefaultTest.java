package com.insightfullogic.java8.learning.chapter4;

import org.junit.ComparisonFailure;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class DefaultTest {

    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test(expected = ComparisonFailure.class)
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();

        assertEquals("Child: Hi!", child.getLastMessage());
    }
}
