package com.crm.port;

import com.crm.core.vo.Company;

import java.util.List;

public interface StorePort<T> {

    T save(T t);


    boolean save(List<T> list);
    //TODO save all
}
