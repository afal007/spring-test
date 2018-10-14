package me.afal.springboot;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

@WicketHomePage
public class IndexPage extends WebPage {
    public IndexPage() {
        add( new Label( "hello", "Hello, Wicket!" ) );
    }
}
