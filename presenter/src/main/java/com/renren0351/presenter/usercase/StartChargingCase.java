package com.renren0351.presenter.usercase;

import com.renren0351.model.dagger.ApiComponentHolder;
import com.renren0351.model.request.StartChargingRequest;
import com.renren0351.model.response.ChargingResponse;

import cn.com.leanvision.baseframe.model.usercase.UserCase;
import cn.com.leanvision.baseframe.rx.transformers.SchedulersCompat;
import rx.Observable;

/********************************
 * Created by lvshicheng on 2017/4/25.
 ********************************/
public class StartChargingCase extends UserCase<ChargingResponse, StartChargingRequest> {

  @Override
  public Observable<ChargingResponse> interactor(StartChargingRequest params) {
    return ApiComponentHolder.sApiComponent.apiService()
        .startCharging(params)
        .take(1)
        .compose(SchedulersCompat.<ChargingResponse>applyNewSchedulers());
  }
}
