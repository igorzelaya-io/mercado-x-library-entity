package hn.shadowcore.mercadoxlibrary.entity.ports.incoming;

import hn.shadowcore.mercadoxlibrary.entity.model.core.Category;

import java.util.List;

public interface CategoryUseCase {

    List<Category> findAll();

    Category findById(String categoryId);

    Category saveCategory(Category category);

    void deleteCategoryById(String categoryId);

}
