package design_patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public abstract class Website {

    private List<Page> pages = new ArrayList<>();

    public abstract void createWebsite();

    public Website(){
        this.createWebsite();
    }

    public List<Page> getPages(){
        return pages;
    }

    public void addPage(Page page){
        pages.add(page);
    }

}
