package com.insightfullogic.java8.learning.chapter1;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by AidenChoi on 2016. 3. 26..
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class Track {

    @NonNull
    private String name;

    @NonNull
    private int length;
}
