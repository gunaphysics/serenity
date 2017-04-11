package com.guna.bdd.ui;

import com.guna.bdd.model.Category;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;


/**
 * Created by GXP8655 on 4/11/2017.
 */
public class NavigateBar {

    public static Target category(Category category) {
       return Target.the(category.name())
               .locatedBy("*//td[@class='cat']/a[contains(text(),'{0}')]")
               .of(category.name());
    }
}
