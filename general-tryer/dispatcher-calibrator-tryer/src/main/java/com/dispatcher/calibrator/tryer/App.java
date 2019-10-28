package com.dispatcher.calibrator.tryer;

import java.util.concurrent.ThreadLocalRandom;

import com.dispatcher.calibrator.tryer.calibrator.DispatcherCalibrator;

public class App {
	private static final double min = 0.1;
	private static final double max = 0.3;

	public static void main(String[] args) {
		int counter = 0;
		DispatcherCalibrator dispatcherCalibrator = new DispatcherCalibrator(30000, 25);
		double minValue = min;
		double maxValue = max;
		while (true) {
			int itemCount = 2;
			counter++;
			if (counter > 200) {
				itemCount = getItemCount(counter);
			}
			
			if (counter >= 3000) {
				counter = 0;
				System.out.println("counter reseted.");
			}

			long delay = (long) (ThreadLocalRandom.current().nextDouble(minValue, maxValue) * 1000);
			dispatcherCalibrator.sleep(delay);
			dispatcherCalibrator.process(delay, itemCount);

		}
	}

	public static int getItemCount(int loopCount) {
		int value = 0;
		if (loopCount % 2 == 0) {
			value = 0;
		} else if (loopCount % 5 == 0) {
			value = 1;
		} else if (loopCount % 6 == 0) {
			value = ThreadLocalRandom.current().nextInt(0, 2);
		}

		return value;
	}
}
