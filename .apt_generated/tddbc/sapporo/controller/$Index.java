package tddbc.sapporo.controller;

// Controller for tddbc.sapporo.page.FrontPage#index
// @javax.annotation.Generated
public final class $Index extends scenic3.ScenicController {

    private final tddbc.sapporo.page.FrontPage page;

    public $Index() {
        this.page = new tddbc.sapporo.page.FrontPage();
    }

    @Override
    public final org.slim3.controller.Navigation setUp() {
        setupPage(page);
        return super.setUp();
    }

    @Override
    public final org.slim3.controller.Navigation run() throws Exception {
        return page.index();
    }

    @Override
    public final tddbc.sapporo.page.FrontPage getPage() {
        return this.page;
    }

    @Override
    protected final org.slim3.controller.Navigation handleError(Throwable error) throws Throwable {
        return page.handleError(error);
    }

    @Override
    public final String getActionMethodName() {
        return "index";
    }

}
