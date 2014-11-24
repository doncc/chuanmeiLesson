package com.chuanmei.l05usingjni;

public class People {
	
	public native String getName();
	public native int getAge();
	
	static{
		System.loadLibrary("L05UsingJNI");
	}

}
