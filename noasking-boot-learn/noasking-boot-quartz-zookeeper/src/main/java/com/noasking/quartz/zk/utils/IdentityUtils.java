package com.noasking.quartz.zk.utils;

import java.util.UUID;

public class IdentityUtils {
	public static String generatorUUID(String name){
		return UUID.randomUUID().toString();
	}
}
