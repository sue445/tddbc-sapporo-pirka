package tddbc.sapporo.page;

import org.pirkaengine.slim3.PirkaPage;

public abstract class AbstractPirkaPage extends PirkaPage{
	/**
	 * テンプレートファイルの基準パス（war直下だとテンプレートファイルが外部から見えてしまうためWEB-INF配下に設置）
	 */
	protected static final String VIEW_PREFIX = "WEB-INF/view/";

}
