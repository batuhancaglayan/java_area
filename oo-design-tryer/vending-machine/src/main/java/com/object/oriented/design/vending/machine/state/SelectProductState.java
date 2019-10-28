package com.object.oriented.design.vending.machine.state;

import java.util.Collections;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.manager.VendingMachine;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Product;

public class SelectProductState extends State {

	SelectProductState(VendingMachine vendingMachine) {
		super(vendingMachine);
	}

	@Override
	public void selectProduct(Product product) throws OutOfStockException, InsertCoinException {

		Product existProduct = this.vendingMachine.getProductStock().getItem(product);
		if (existProduct == null) {
			throw new OutOfStockException("Product is out of stock.");
		}

		this.vendingMachine.setSelectedProduct(existProduct);
		this.vendingMachine.changeState(State.Action.PRESSBUTTON);
	}

	@Override
	public Bucket pressButton() throws InsufficientCoinException, InsertCoinException {
		return new Bucket(null, Collections.emptyList());
	}
}
