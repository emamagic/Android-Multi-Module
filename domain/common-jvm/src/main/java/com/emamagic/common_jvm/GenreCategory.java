package com.emamagic.common_jvm;

import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({
        GenreCategory.WESTERN,
        GenreCategory.DRAMA,
        GenreCategory.ROMANCE,
        GenreCategory.COMEDY,
        GenreCategory.ADVENTURE,
        GenreCategory.MUSICAL,
        GenreCategory.MYSTERY,
        GenreCategory.EPIC,
        GenreCategory.SPORTS
})

@Retention(RetentionPolicy.SOURCE)
public @interface GenreCategory {
    String WESTERN = "Western";
    String DRAMA = "Drama";
    String ROMANCE = "Action";
    String COMEDY = "Comedy";
    String ADVENTURE = "Adventure";
    String MUSICAL = "Musical";
    String MYSTERY = "Mystery";
    String EPIC = "Epic";
    String SPORTS = "Sports";
}
