package com.object.oriented.design.vending.machine.state;

import java.util.ArrayList;
import java.util.List;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.manager.VendingMachine;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Coin;
import com.object.oriented.design.vending.machine.model.Product;

public abstract class State {
	public enum Action {
		INSERTCOIN {

			@Override
			public State getState(VendingMachine vendingMachine) {
				return new InsertCoinState(vendingMachine);
			}

		},

		SELECTPRODUCT {

			@Override
			public State getState(VendingMachine vendingMachine) {
				return new SelectProductState(vendingMachine);
			}

		},

		PRESSBUTTON {

			@Override
			public State getState(VendingMachine vendingMachine) {
				return new PressButtonState(vendingMachine);
			}

		};

		public abstract State getState(VendingMachine vendingMachine);
	}

	protected VendingMachine vendingMachine;

	public State(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void insertCoin(Coin coin) {
		this.vendingMachine.addCoinToBudget(coin);
		this.vendingMachine.changeState(State.Action.SELECTPRODUCT);
	}

	public abstract void selectProduct(Product product) throws OutOfStockException, InsertCoinException;

	public List<Coin> refusedProcess() {
		List<Coin> changeList = new ArrayList<Coin>(this.vendingMachine.getBudget());
		this.vendingMachine.resetMachine();
		return changeList;
	}

	public abstract Bucket pressButton() throws InsufficientCoinException, InsertCoinException;
}
