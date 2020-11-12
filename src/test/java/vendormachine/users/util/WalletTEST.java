package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTEST {
	
	//Resources
	public static Wallet testWallet;
	public static float startingCredit = 10;
	public static String setWalletBrand = "New Brand";
	
	//Test Tracker
	private static int activeTest =1;
	
	
	@BeforeAll
	public static void init() {
		testWallet = new Wallet();
		System.out.println("START");
		System.out.println("========================================");
	}
	
	@BeforeEach
	public void BeforeEach() {
		System.out.println("Resetting the Test Instance");
		testWallet = new Wallet(startingCredit);
		System.out.println("\t Staring Test " + activeTest);
		System.out.println("========================================");
		activeTest++;
	}
	
	@Test
	public void walletConstructionTest() {
		System.out.println("This test is for the plain Constructor");
		assertTrue(testWallet instanceof Wallet);
		System.out.println("========================================");
	}
	
	@Test
	public void walletOverloadConstrutorOneTest() {
		System.out.println("This is testing the credit parameter test");
		testWallet = new Wallet(startingCredit);
		assertTrue(testWallet instanceof Wallet);
		assertTrue(testWallet.getBrand().equals("Generic"));
		assertEquals(10.00f, testWallet.getAllCredit());
		System.out.println("========================================");
	}
	
	
	@Test
	public void walletOverloadConstrutorTwoTest() {
		testWallet = new Wallet("Test Brand", 20);
		System.out.println("This is testing the name and brand parameter");
		assertTrue(testWallet instanceof Wallet);
		assertTrue(testWallet.getBrand().equals("Test Brand"));
		assertEquals(20f, testWallet.getAllCredit());
	 }
	
	@Test
	public void addCreditTest() {
		testWallet.addCredit(50);
		assertEquals(60f, testWallet.getAllCredit());
	}
	
	@Test
	public void getCreditTest() {
		testWallet.getCredit(10);
		assertEquals(0, testWallet.getAllCredit());
	}
	
	@Test
	public void getCreditOverdraftTest() {
		testWallet.getCredit(50);
		assertEquals(startingCredit, testWallet.getAllCredit());
	}
	
	@Test
	public void setBrandTest() {
		testWallet.setBrand(setWalletBrand);
		assertEquals("New Brand", testWallet.getBrand());
	}
	
	@Test
	public void setCreditTest() {
		testWallet.setCredit(500);
		assertEquals(500f , testWallet.getAllCredit());
	}
	/** 
	 * Task 1:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.users.util.Wallet'
	 * 
	 * 		Goal: 80% code/line coverage
	 * */
	
	// Hint: 
	// Others Tests for other classes that use Wallet may impact code coverage
	// Avoid relying on these tests, one test for one class; keep "Single Responsibility" in mind.
	}
	
	

