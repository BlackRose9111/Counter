package com.blackrose.javaapp1;

import android.content.SharedPreferences;

public class DataManager {

    public static DataManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public DataManager(SharedPreferences pref, SharedPreferences.Editor ed){
        if (instance == null) {
            sharedPreferences = pref;
            editor = ed;
            instance = this;
        }

    }
    public static DataManager getInstance(){
        return instance;
    }
    public int getCounter(){

        return sharedPreferences.getInt("counter",0);


    }
    public int setCounter(int _new){
        editor.putInt("counter",_new);
        editor.apply();
        return _new;

    }
    //top limit, or if it exists
    public boolean getTopLimitExists(){
        return sharedPreferences.getBoolean("toplimitExists",false);

    }
    //make sure the keywords are the same on both sides, -Baran
    public boolean setTopLimitExists(boolean _new){
        editor.putBoolean("toplimitExists",_new);
        editor.apply();
        return  _new;
    }
    public int getTopLimit(){
        return sharedPreferences.getInt("toplimit",1000);

    }
    public int setTopLimit(int _new){
        editor.putInt("toplimit",_new);
        editor.apply();
        return _new;

    }
    //do the same for the bottom limit
    public boolean getBottomLimitExists(){

        return sharedPreferences.getBoolean("bottomlimitExists",false);

    }
    public boolean setBottomLimmitExists(boolean _new){
        editor.putBoolean("bottomlimitExists",_new);
        editor.apply();
        return  _new;
    }
    //
    public int getBottomLimit(){
        return sharedPreferences.getInt("bottomLimit",-1000);
    }
    public int setBottomLimit(int _new){
        editor.putInt("bottomLimit",_new);
        editor.apply();
        return _new;
    }

}
