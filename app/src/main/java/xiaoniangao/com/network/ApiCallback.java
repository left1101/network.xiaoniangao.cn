package xiaoniangao.com.network;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

public abstract class ApiCallback<M> extends Subscriber<Result<M>> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public void onFinish() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(Result<M> model) {
        if (model.getRet() == 1) {
            onSuccess(model.getData());
        } else {
            onFailure(model.getMsg());
        }
    }

    @Override
    public void onCompleted() {
        onFinish();
    }
}
