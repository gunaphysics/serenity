package com.guna.bdd.tasks;

import com.guna.bdd.model.Category;
import com.guna.bdd.ui.EbayHomePage;
import com.guna.bdd.ui.NavigateBar;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

/**
 * Created by GXP8655 on 4/11/2017.
 */
public class NavigateTo implements Task {


    private Category category;
    private EbayHomePage theEbayHomePage;
    public NavigateTo(Category category) {

        this.category = category;
    }

    @Override
    @Step("{0} navigates to the #category category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(theEbayHomePage),
                Click.on(NavigateBar.category(category))
        );

    }

    public static Performable theCategory(Category category) {
        return Instrumented.instanceOf(NavigateTo.class).withProperties(category);
    }
}
