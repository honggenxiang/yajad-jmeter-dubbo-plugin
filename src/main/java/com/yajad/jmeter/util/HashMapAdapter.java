package com.yajad.jmeter.util;

import com.google.common.primitives.Ints;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * {
 * "dayOfWeek": "SATURDAY",
 * "month": "MAY",
 * "hour": 23,
 * "year": 2020,
 * "dayOfMonth": 23,
 * "dayOfYear": 144,
 * "monthValue": 5,
 * "nano": 275000000,
 * "chronology": {
 * "calendarType": "iso8601",
 * "id": "ISO",
 * "class": "java.time.chrono.IsoChronology"
 * },
 * "class": "java.time.LocalDateTime",
 * "minute": 29,
 * "second": 12
 * }
 */
public class HashMapAdapter implements JsonSerializer<HashMap<String, Object>> {

    @Override
    public JsonElement serialize(HashMap<String, Object> src, Type typeOfSrc, JsonSerializationContext context) {
        if (src != null) {
            String className = Objects.toString(src.get("class"), null);
            if (Objects.equals(className, "java.time.LocalDateTime")) {
                Integer year = Ints.tryParse(Objects.toString(src.get("year")));
                Integer month = Ints.tryParse(Objects.toString(src.get("monthValue")));
                Integer day = Ints.tryParse(Objects.toString(src.get("dayOfMonth")));
                Integer hour = Ints.tryParse(Objects.toString(src.get("hour")));
                Integer minute = Ints.tryParse(Objects.toString(src.get("minute")));
                Integer second = Ints.tryParse(Objects.toString(src.get("second")));

                LocalDateTime time = LocalDateTime.of(year, month, day, hour, minute, second);
                String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(time);
                return new JsonPrimitive(format);
            } else {
                JsonObject jsonObject = new JsonObject();
                for (Map.Entry<String, Object> entry : src.entrySet()) {
                    jsonObject.add(entry.getKey(), context.serialize(entry.getValue()));
                }
                return jsonObject;
            }
        }
        return null;
    }
}