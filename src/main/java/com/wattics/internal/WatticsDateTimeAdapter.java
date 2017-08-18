package com.wattics.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.ZoneOffset.UTC;

public class WatticsDateTimeAdapter implements JsonSerializer {
    @Override
    public JsonElement serialize(Object localDateTime, Type type, JsonSerializationContext context) {
        ZonedDateTime dateTime = ((LocalDateTime) localDateTime).atZone(UTC);
        return new JsonPrimitive(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'+00:00'")));
    }
}
