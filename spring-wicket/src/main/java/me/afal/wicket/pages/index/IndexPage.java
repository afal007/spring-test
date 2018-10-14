package me.afal.wicket.pages.index;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class IndexPage extends WebPage {
    public IndexPage() {
        add( new Label( "hello", "Hello, Wicket!" ) );

    }
}
