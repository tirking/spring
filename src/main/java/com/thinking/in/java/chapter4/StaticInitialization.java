package com.thinking.in.java.chapter4;

class Bowl {
	public Bowl(String marker) {
		System.out.println("Bowl(" + marker + ")");
	}

	public void f(String marker) {
		System.out.println("bowl.f(" + marker + ")");
	}
}

class Table {
	static Bowl tableBowl1 = new Bowl("table.static.bowl1");
	static Bowl tableBowl2 = new Bowl("table.static.bowl2");

	public Table() {
		System.out.println("Table()");
		tableBowl2.f("table.1");
	}

	public void f(String marker) {
		System.out.println("table.f(" + marker + ")");
	}
}

class Cupboard {
	Bowl cupBowl1 = new Bowl("cupboard.bowl1");
	static Bowl cupBowl2 = new Bowl("cupboard.static.bowl2");
	static Bowl cupBowl3 = new Bowl("cupboard.static.bowl3");

	public Cupboard() {
		System.out.println("Cupboard()");
		cupBowl2.f("cupboard.1");
	}

	public void f(String marker) {
		System.out.println("cupboard.f(" + marker + ")");
	}
}

public class StaticInitialization {

	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();

	public static void main(String[] args) {
		System.out.println("create new Cupboard() in main");
		new Cupboard();
		System.out.println("create new Cupboard() in main");
		new Cupboard();

		table.f("1");
		cupboard.f("1");

		// Table.tableBowl1.f("1"); 直接引用也会初始化。

		// Bowl(table.static.bowl1)
		// Bowl(table.static.bowl2)
		// Table()
		// bowl.f(table.1)

		// Bowl(cupboard.static.bowl2) 会先初始化静态变量
		// Bowl(cupboard.static.bowl3)
		// Bowl(cupboard.bowl1)
		// Cupboard()
		// bowl.f(cupboard.1)

		// create new Cupboard() in main
		// 前面初始化静态变量，这里就不在初始化静态变量；如果之前没初始化过静态变量，这里会初始化。
		// Bowl(cupboard.bowl1)
		// Cupboard()
		// bowl.f(cupboard.1)
		// create new Cupboard() in main
		// Bowl(cupboard.bowl1)
		// Cupboard()
		// bowl.f(cupboard.1)
		// table.f(1)
		// cupboard.f(1)

	}

}
