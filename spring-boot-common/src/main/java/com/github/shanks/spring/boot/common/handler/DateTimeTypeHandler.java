package com.github.shanks.spring.boot.common.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType)
			throws SQLException {
		if (parameter != null) {
			ps.setTimestamp(i, new Timestamp(parameter.toDate().getTime()));
		}
	}

	@Override
	public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
		Timestamp timestamp = rs.getTimestamp(columnName);
		return getDateTime(timestamp);
	}

	@Override
	public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		Timestamp timestamp = rs.getTimestamp(columnIndex);
		return getDateTime(timestamp);
	}

	@Override
	public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Timestamp timestamp = cs.getTimestamp(columnIndex);
		return getDateTime(timestamp);
	}
	
	private DateTime getDateTime(Timestamp timestamp) {
		if (timestamp != null) {
			return new DateTime(timestamp.getTime());
		}
		return null;
	}

}
