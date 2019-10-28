package com.dispatcher.calibrator.tryer.calibrator;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import lombok.Getter;

@Getter
public class CalibratorFrame {

	private boolean dirtyFrame = true;

	private LocalDateTime frameStartTime;

	private LocalDateTime frameEndTime;

	private int processedItemCount = 0;

	private long timePassedInFrameMillis = 0;

	private long waitTimeInFrameMillis = 0;

	private long additionalDelayMillis = 0;

	private transient Gson gson;

	public CalibratorFrame() {
		this.gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
	}

	public void initiateFrame() {
		this.frameStartTime = LocalDateTime.now();
		this.timePassedInFrameMillis = 0;
		this.processedItemCount = 0;
		this.waitTimeInFrameMillis = 0;
		this.dirtyFrame = false;
	}

	public String finishFrame() {
		this.frameEndTime = LocalDateTime.now();
		String frameInfo = this.createFrameInfo();
		this.dirtyFrame = true;
		return frameInfo;
	}

	public void sumWithAdditionalDelayMillis(long value) {
		this.setAdditionalDelayMillis(this.additionalDelayMillis + value);
	}

	public void sumWithTimePassedInFrameMillis(long value) {
		this.setTimePassedInFrameMillis(this.timePassedInFrameMillis + value);
	}

	public void sumWithProcessedItemCount(int value) {
		this.setProcessedItemCount(this.processedItemCount + value);
	}

	public void sumWithWaitTimeInFrameMillis(long value) {
		this.setWaitTimeInFrameMillis(this.waitTimeInFrameMillis + value);
	}

	public void setAdditionalDelayMillis(long value) {
		this.additionalDelayMillis = value > 0 ? value : 0;
	}

	private void setTimePassedInFrameMillis(long value) {
		this.timePassedInFrameMillis = value > 0 ? value : 0;
	}

	private void setProcessedItemCount(int value) {
		this.processedItemCount = value > 0 ? value : 0;
	}

	private void setWaitTimeInFrameMillis(long value) {
		this.waitTimeInFrameMillis = value > 0 ? value : 0;
	}

	private String createFrameInfo() {
		return this.gson.toJson(this);
	}

	private class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
		private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d:MMM:uuuu HH:mm:ss");

		@Override
		public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
			return new JsonPrimitive(this.formatter.format(localDateTime));
		}
	}
}
