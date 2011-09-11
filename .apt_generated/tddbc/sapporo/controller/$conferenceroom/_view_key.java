package tddbc.sapporo.controller.$conferenceroom;

// Controller for tddbc.sapporo.page.ConferenceroomPage#view
// @javax.annotation.Generated
public final class _view_key extends scenic3.ScenicController {

    private final tddbc.sapporo.page.ConferenceroomPage page;

    public _view_key() {
        this.page = new tddbc.sapporo.page.ConferenceroomPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.view(super.var("key"));
    }

    @Override
    public final tddbc.sapporo.page.ConferenceroomPage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "view";
    }

}
