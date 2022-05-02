package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vendingmachine.Item;
import com.vendingmachine.VendingMachine;

public class Main {

	final static String MENU_INSERT_COIN = "1";
	final static String MENU_SELECT_ITEM = "2";
	final static String MENU_RETURN_BALANCE = "3";
	
	public static void main(String[] args) {
		
		List<Item> itemList = new ArrayList<Item>();
		Scanner sc = new Scanner(System.in);
		
		Item item1 = new Item("콜라", 1500, 100) ;
		Item item2 = new Item("사이다", 1500, 100) ;
		Item item3 = new Item("오렌지 주스", 1000, 100) ;
		Item item4 = new Item("핫식스", 1200, 100) ;
		
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		
		VendingMachine machine = new VendingMachine(itemList);

		while(true) {
			String selectNo = "";

			machine.showItemsState();
			machine.showMenu();
			System.out.print("메뉴를 선택해 주세요.");
			String menu = sc.next();
			
			if(MENU_INSERT_COIN.equals(menu)) {
				
				System.out.print("금액을 투입하세요");
				String money = sc.next();
				machine.insertMoney(Integer.parseInt(money));
				
			} else if(MENU_SELECT_ITEM.equals(menu)) {
				
				machine.showItemsState();
				System.out.println("상품을 no를 선택해 주세요 ");
				selectNo = sc.next();
				machine.selectItem(Integer.parseInt(selectNo)-1);
				
			} else if(MENU_RETURN_BALANCE.equals(menu)) {
				
				machine.returnMoney();
				
			} else {
				
				System.out.println("잘못된 입력입니다.");
				
			}
			
			System.out.println("\n\n");
		}
	}

}
