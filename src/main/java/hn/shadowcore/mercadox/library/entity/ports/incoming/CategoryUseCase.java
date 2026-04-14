package hn.shadowcore.mercadox.library.entity.ports.incoming;

import hn.shadowcore.mercadox.library.entity.model.core.Category;

import java.util.List;

public interface CategoryUseCase {

    List<Category> findAll();

    Category findById(String categoryId);

    Category saveCategory(Category category);

    void deleteCategoryById(String categoryId);

}
