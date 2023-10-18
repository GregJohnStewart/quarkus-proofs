package org.acme;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator
public class Cat extends Animal<Integer> {
	public Cat(){
		this.value = 0;
	}
	
	public Cat(int value){
		this.value = value;
	}

}
