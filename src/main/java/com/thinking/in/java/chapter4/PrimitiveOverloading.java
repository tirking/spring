package com.thinking.in.java.chapter4;

public class PrimitiveOverloading {

	
	void f1(char x){System.out.println("f1(char)");}
	void f1(byte x){System.out.println("f1(byte)");}
	void f1(short x){System.out.println("f1(short)");}
	void f1(int x){System.out.println("f1(int)");}
	void f1(long x){System.out.println("f1(long)");}
	void f1(float x){System.out.println("f1(float)");}
	void f1(double x){System.out.println("f1(double)");}
	
	void f2(byte x){System.out.println("f2(byte)");}
	void f2(short x){System.out.println("f2(short)");}
	void f2(int x){System.out.println("f2(int)");}
	void f2(long x){System.out.println("f2(long)");}
	void f2(float x){System.out.println("f2(float)");}
	void f2(double x){System.out.println("f2(double)");}
	
	void f3(short x){System.out.println("f3(short)");}
	void f3(int x){System.out.println("f3(int)");}
	void f3(long x){System.out.println("f3(long)");}
	void f3(float x){System.out.println("f3(float)");}
	void f3(double x){System.out.println("f3(double)");}
	
	void f4(int x){System.out.println("f4(int)");}
	void f4(long x){System.out.println("f4(long)");}
	void f4(float x){System.out.println("f4(float)");}
	void f4(double x){System.out.println("f4(double)");}
	
	void f5(long x){System.out.println("f5(long)");}
	void f5(float x){System.out.println("f5(float)");}
	void f5(double x){System.out.println("f5(double)");}
	
	void f6(float x){System.out.println("f6(float)");}
	void f6(double x){System.out.println("f6(double)");}
	
	void f7(double x){System.out.println("f7(double)");}
	
	public static void main(String[] args) {
		// test const val
		System.out.println("test const val");
		PrimitiveOverloading consTest = new PrimitiveOverloading();
		consTest.f1(5);consTest.f2(5);consTest.f3(5);consTest.f4(5);consTest.f5(5);consTest.f6(5);consTest.f7(5);
		
		// test char val
		System.out.println("test char val");
		PrimitiveOverloading charTest = new PrimitiveOverloading();
		char x = 'a';
		charTest.f1(x);charTest.f2(x);charTest.f3(x);charTest.f4(x);charTest.f5(x);charTest.f6(x);charTest.f7(x);
		
		// test  byte val 
		System.out.println("test byte val");
		PrimitiveOverloading byteTest = new PrimitiveOverloading();
		byte b = 0;
		byteTest.f1(b);byteTest.f2(b);byteTest.f3(b);byteTest.f4(b);byteTest.f5(b);byteTest.f6(b);byteTest.f7(b);
		
		// test  short val 
		System.out.println("test short val");
		PrimitiveOverloading shortTest = new PrimitiveOverloading();
		short s = 0;
		shortTest.f1(s);shortTest.f2(s);shortTest.f3(s);shortTest.f4(s);shortTest.f5(s);shortTest.f6(s);shortTest.f7(s);
		
		// test  int val 
		System.out.println("test int val");
		PrimitiveOverloading intTest = new PrimitiveOverloading();
		int i = 0;
		intTest.f1(i);intTest.f2(i);intTest.f3(i);intTest.f4(i);intTest.f5(i);intTest.f6(i);intTest.f7(i);
		
		// test  long val 
		System.out.println("test long val");
		PrimitiveOverloading longTest = new PrimitiveOverloading();
		long l = 0;
		longTest.f1(l);longTest.f2(l);longTest.f3(l);longTest.f4(l);longTest.f5(l);longTest.f6(l);longTest.f7(l);
		
		// test  float val 
		System.out.println("test float val");
		PrimitiveOverloading floatTest = new PrimitiveOverloading();
		float f = 0;
		floatTest.f1(f);floatTest.f2(f);floatTest.f3(f);floatTest.f4(f);floatTest.f5(f);floatTest.f6(f);floatTest.f7(f);
		
		// test  double val 
		System.out.println("test double val");
		PrimitiveOverloading doubleTest = new PrimitiveOverloading();
		double d = 0;
		doubleTest.f1(d);doubleTest.f2(d);doubleTest.f3(d);doubleTest.f4(d);doubleTest.f5(d);doubleTest.f6(d);doubleTest.f7(d);
		
	}

}
