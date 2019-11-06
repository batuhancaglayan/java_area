package com.object.oriented.design.vending.machine.state;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.manager.VendingMachine;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Product;
import com.object.oriented.design.vending.machine.util.CoinUtil;

public class PressButtonState extends State {

	PressButtonState(VendingMachine vendingMachine) {
		super(vendingMachine);
	}

	@Override
	public void selectProduct(Product prodcut) throws OutOfStockException, InsertCoinException {
	}

	@Override
	public Bucket pressButton() throws InsufficientCoinException, InsertCoinException {

		Integer coinSum = this.vendingMachine.getBudget().stream().mapToInt(x -> x.getDenomination()).reduce(0,
				Integer::sum);
		int remaining = coinSum - this.vendingMachine.getSelectedProduct().getPrice();
		if (remaining < 0) {
			throw new InsufficientCoinException("More coin need for this product");
		}

		Bucket bucket = new Bucket(this.vendingMachine.getSelectedProduct(),
				CoinUtil.calculateChange(remaining, this.vendingMachine.getCoinStock()));
		
		this.vendingMachine.setSelectedProduct(null);
		this.vendingMachine.resetMachine();
		return bucket;
	}
}
