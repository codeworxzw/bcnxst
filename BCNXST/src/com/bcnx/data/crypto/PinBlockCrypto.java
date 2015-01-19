package com.bcnx.data.crypto;

public interface PinBlockCrypto {
	public String encrypt(String pinBlock) throws Exception;
	public String decrypt(String pinBlock) throws Exception;
}
