package design_patterns.creational.factory;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public class BlogWebsite extends Website {
    @Override
    public void createWebsite() {
        addPage(new BlogPage());
        addPage(new ContacUsPage());
    }
}
