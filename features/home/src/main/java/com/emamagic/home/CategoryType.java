package com.emamagic.home;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        CategoryType.GENRE,
        CategoryType.TOP,
        CategoryType.NEW,
        CategoryType.SERIES,
        CategoryType.POPULAR,
        CategoryType.ANIMATION,
})

@Retention(RetentionPolicy.SOURCE)
public @interface CategoryType {
    String GENRE = "genre";
    String TOP = "top_movie_imdb";
    String NEW = "movie_new";
    String SERIES = "series";
    String POPULAR = "popular_movie";
    String ANIMATION = "animation";
}
