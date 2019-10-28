package com.dispatcher.calibrator.tryer.calibrator;

import java.time.LocalDateTime;

public class OrginalCalibrator {
	
	private final long frameTimeInMillis;

	private final int maxProcessItemCount;

	private final long avarageProcessTimeMillis;

	private final long safePointMillis = 1000;

	private boolean dirtyFrame = true;

	private LocalDateTime frameStartTime;

	private LocalDateTime frameEndTime;

	private int processedItemCount = 0;

	private long timePassedInFrameMillis = 0;

	private long waitTimeInFrameMillis = 0;

	private long additionalDelayMillis = 0;

	public OrginalCalibrator(long frameTimeInMillis, int maxProcessItemCount) {
		this.frameTimeInMillis = frameTimeInMillis;
		this.maxProcessItemCount = maxProcessItemCount;
		this.avarageProcessTimeMillis = (long) Math.rint((double) frameTimeInMillis / (double) maxProcessItemCount);
	}

	public void process(long unitProcessedTime, int unitProcessedItemCount) {
		if (this.dirtyFrame) {
			this.initialPosition();
		}

		this.timePassedInFrameMillis = this.timePassedInFrameMillis + unitProcessedTime;
		this.processedItemCount = this.processedItemCount + unitProcessedItemCount;
		if (this.processedItemCount <= maxProcessItemCount) {
			if (unitProcessedTime < this.additionalDelayMillis) {
				long sleepTime = this.additionalDelayMillis * unitProcessedItemCount;
				if (sleepTime > 0) {
					this.sleep(sleepTime);
					this.timePassedInFrameMillis = this.timePassedInFrameMillis + sleepTime;
				}
			} else {
				// System.out.println("unitProcessedTime < this.additionalDelayMillis");
			}

			this.checkPeriod();
//			System.out.println("item processed => " + unitProcessedItemCount + " unitProcessedTime => "
//					+ unitProcessedTime + " added delay => " + this.additionalDelayMillis + " total item processed => "
//					+ this.processedItemCount);
		} else {
			long diffirence = this.frameTimeInMillis - this.timePassedInFrameMillis;
			long sleepTime = 0;
			if (diffirence > this.safePointMillis) {
				sleepTime = (this.frameTimeInMillis - this.timePassedInFrameMillis) - this.safePointMillis;
				this.sleep(sleepTime);
				this.waitTimeInFrameMillis = this.waitTimeInFrameMillis + sleepTime;
				this.timePassedInFrameMillis = this.timePassedInFrameMillis + sleepTime;
			}

//			System.out.println("delay added => " + sleepTime + " total => " + this.waitTimeInFrameMillis
//					+ " time passed in frame => " + this.timePassedInFrameMillis);
			this.finishFrame();
		}
	}

	private void setAdditionalDelayMillis(long additionalDelayMillis) {
		this.additionalDelayMillis = additionalDelayMillis > 0 ? additionalDelayMillis : 0;
	}

	private void initialPosition() {
		this.frameStartTime = LocalDateTime.now();
		this.timePassedInFrameMillis = 0;
		this.processedItemCount = 0;
		this.waitTimeInFrameMillis = 0;
		this.dirtyFrame = false;
	}

	private void finishFrame() {
		this.frameEndTime = LocalDateTime.now();
		this.logFrameInfo();
		this.calculateDelayTime();
		this.initialPosition();
		this.dirtyFrame = true;
	}

	private void checkPeriod() {
		if (this.timePassedInFrameMillis >= this.frameTimeInMillis) {
			if (this.maxProcessItemCount > this.processedItemCount && this.additionalDelayMillis != 0) {
				System.out.println("Additional delay must be decreased.");
				// this.calculateDelayTime();
			} else {
				this.setAdditionalDelayMillis(0);
			}

//			System.out.println("frame finished in normal behavier. processed item count is => "
//					+ this.processedItemCount + " passed time is => " + this.timePassedInFrameMillis
//					+ " additional frame is => " + this.additionalDelayMillis);

			this.finishFrame();
		}
	}

	private void calculateDelayTime() {
		if (this.waitTimeInFrameMillis > 0 || this.processedItemCount < this.maxProcessItemCount) {
			long processedTime = this.waitTimeInFrameMillis == 0 ? this.frameTimeInMillis
					: this.frameTimeInMillis - this.waitTimeInFrameMillis;
			long processedTimeForPerItem = processedTime / this.processedItemCount; // this.maxProcessItemCount;
			this.setAdditionalDelayMillis(
					this.additionalDelayMillis + (this.avarageProcessTimeMillis - processedTimeForPerItem));
		}
	}

	public void sleep(long delay) {
		try {
			Thread.currentThread().sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public void logFrameInfo() {
		System.out.println(String.format(CalibratorLogContent.FRAMEINFOCONTENT, this.frameStartTime, this.dirtyFrame,
				this.frameTimeInMillis, this.timePassedInFrameMillis, this.processedItemCount,
				this.waitTimeInFrameMillis, this.additionalDelayMillis, this.frameEndTime));
	}
}
