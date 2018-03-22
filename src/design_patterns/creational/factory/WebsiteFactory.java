package design_patterns.creational.factory;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public class WebsiteFactory {

    public static Website getWebsite(WebsiteType type){
        switch (type){
            case BLOG:
                return new BlogWebsite();
            case SHOPPING:
                return new ShoppingWebsite();
            default:
                return null;
        }
    }

}
