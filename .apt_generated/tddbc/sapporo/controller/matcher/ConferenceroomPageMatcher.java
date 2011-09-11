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
        super.add(new scenic3.UrlPattern("/conferenceroom", "view/{key}"), "tddbc.sapporo.controller.$conferenceroom._view_key");
        super.add(new scenic3.UrlPattern("/conferenceroom", "edit/{key}"), "tddbc.sapporo.controller.$conferenceroom._edit_key");
        super.add(new scenic3.UrlPattern("/conferenceroom", "registerExecute"), "tddbc.sapporo.controller.$conferenceroom._registerExecute");
        super.add(new scenic3.UrlPattern("/conferenceroom", "register"), "tddbc.sapporo.controller.$conferenceroom._register");
        super.add(new scenic3.UrlPattern("/conferenceroom", "list"), "tddbc.sapporo.controller.$conferenceroom._list");
    }


}
