package joke.ike.com.myjokeshand.mvp.view;

import java.util.List;

import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BaseView;

/**
 * 作者：ike
 * 时间：2017/1/22 11:49
 * 功能描述：首页文本笑话的view
 **/

public interface NewTextJokeFragmentView extends BaseView {

    void notifyDataChanged(List<NewTextJokeModel> models);

}
