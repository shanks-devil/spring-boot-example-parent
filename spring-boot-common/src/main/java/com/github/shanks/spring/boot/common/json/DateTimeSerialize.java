package com.github.shanks.spring.boot.common.json;

import java.io.IOException;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.shanks.spring.boot.common.utils.DateTimeUtils;

public class DateTimeSerialize extends JsonSerializer<DateTime> {

	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		if (value != null) {
			gen.writeString(DateTimeUtils.stringify(value));
		}
	}

}
