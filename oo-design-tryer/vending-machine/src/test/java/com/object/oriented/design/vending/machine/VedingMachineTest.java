package com.object.oriented.design.vending.machine;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.object.oriented.design.vending.machine.exception.InsertCoinException;
import com.object.oriented.design.vending.machine.exception.InsufficientCoinException;
import com.object.oriented.design.vending.machine.exception.OutOfStockException;
import com.object.oriented.design.vending.machine.manager.VendingMachine;
import com.object.oriented.design.vending.machine.model.Bucket;
import com.object.oriented.design.vending.machine.model.Coin;
import com.object.oriented.design.vending.machine.model.Product;
import com.object.oriented.design.vending.machine.util.CoinUtil;

//// VedingMachine uygulması için oluşturulmuş test. Uygulama da state pattern kullanıyor.
//// Yani mikina içersinde yapılabilen temel functionaly 'ler state olarak tanımlanmış durumda.
//// Ana kodun detayına takılma. 
//// * Bazı senaryolar daha tamamlanmadı. *
// 
// Genel akış functionaly 'leri
// => para at
// => ürün seç
// => satın al buşuna bas
// => iptal tuşuna bas
//
// uygulamada 3 tip exception durumu mevcut
// => InsertCoinException = para atılmadan işlem yapılmaya çalışınca fırlatılıyor.
// => OutOfStockException = ürün kalmadıysa ve alınmaya çalışıyorsa fırlatılıyor. 
// => InsufficientCoinException = alınmak istene ürün için para yetersiz durumunda fırlatılıyor.
//
public class VedingMachineTest {

	private VendingMachine vendingMachine;

	
	// VendingMachine a test için veri dolduruluyor.
	@Before
	public void init() {
		this.vendingMachine = new VendingMachine();

		for (int i = 0; i < 3; i++) {
			this.vendingMachine.addCoinToMachine(Coin.DIME);
			this.vendingMachine.addCoinToMachine(Coin.NICKLE);
			this.vendingMachine.addCoinToMachine(Coin.PENNY);
			this.vendingMachine.addCoinToMachine(Coin.QUARTER);
		}

		for (int i = 0; i < 1; i++) {
			this.vendingMachine.addProduct(Product.CANDY);
			this.vendingMachine.addProduct(Product.COLA);
		}
	}

	// para atılmadan cola alınmaya çalışıldığında ne oluyor onu test ediyoruz.
	// bu durum da InsertCoinException fırlatılcak demiştik.
	// onu test ediyoruz.
	@Test(expected = InsertCoinException.class)
	public void testInsertFirtCoin() throws OutOfStockException, InsertCoinException{
		this.vendingMachine.selectProduct(Product.COLA);
	}
	
	// cola için yetersiz para atıldığı durum da ne oluyor.
	// beklentimiz InsufficientCoinException fırlatılması
	@Test(expected = InsufficientCoinException.class)
	public void testInsufficientCoin() throws OutOfStockException, InsufficientCoinException, InsertCoinException {
		this.vendingMachine.insertCoin(Coin.NICKLE);
		this.vendingMachine.selectProduct(Product.COLA);
		this.vendingMachine.pressButton();
	}

	// maikanaya test datası olarak bir tane cola eklendi.
	// 2 kere kola almaya çalışlıyor burda.
	// ilk satın alma başarılı olacak
	// 2. satın alma durumunda ne olacak
	// beklentimiz OutOfStockException fırlatılması.
	@Test(expected = OutOfStockException.class)
	public void testOutOfStock() throws OutOfStockException, InsufficientCoinException, InsertCoinException {

		this.vendingMachine.insertCoin(Coin.NICKLE);
		this.vendingMachine.insertCoin(Coin.DIME);
		this.vendingMachine.selectProduct(Product.COLA);
		Bucket bucket1 = this.vendingMachine.pressButton();
		assertThat(bucket1.getProduct(), equalTo(Product.COLA));
		assertThat(CoinUtil.coinListSum(bucket1.getChange()), equalTo(0));

		this.vendingMachine.insertCoin(Coin.NICKLE);
		this.vendingMachine.insertCoin(Coin.DIME);
		this.vendingMachine.selectProduct(Product.COLA);
	}

	// cola almak için fazladan para yatırılması durumunda beklentimiz
	// cola' yı almak ve para üstü almamız.
	// bunun için burda cola 'nın alındığı ve para üstünün olası gereken miktar şeklinde verildiği test ediliyor.
	@Test
	public void testRemaingCoin() throws OutOfStockException, InsufficientCoinException, InsertCoinException {

		this.vendingMachine.insertCoin(Coin.DIME);
		this.vendingMachine.insertCoin(Coin.DIME);
		this.vendingMachine.selectProduct(Product.COLA);
		Bucket bucket1 = this.vendingMachine.pressButton();
		assertThat(bucket1.getProduct(), equalTo(Product.COLA));
		assertThat(CoinUtil.coinListSum(bucket1.getChange()),
				equalTo(CoinUtil.coinListSum(Arrays.asList(Coin.NICKLE))));
	}

	// para attıkıtan sonra işlemi iptal etmek istediğimizde ne olcak.
	// eklentimiz atmış olduğumuz parayı bize iyade etmesi.
	@Test
	public void testRefuseMoney() {
		this.vendingMachine.insertCoin(Coin.DIME);
		this.vendingMachine.insertCoin(Coin.DIME);
		assertThat(CoinUtil.coinListSum(this.vendingMachine.refuse()),
				equalTo(CoinUtil.coinListSum(Arrays.asList(Coin.DIME, Coin.DIME))));
	}
}
