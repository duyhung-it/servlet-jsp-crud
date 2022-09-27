package com.javaweb.dao;

import com.javaweb.model.NewModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewModel>{
    NewModel findOne(Long id);
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);
    void update(NewModel updateNew);

    List<NewModel> findAll(int offset, int limit);

    int getTotalItems();
}
