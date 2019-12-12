package com.lucas.mp.demo.vo.response;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxu
 */
@Data
public class PageResult<T> {

    private int total;
    private List<T> results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getResults() {
        if(results == null){
            return new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public PageResult(int total, List<T> results) {
        this.total = total;
        this.results = results;
    }

    public PageResult() {
    }
}
