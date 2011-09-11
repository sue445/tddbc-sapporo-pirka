package tddbc.sapporo.controller.matcher;

// @javax.annotation.Generated
public class ConferenceroomPageMatcher extends scenic3.UrlMatcherImpl {

    private static final ConferenceroomPageMatcher INSTANCE = new ConferenceroomPageMatcher();
    /**
     * get a instance of this class.
     */
    public static ConferenceroomPageMatcher get() {
        return INSTANCE;
    }

    // Constructor.
    private ConferenceroomPageMatcher() {
        super("tddbc.sapporo.page.ConferenceroomPage", "/conferenceroom");
        super.add(new scenic3.UrlPattern("/conferenceroom", "list"), "tddbc.sapporo.controller.$conferenceroom._list");
    }


}
