package com.camlait.global.erp.domain.helper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camlait.global.erp.domain.exception.SerializeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Several Utilities to serialize/deserialize from/to JSON format.
 */
public final class SerializerHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerHelper.class);
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
			LOGGER.error("Unable to serialize the provided object to JSON. Provided Object={}", toSerialize.toString());
			throw new SerializeException("Unable to serialize the provided object", e);
		}
	}

	/**
	 * De-Serializes the JSON message to an Object of the specified clazz.
	 *
	 * @param toDeserialized
	 *            Serialized version of the JSON object
	 * @param clazz
	 *            Target class to deserialize to
	 * @return Deserialized message into object
	 */
	public static <T> T deserialized(String toDeserialized, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(toDeserialized.getBytes(), clazz);
		} catch (IOException e) {
			LOGGER.error("Unable to parse message=[{}]", toDeserialized, e);
			throw new SerializeException("Unable to deserialized the provided message", e);
		}
	}

	/**
	 * Makes a deep copy of the provided object by serializing to a JSON form
	 * and deserializing into a new object.
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
