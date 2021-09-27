package com.gb.data.springdata.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class MarketError {

    public int status;
    public String message;
    public Date date;

    public MarketError(int status, String message){
        this.status = status;
        this.message = message;
        this.date = new Date();
    }
}
