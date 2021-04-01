package com.ruoyi.common.utils;

@lombok.Getter
@lombok.Setter
public class IdNamePair<K, V> {
	private K id;
	private V name;
	private int sort;

	public IdNamePair() {
	}

	public IdNamePair(K id, V name) {
		this.id = id;
		this.name = name;
	}
	public IdNamePair(K id, V name, int sort) {
		this(id, name);
		this.sort = sort;
	}
}
