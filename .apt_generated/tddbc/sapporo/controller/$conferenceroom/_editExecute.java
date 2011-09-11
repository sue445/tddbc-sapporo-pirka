package tddbc.sapporo.controller.$conferenceroom;

// Controller for tddbc.sapporo.page.ConferenceroomPage#editExecute
// @javax.annotation.Generated
public final class _editExecute extends scenic3.ScenicController {

    private final tddbc.sapporo.page.ConferenceroomPage page;

    public _editExecute() {
        this.page = new tddbc.sapporo.page.ConferenceroomPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.editExecute(asString("key", null), asString("version", null), asString("title", null), asString("capacity", null), asString("place", null));
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
        return "editExecute";
    }

}
