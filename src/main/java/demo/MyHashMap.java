package demo;

import java.util.ArrayList;

public class MyHashMap {

private class Data{
	int key; 
	int value;
	public Data(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public boolean equals(Object other) {
		if(other instanceof Data) {
			return this.key==((Data)other).key;
			
		}return false;
	}
}

private final int SIZE=1000;
private ArrayList<Data> myBuckets[];
	public MyHashMap() {
		myBuckets=new ArrayList[SIZE];
		for(int i=0;i<myBuckets.length;i++) {
			myBuckets[i]=new ArrayList<>();
		}
	}
	private int hasFunction(int key) {
		return key%SIZE;
	}
	public void put(int key,int value) {
		int hashValueIndex=hasFunction(key);
		ArrayList<Data> bucket=myBuckets[hashValueIndex];
		Data temp=new Data(key,value);
		int keyIndex=bucket.indexOf(temp);
		if(keyIndex >=0) {
			bucket.get(keyIndex).value=value;
		}else {
			bucket.add(temp);
		}
	}
	public void remove(int key) {
		 int hashValueIndex=hasFunction(key);
		 ArrayList<Data> bucket=myBuckets[hashValueIndex];
		 Data temp=new Data(key,0);
		 bucket.remove(temp);
	}
	public int get(int key) {
		int hashValueIndex=hasFunction(key);
		ArrayList<Data> bucket=myBuckets[hashValueIndex];
		Data temp=new Data(key,0);
		int keyIndex=bucket.indexOf(temp);
		if(keyIndex>=0) {
			return bucket.get(keyIndex).value;
		}
		return -1;
	}
}
