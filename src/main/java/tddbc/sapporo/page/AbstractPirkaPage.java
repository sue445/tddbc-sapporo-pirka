package tddbc.sapporo.page;

import org.pirkaengine.slim3.PirkaPage;

public abstract class AbstractPirkaPage extends PirkaPage{
	/**
	 * テンプレートファイルの基準パス（war直下だとテンプレートファイルが外部から見えてしまうためWEB-INF配下に設置）
	 */
	protected static final String VIEW_PREFIX = "WEB-INF/view/";

	/**
	 * viewModelから値を取得する(テストケースから取得するためにオーバーライド)
	 */
	@Override
	public <T> T viewModel(String key) {
		return super.viewModel(key);
	}
}
