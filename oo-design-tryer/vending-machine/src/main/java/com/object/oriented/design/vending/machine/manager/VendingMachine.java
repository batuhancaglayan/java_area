package com.object.oriented.design.vending.machine.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Coin;
import com.object.oriented.design.vending.machine.model.Product;
import com.object.oriented.design.vending.machine.state.State;
import com.object.oriented.design.vending.machine.storage.QantityStorege;

import lombok.Getter;
import lombok.Setter;

public class VendingMachine {

	@Getter
	private QantityStorege<Product> productStock;

	@Getter
	private QantityStorege<Coin> coinStock;

	private Map<State.Action, State> stateMap;

	private State currentState;

	@Getter
	List<Coin> budget;

	@Getter
	@Setter
	Product selectedProduct;

	{
		this.stateMap = new HashMap<>();
		this.stateMap.put(State.Action.INSERTCOIN, State.Action.INSERTCOIN.getState(this));
		this.stateMap.put(State.Action.SELECTPRODUCT, State.Action.SELECTPRODUCT.getState(this));
		this.stateMap.put(State.Action.PRESSBUTTON, State.Action.PRESSBUTTON.getState(this));
		this.currentState = this.stateMap.get(State.Action.INSERTCOIN);
		this.budget = new ArrayList<>();
		this.productStock = new QantityStorege<>();
		this.coinStock = new QantityStorege<>();
	}

	public void addProduct(Product product) {
		this.productStock.increaseQantity(product);
	}

	public void addCoinToMachine(Coin coin) {
		this.coinStock.increaseQantity(coin);
	}

	public void addCoinToBudget(Coin coin) {
		this.budget.add(coin);
	}

	public void insertCoin(Coin coin) {
		this.currentState.insertCoin(coin);
	}

	public void selectProduct(Product product) throws OutOfStockException, InsertCoinException {
		this.currentState.selectProduct(product);
	}

	public List<Coin> refuse() {
		return this.currentState.refusedProcess();
	}

	public Bucket pressButton() throws InsufficientCoinException, InsertCoinException {
		return this.currentState.pressButton();
	}

	public void changeState(State.Action state) {
		this.currentState = this.stateMap.get(state);
	}

	public void resetMachine() {
		this.budget.clear();
		if (this.selectedProduct != null) {
			this.productStock.increaseQantity(this.selectedProduct);
			this.selectedProduct = null;
		}
		
		this.changeState(State.Action.INSERTCOIN);
	}
}
