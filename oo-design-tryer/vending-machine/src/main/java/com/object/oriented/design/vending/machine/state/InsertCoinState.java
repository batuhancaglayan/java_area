package com.object.oriented.design.vending.machine.state;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.manager.VendingMachine;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Coin;
import com.object.oriented.design.vending.machine.model.Product;

public class InsertCoinState extends State {

	InsertCoinState(VendingMachine vendingMachine) {
		super(vendingMachine);
	}

	@Override
	public void insertCoin(Coin coin) {
		this.vendingMachine.addCoinToBudget(coin);
		this.vendingMachine.changeState(State.Action.SELECTPRODUCT);
	}

	@Override
	public void selectProduct(Product product) throws OutOfStockException, InsertCoinException {
		this.vendingMachine.resetMachine();
		throw new InsertCoinException("Please insert coin first.");
	}
	
	@Override
	public Bucket pressButton() throws InsufficientCoinException, InsertCoinException {
		this.vendingMachine.resetMachine();
		throw new InsertCoinException("Please insert coin first.");
	}
}
