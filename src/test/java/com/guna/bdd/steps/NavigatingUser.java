package com.guna.bdd.steps;

import com.guna.bdd.model.Category;
import com.guna.bdd.ui.CategoryNavigationBar;
import com.guna.bdd.ui.CurrentPage;
import com.guna.bdd.ui.EbayHomePage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by GXP8655 on 4/11/2017.
 */
public class NavigatingUser {

    EbayHomePage ebayHomePage;
    CurrentPage currentPage;
    CategoryNavigationBar categoryNavigationBar;
    @Step
    public void isOnHomePage() {
        ebayHomePage.open();
    }

    @Step
    public void shouldSeePageTitleCOntaining(String expectedTitle) {
        assertThat(currentPage.getTitle()).containsIgnoringCase(expectedTitle);
    }
    @Step
    public void navigatesToCategory(Category category) {
        categoryNavigationBar.selectCategory(category);
    }
}
