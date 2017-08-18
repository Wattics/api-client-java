package com.wattics.internal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class JsonUtils {
    private static final Gson GSON;

    static {
        GSON = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new WatticsDateTimeAdapter())
                .create();
    }

    public static String serialize(Object object) {
        return GSON.toJson(object);
    }
}
