package com.javaweb.mapper;

import com.javaweb.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel> {

    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel newModel = new NewModel();
        try {
            Long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            Long categoryId = resultSet.getLong("categoryid");
            newModel.setId(id);
            newModel.setTitle(title);
            newModel.setContent(content);
            newModel.setCategoryId(categoryId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newModel;
    }
}
