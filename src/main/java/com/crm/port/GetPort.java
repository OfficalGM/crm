package com.crm.port;

import java.util.List;

public interface GetPort<T> {

    List<T> findAll();

}
