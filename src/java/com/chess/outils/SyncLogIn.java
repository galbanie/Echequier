/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author galbanie
 */
public class SyncLogIn {
    
    private static Date date;
    
    public static Date getInstant(){
        if (date == null) date = new Date();
        return date;
    }

    public static String getStrInstant() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmssS");
        return formater.format(getInstant());
    }
    
    
    
}
