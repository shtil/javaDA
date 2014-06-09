package ua.ks.shtil.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shtil on 04.06.14.
 */
public class Category {

    private String name;
    private Category category;

    private List<Category> categories = new ArrayList();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.setParent(parentCategory);
        parentCategory.addSubCategory(this);
    }

    public void addSubCategory(Category subCategory) {
        subCategory.setParent(this);
        subCategories.add(subCategory);
    }

    protected void setParent(Category parentCategory) {
        this.category = parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s;

        s = "Category: " + name + "\n ";
        if (subCategories.size() > 0) {


            s = s + "\tSubcategories of " + name + ":\n ";
            for (Category anCategory : subCategories) {
                s = s + "\t" + anCategory;
            }
            s = s + "\n\r";
        }
        return s;
    }
}
