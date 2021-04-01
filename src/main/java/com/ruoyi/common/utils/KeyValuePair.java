package com.ruoyi.common.utils;

@lombok.Getter
@lombok.Setter
public class KeyValuePair<K, V> {
	private K key;
	private V value;

	public KeyValuePair() {
	}

	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
