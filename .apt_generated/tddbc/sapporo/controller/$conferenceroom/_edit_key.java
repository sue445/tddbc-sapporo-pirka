package tddbc.sapporo.controller.$conferenceroom;

// Controller for tddbc.sapporo.page.ConferenceroomPage#edit
// @javax.annotation.Generated
public final class _edit_key extends scenic3.ScenicController {

    private final tddbc.sapporo.page.ConferenceroomPage page;

    public _edit_key() {
        this.page = new tddbc.sapporo.page.ConferenceroomPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.edit(super.var("key"));
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
        return "edit";
    }

}
