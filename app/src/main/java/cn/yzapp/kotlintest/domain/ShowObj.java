package cn.yzapp.kotlintest.domain;

import android.util.Log;

import com.google.gson.Gson;

/**
 * @author: GuSiheng
 */
public class ShowObj<T> {
    private final T obj;
    private final Gson gson;

    ShowObj(T obj) {
        this.obj = obj;
        this.gson = new Gson();
        Log.d(getClass().getSimpleName(), obj.toString());
    }

    ShowObj(T obj, Gson gson) {
        this.obj = obj;
        this.gson = gson;
        Log.d(getClass().getSimpleName(), obj.toString());
    }

    public String show() {
        return gson.toJson(obj);
    }
}
