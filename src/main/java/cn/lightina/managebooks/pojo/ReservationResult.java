package cn.lightina.managebooks.pojo;

import lombok.Data;

@Data
public class ReservationResult<T> {
    private boolean success;
    T data;
    String error;

    public ReservationResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public ReservationResult(boolean success, T data) {

        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
