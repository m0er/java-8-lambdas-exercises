package com.insightfullogic.java8.learning.chapter3;

import com.insightfullogic.java8.learning.chapter1.Album;
import com.insightfullogic.java8.learning.chapter1.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by AidenChoi on 2016. 3. 27..
 */
public class Refactorings {

    Set<String> findLongTracksLegacy(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    Set<String> findLongTracksRefactoring1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if (track.getLength() > 60) {
                                    trackNames.add(track.getName());
                                }
                            });
                });
        return trackNames;
    }

    Set<String> findLongTracksRefactoring2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTrackStream()
                            .filter(track -> track.getLength() > 60)
                            .map(track -> track.getName())
                            .forEach(name -> trackNames.add(name));
                });
        return trackNames;
    }

    Set<String> findLongTracksRefactoring3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();

        albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));

        return trackNames;
    }

    Set<String> findLongTracksRefactoring4(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());
    }

    Set<String> findLongTracksMine(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTrackStream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());
    }
}
