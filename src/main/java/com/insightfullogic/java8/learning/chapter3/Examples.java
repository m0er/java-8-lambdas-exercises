package com.insightfullogic.java8.learning.chapter3;

import com.insightfullogic.java8.learning.chapter1.Artist;
import com.insightfullogic.java8.learning.chapter1.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by AidenChoi on 2016. 3. 26..
 */
public class Examples {
    private List<Artist> allArtists;

    {
        allArtists = new ArrayList<>();
        allArtists.add(Artist.of("John Lennon", "London"));
        allArtists.add(Artist.of("Paul McCartney", "London"));
        allArtists.add(Artist.of("George Harrison", "London"));
        allArtists.add(Artist.of("Ringo Starr", "London"));
    }

    void example3_1() {
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
    }

    void example3_2_externalIteration() {
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
    }

    void example3_3_internalIteration() {
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
    }

    void example3_8_toUpperCase() {
        List<String> collected = new ArrayList<>();
        for (String string : asList("a", "b", "hello")) {
            collected.add(string.toUpperCase());
        }
    }

    void example3_9_toUpperCaseByMap() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
    }

    void example3_10_filterByIf() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a", "1abc", "abc1")) {
            if (isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
    }

    void example3_11_filter() {
        List<String> collected = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());
    }

    void example3_12_flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
    }

    void example3_13_maxOrMin() {
        List<Track> tracks = asList(Track.of("Bakai", 524),
                Track.of("Violets for Your Furs", 378),
                Track.of("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
    }

    void example3_16_reduce() {
        Integer count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
    }
}
