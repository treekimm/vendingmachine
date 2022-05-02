package com.vendingmachine;

public class Item {
	private String name;
	private int price;
	private int quantity;
	
	public Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean isSoldOut() {
		return !(this.quantity > 0);
	}
	
	public boolean isSufficentBalance(int balance) {
		return balance >= this.price;
	}
	
	public void soldItem() {
		this.quantity = this.quantity-1;
	}
	
	public int itemPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
