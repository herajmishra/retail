package com.splus.learn.rest.enums;

import java.io.Serializable;

public enum Status implements Serializable {
	FAILED(0,"FAILED"),
	SUCCESS(1,"SUCCESS");
	private final int status;
    private final String description;

    Status(int aStatus, String desc){
        this.status = aStatus;
        this.description = desc;
    }
    public int status(){
        return this.status;
    }
    public String description(){
        return this.description;
    }
}
