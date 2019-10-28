package com.spring.multithread.tryer.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.multithread.tryer.model.DenemeItem;

@Component
public class SomeProcess {

	public void doProcess(List<DenemeItem> denemeItemList) {
		for (DenemeItem denemeItem : denemeItemList) {
			denemeItem.setA(31321);
		}
	}
}
