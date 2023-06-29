package com.iv.data;

import com.iv.models.Category;
import com.iv.models.Product;

import java.util.List;

public interface CategoryDao
{
    List<Category> getAllCategories();
    Category getById(int categoryId);
    Category create(Category category);
    void update(int categoryId, Category category);
    void delete(int categoryId);
    List<Product> getProductsByCategoryId(int categoryId);
}