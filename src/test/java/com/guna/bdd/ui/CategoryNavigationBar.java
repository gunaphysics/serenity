package com.guna.bdd.ui;

import com.guna.bdd.model.Category;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * Created by GXP8655 on 4/11/2017.
 */
public class CategoryNavigationBar extends PageObject{

    public void selectCategory(Category category) {
        $("*[role=navigation] *[role=list]").find(By.linkText(category.name())).click();
    }
}
