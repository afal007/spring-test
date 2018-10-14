package me.afal.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import me.afal.wicket.pages.index.IndexPage;

public class HelloWicketApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return IndexPage.class;
    }
}


