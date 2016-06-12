package com.github.shanks.spring.boot.common.json;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.shanks.spring.boot.common.utils.DateTimeUtils;

public class DateTimeDeserialize extends JsonDeserializer<DateTime> {

	@Override
	public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		if (StringUtils.isNoneBlank(p.getText())) {
			DateTimeUtils.parse(p.getText());
		}
		return null;
	}


}
