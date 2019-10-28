package com.object.oriented.design.vending.machine.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.object.oriented.design.vending.machine.model.Coin;
import com.object.oriented.design.vending.machine.storage.QantityStorege;

public class CoinUtil {

	public static int coinListSum(List<Coin> coinList) {
		return coinList.stream().mapToInt(x -> x.getDenomination()).reduce(0, Integer::sum);
	}

	public static List<Coin> calculateChange(int totalAmountOfChange, QantityStorege<Coin> coinStorage) {
		if (totalAmountOfChange <= 0) {
			return Collections.emptyList();
		}

		Coin coin = Coin.getCoinByValue(totalAmountOfChange);
		boolean hasItem = coinStorage.hasItem(coin);
		if (!hasItem) {
		}

		return Arrays.asList(coin);
	}
}
