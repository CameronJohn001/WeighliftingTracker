package com.example.cameron.weighliftingtracker;

public class LiftsDB {

    private int _id;
    private String _liftname;

    public LiftsDB(){
    }

    public LiftsDB(String liftname){
        this._liftname = liftname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_liftname(String _liftname) {
        this._liftname = _liftname;
    }

    public int get_id() {
        return _id;
    }

    public String get_liftname() {
        return _liftname;
    }

}