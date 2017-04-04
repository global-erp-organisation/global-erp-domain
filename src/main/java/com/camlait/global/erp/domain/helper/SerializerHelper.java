package com.camlait.global.erp.domain.helper;

import com.camlait.global.erp.domain.exception.SerializeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Several Utilities to serialize/deserialize from/to JSON format.
 */
public final class SerializerHelper {
    private static final Logger LOG = LoggerFactory.getLogger(SerializerHelper.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private SerializerHelper() {
    }

    /**
     * Serializes this Object structure to JSON format.
     *
     * @return object in JSON format (String).
     */
    public static String toJson(Object toSerialize) {
        try {
            return OBJECT_MAPPER.writeValueAsString(toSerialize);
        } catch (JsonProcessingException e) {
            LOG.error("Unable to serialize the provided object to JSON. Provided Object={}", toSerialize.toString());
            throw new SerializeException("Unable to serialize the provided object", e);
        }
    }

    /**
     * De-Serializes the JSON message to an Object of the specified clazz.
     *
     * @param jsonMessage Serialized version of the JSON object
     * @param clazz Target class to deserialize to
     * @return Deserialized message into object
     */
    public static <T> T deserialized(String jsonMessage, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(jsonMessage.getBytes(), clazz);
        } catch (IOException e) {
            LOG.error("Unable to parse message=[{}]", jsonMessage, e);
            throw new SerializeException("Unable to deserialized the provided message", e);
        }
    }

    /**
     * Makes a deep copy of the provided object by serializing to a JSON form and the deserializing into
     * a new object.
     *
     * @param from
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T copy(T from) {
        final String serialized = toJson(from);
        return deserialized(serialized, (Class<T>) from.getClass());
    }
}
