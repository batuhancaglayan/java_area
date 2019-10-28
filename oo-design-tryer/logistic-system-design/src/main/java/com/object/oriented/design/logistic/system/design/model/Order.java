package com.object.oriented.design.logistic.system.design.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Order {

	private UUID id = UUID.randomUUID();

	private @NonNull User sender;

	private @NonNull Location receiverLocation;

	private @NonNull List<Item> itemList;
}
