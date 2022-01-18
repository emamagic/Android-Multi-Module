package com.emamagic.common_jvm;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        GenreCategory.COMEDY,
        GenreCategory.WESTERN,
        GenreCategory.ROMANCE
})

@Retention(RetentionPolicy.SOURCE)
public @interface GenreCategory {
    String COMEDY = "top_movie_imdb";
    String WESTERN = "series";
    String ROMANCE = "popular_movie";
}
