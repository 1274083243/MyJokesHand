package joke.ike.com.myjokeshand.mvp.view;

import java.util.List;

import joke.ike.com.myjokeshand.model.dataModel.NewImageJokeModel;
import joke.ike.com.myjokeshand.model.dataModel.NewTextJokeModel;
import joke.ike.com.myjokeshand.ui.base.baseMvp.BaseView;

/**
 * 作者：ike
 * 时间：2017/1/22 11:49
 * 功能描述：首页图片笑话的view
 **/

public interface NewImageJokeFragmentView extends BaseView {

    void notifyDataChanged(List<NewImageJokeModel> models);

}
