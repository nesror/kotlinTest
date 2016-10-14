package cn.yzapp.kotlintest.domain;

import com.google.gson.Gson;

/**
 * @author: GuSiheng
 * @time: 10/12 012-12:02.
 * @email: gusiheng@qccr.com
 * @desc:
 */
public class ShowObj<T> {
    private final T obj;
    private final Gson gson;

    ShowObj(T obj) {
        this.obj = obj;
        this.gson = new Gson();
    }

    ShowObj(T obj, Gson gson) {
        this.obj = obj;
        this.gson = gson;
    }

    public String show() {
        return gson.toJson(obj);
    }
}
