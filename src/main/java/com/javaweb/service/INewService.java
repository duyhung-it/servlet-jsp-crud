package com.javaweb.service;

import com.javaweb.model.NewModel;

import java.util.List;

public interface INewService {
    NewModel findOne(Long id);
    NewModel save(NewModel newModel);

    List<NewModel> findAll(int offset,int limit);
    int getTotalItems();
}
