package com.insightfullogic.java8.learning.chapter1;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Created by AidenChoi on 2016. 3. 26..
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class Artist {

    @NonNull
    private String name;

    @NonNull
    private String origin;

    private List<Artist> members;

    public boolean isFrom(String from) {
        if (origin == null || from == null) {
            return false;
        }
        return origin.equals(from);
    }
}
