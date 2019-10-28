package com.object.oriented.design.logistic.system.design.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {

	private UUID id = UUID.randomUUID();

	private @NonNull String itemName;

	private @NonNull double price;
}
