/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chess.outils;

import java.util.Calendar;

/**
 *
 * @author galbanie
 */
public class SyncLogIn {
    
    public synchronized static long getInstant(){
        return Calendar.getInstance().getTimeInMillis();
    }

    /*public static String getStrInstant() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmssS");
        return formater.format(getInstant());
    }*/
    
    
    /*public static void main(String[] arg){
        for(int i = 0; i<7; i++)
        //System.out.println(Calendar.getInstance().getTimeInMillis());
    }*/
    
    
}
