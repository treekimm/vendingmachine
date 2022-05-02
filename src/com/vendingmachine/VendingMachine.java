package com.vendingmachine;

import java.util.List;

public class VendingMachine {
	private List<Item> itemList;
	private int balance;
	private MachineAction action;
	private MachineState state;
	
	public VendingMachine(List<Item> itemList) {
		this.itemList = itemList;
		this.balance = 0;
	}
	
	public void showItemsState() {
		int number = 1;
		for(Item item : itemList) {
			System.out.println("no : " + number++ + "" + item.toString());
		}
		System.out.println("현재 잔액 : " + this.balance);
	}
	
	public void showMenu() {
		System.out.println("1.돈넣기\t2.상품선택\t3.잔돈 반환");
	}
	
	public void insertMoney(int money) {
		this.action = MachineAction.INSERT_MONEY;
		calcBalance(money);
	}
	
	public void returnMoney() {
		this.action = MachineAction.RETURN_BALANCE;
		calcBalance(0);
	}
	
	public void selectItem(int no) {
		if(itemList.size()-1 >= no) {
			this.action = MachineAction.SELECT_ITEM;
			Item selectedItem = this.itemList.get(no);
			
			if(selectedItem.isSoldOut()) {
				this.state = MachineState.SOLD_OUT;
				System.out.println("해당 제품은 품절입니다.");
			} else if (selectedItem.isSufficentBalance(this.balance)) {
				this.state = MachineState.OK;
			} else {
				this.state = MachineState.BALANCE_INSUFFICIENT;
				System.out.println("금액이 부족합니다.");
			}
			
			purchaseItem(this.itemList.get(no));
		} else {
			System.out.println("잘못된 상품 번호입니다.");
		}
		
	}
	
	private void purchaseItem(Item item) {
		if(this.state == MachineState.OK) {
			item.soldItem();
			calcBalance(item.itemPrice());
		} else {
			System.out.println("구매가 불가합니다.");
		}
	}
	
	private void calcBalance(int money) {
		if(action == MachineAction.INSERT_MONEY) {
			this.balance = this.balance + money; 
		}
		
		if(action == MachineAction.RETURN_BALANCE) {
			this.balance = 0;
		}
		
		if(action == MachineAction.SELECT_ITEM) {
			this.balance = this.balance - money;
		}
	}
}
