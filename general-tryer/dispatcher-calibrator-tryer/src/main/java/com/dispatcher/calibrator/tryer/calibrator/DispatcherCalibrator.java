package com.dispatcher.calibrator.tryer.calibrator;

public class DispatcherCalibrator {

	private final long frameTimeInMillis;

	private final int maxProcessItemCount;

	private final long avarageProcessTimeMillis;

	private final long safePointMillis = 1000;

	private final CalibratorFrame calibratorFrame;

	public DispatcherCalibrator(long frameTimeInMillis, int maxProcessItemCount) {
		this.frameTimeInMillis = frameTimeInMillis;
		this.maxProcessItemCount = maxProcessItemCount;
		this.avarageProcessTimeMillis = (long) Math.rint((double) frameTimeInMillis / (double) maxProcessItemCount);
		this.calibratorFrame = new CalibratorFrame();
	}

	public void process(long unitProcessedTime, int unitProcessedItemCount) {
		if (this.calibratorFrame.isDirtyFrame()) {
			this.initiateFrame();
		}

		this.calibratorFrame.sumWithTimePassedInFrameMillis(unitProcessedTime);
		this.calibratorFrame.sumWithProcessedItemCount(unitProcessedItemCount);

		if (this.calibratorFrame.getProcessedItemCount() <= maxProcessItemCount) {
			this.processDelay(unitProcessedTime, unitProcessedItemCount);
		} else {
			this.processWait(unitProcessedTime, unitProcessedItemCount);
		}
	}

	private void processDelay(long unitProcessedTime, int unitProcessedItemCount) {
		if (unitProcessedItemCount > 0) {
			long itemProcessedTime = unitProcessedTime / unitProcessedItemCount;
			if (itemProcessedTime < this.avarageProcessTimeMillis) {
				long sleepTime = this.calibratorFrame.getAdditionalDelayMillis() * unitProcessedItemCount;
				if (sleepTime > 0) {
					this.sleep(sleepTime);
					this.calibratorFrame.sumWithTimePassedInFrameMillis(sleepTime);
				}
			} else {
				System.out.println("processDelay itemProcessedTime => " + itemProcessedTime
						+ " avarageProcessTimeMillis => " + this.avarageProcessTimeMillis);
			}
		}

		this.checkPeriod();
	}

	private void processWait(long unitProcessedTime, int unitProcessedItemCount) {
		long timePassedInFrameMillis = this.calibratorFrame.getTimePassedInFrameMillis();
		long diffirence = this.frameTimeInMillis - timePassedInFrameMillis;
		long sleepTime = 0;
		if (diffirence > this.safePointMillis) {
			sleepTime = (this.frameTimeInMillis - timePassedInFrameMillis) - this.safePointMillis;
			this.sleep(sleepTime);
			this.calibratorFrame.sumWithWaitTimeInFrameMillis(sleepTime);
			this.calibratorFrame.sumWithTimePassedInFrameMillis(sleepTime);
		}

		this.finishFrame();
	}

	private void initiateFrame() {
		this.calibratorFrame.initiateFrame();
	}

	private void finishFrame() {
		System.out.println(this.calibratorFrame.finishFrame());
		this.calculateDelayTime();
		this.initiateFrame();
	}

	private void checkPeriod() {
		if (this.calibratorFrame.getTimePassedInFrameMillis() >= this.frameTimeInMillis) {
			if (this.maxProcessItemCount > this.calibratorFrame.getProcessedItemCount()
					&& this.calibratorFrame.getAdditionalDelayMillis() != 0) {
				System.out.println("Additional delay must be decreased.");
			} 
//			else {
//				this.calibratorFrame.setAdditionalDelayMillis(0);
//			}

			this.finishFrame();
		}
	}

	private void calculateDelayTime() {
		long waitTimeInFrameMillis = this.calibratorFrame.getWaitTimeInFrameMillis();
		int processedItemCount = this.calibratorFrame.getProcessedItemCount();
		if (waitTimeInFrameMillis > 0 || processedItemCount <= this.maxProcessItemCount) {
			long additionalTime = 0;
			long processedTime = waitTimeInFrameMillis == 0 ? this.frameTimeInMillis
					: this.frameTimeInMillis - waitTimeInFrameMillis;

			long avaregeItemProcessedTime = processedTime / processedItemCount;
			additionalTime = avaregeItemProcessedTime >= this.avarageProcessTimeMillis && waitTimeInFrameMillis <= 0
					? (this.avarageProcessTimeMillis - avaregeItemProcessedTime)
					: waitTimeInFrameMillis / processedItemCount;

			this.calibratorFrame.sumWithAdditionalDelayMillis(additionalTime);
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
}
