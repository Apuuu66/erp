package com.kevin.entity;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/3
 */
public class State {
    private boolean success;
    private String message;

    public State(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
