package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

import java.util.ArrayList;

/**
 * Created by shtil on 04.06.14.
 */

public class Category {
    protected String name;
    protected Category parentCategory;
    protected ArrayList<Category> subCategories = new ArrayList();

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

    public void addSubCategory(Category subCategory){
        subCategory.setParent(this);
        subCategories.add(subCategory);
    }

    protected void setParent(Category parentCategory){
        this.parentCategory = parentCategory;
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

      /*  s = "Category: " + name +"\n ";
        if (subCategories.size()>0) {
            s = s + "\tSubcategories of "+name+":\n ";
            for (Category anCategory : subCategories) {
                s = s + "\t"+anCategory;
            }
            s = s+"\n\r";
        }*/
        return name;
    }
}

/*public class Category {


    private String name;
    private Category parentCategory;

    private List<Category> categories = new ArrayList();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        parentCategory = null;
        categories.add(this);
    }

    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
        categories.add(this);
    }

    public void addSubCategory(String name) {
        this.name = name;
        this.parentCategory = this;
        categories.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String result = "";

        for (Category category : categories) {
            if (category.parentCategory != null) {
                result = result + category.getName();
            } else {
                // category.toString();
            }
        }


        return
                "Category{" +
                        "name='" + name + '\'' +
                        ", parentCategory=" + parentCategory +
                        ", categories=" + categories +
                        '}';
    }
}
*/