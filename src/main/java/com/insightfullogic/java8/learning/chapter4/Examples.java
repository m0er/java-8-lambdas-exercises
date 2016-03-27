package com.insightfullogic.java8.learning.chapter4;

import com.insightfullogic.java8.learning.chapter1.Album;

import java.util.IntSummaryStatistics;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class Examples {

    void ex4_1_logging() {
        Logger logger = new Logger();
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    void ex4_2_loggingByLambda() {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
    }

    void ex4_4_printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTrackStream()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }

    private String expensiveOperation() {
        return null;
    }
}
