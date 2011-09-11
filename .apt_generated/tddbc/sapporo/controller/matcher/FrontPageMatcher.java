package tddbc.sapporo.controller.matcher;

// @javax.annotation.Generated
public class FrontPageMatcher extends scenic3.UrlMatcherImpl {

    private static final FrontPageMatcher INSTANCE = new FrontPageMatcher();
    /**
     * get a instance of this class.
     */
    public static FrontPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private FrontPageMatcher() {
        super("tddbc.sapporo.page.FrontPage", "/");
        super.add(new scenic3.IndexUrlPattern("/"), "tddbc.sapporo.controller.$Index");
    }


}
