package design_patterns.creational.factory;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public class ShoppingWebsite extends Website {

    @Override
    public void createWebsite() {
        addPage(new ShoppingCartPage());
        addPage(new ContacUsPage());
    }
}
