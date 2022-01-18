package com.emamagic.common_jvm;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        MovieCategory.TOP_IMDB,
        MovieCategory.SERIES,
        MovieCategory.POPULAR,
        MovieCategory.ANIMATION,
})

@Retention(RetentionPolicy.SOURCE)
public @interface MovieCategory {
    String TOP_IMDB = "top_movie_imdb";
    String SERIES = "series";
    String POPULAR = "popular_movie";
    String ANIMATION = "animation";
}
