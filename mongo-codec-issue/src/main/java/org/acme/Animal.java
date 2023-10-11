package org.acme;

import org.bson.types.ObjectId;

public abstract class Animal<T> {
	public ObjectId id;
	public T value;
}
