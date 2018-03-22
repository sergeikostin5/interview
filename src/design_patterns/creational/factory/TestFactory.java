package design_patterns.creational.factory;

/**
 * Created by sergei.kostin on 2/27/18.
 */
public class TestFactory {

    public static void main(String[] args) {
        Website blog = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        Website shopping = WebsiteFactory.getWebsite(WebsiteType.SHOPPING);
        System.out.println(blog.getPages());
        System.out.println(shopping.getPages());
    }
}
