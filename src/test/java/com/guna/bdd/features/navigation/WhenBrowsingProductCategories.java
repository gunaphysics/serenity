package com.guna.bdd.features.navigation;

import com.guna.bdd.model.Category;
import com.guna.bdd.steps.NavigatingUser;
import com.guna.bdd.tasks.NavigateTo;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.guna.bdd.model.Category.motor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by GXP8655 on 4/11/2017.
 */
@RunWith(SerenityRunner.class)
public class WhenBrowsingProductCategories {
    @Steps
    NavigatingUser mark;

    @Managed (driver = "chrome")
    WebDriver browser;

    @Test
    public void shouldBeAbleToNavigateToMotorsCategory(){
        //Given
        mark.isOnHomePage();
        //When
        mark.navigatesToCategory(motor);
        //Then
        mark.shouldSeePageTitleCOntaining("New & Used Cars");
    }


    @Test
    public void shouldBeAbleToViewMotorsCategory(){
        Actor mike = Actor.named("Mike");
        mike.can(BrowseTheWeb.with(browser));
        when(mike).attemptsTo(NavigateTo.theCategory(motor));
        then(mike).should(seeThat(TheWebPage.title(),containsString("New & Used cars")));

    }
}
