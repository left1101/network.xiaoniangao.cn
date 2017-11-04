package xiaoniangao.com;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import xiaoniangao.com.network.ApiCallback;
import xiaoniangao.com.network.ApiStores;
import xiaoniangao.com.network.AppClient;
import xiaoniangao.com.network.NetWork;

public class MainActivity extends Activity {

    private TextView tv;
    private ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.txt);

        Map<String, String> map = new HashMap<>();

        map.put("code_ver", "1.7.9");
        map.put("limit", "20");
        map.put("proj", "in");
        map.put("qs", "imageMogr2/gravity/center/rotate/$/thumbnail/!224x166r/crop/224x166/interlace/1/format/jpg");
        map.put("quality_qs", "imageMogr2/gravity/center/rotate/$/thumbnail/!750x500r/crop/750x500/interlace/1/format/jpg");
        map.put("start_t", "-1");
        map.put("token", "52e85e13-ac49-4d79-bcc4-e180c235b335");

//        map.put("token", "1e093181668c76676cfe2fc53e66c004");
//        map.put("uid", "52e85e13-ac49-4d79-bcc4-e180c235b335");
//        map.put("qs", "imageMogr2/gravity/center/rotate/$/thumbnail/!180x140r/crop/180x140/interlace/1/format/jpg");
//        map.put("start_t", -1);
//        map.put("limit", 20);
//        map.put("code_ver", "1.7.9");
//        map.put("proj", "ma");

//        NetWork.getInstance().addSubscription(apiStores.getFeature(map), new ApiCallback() {
//            @Override
//            public void onSuccess(Object model) {
//                Log.i("luke", model.toString());
//                tv.setText(model.toString());
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                Log.i("luke", msg);
//            }
//        });

        NetWork.getInstance().addSubscription(apiStores.getFeature(map), new ApiCallback<Object>() {
            @Override
            public void onSuccess(Object model) {
                Log.i("luke", model.toString());
            }

            @Override
            public void onFailure(String msg) {
                Log.i("luke", msg);
            }
        });

//        NetWork.getInstance().addSubscription(apiStores.getFeature(map), new ApiCallback<Object>() {
//            @Override
//            public void onSuccess(Object model) {
//                Log.i("luke", model.toString());
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                Log.i("luke", msg);
//            }
//        });

//        apiStores.getFeature(map).subscribeOn(Schedulers.io()).subscribe(new Action1<Result<Object>>() {
//            @Override
//            public void call(Result<Object> objectResult) {
//
//            }
//        });


    }


}
