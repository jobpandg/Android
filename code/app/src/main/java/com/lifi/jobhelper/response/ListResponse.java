package com.lifi.jobhelper.response;

import java.util.List;

public class ListResponse<T> extends BaseResponse {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public ListResponse setData(List<T> data) {
        this.data = data;
        return this;
    }

}
