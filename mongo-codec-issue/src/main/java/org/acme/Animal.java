package org.acme;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.types.ObjectId;

@BsonDiscriminator
public abstract class Animal<T> {
	public ObjectId id;
	public T value;
}
