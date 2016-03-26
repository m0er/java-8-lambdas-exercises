package com.insightfullogic.java8.learning.chapter1;

import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by AidenChoi on 2016. 3. 26..
 */
@Data
public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public Stream<Track> getTrackStream() {
        return Optional.ofNullable(tracks).isPresent() ? tracks.stream() : Stream.empty();
    }
}
