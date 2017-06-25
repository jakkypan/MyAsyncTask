package giant.mylibrary2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by panda on 2017/6/25.
 */
public class Entrance extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyExecutor.getExecutor()
                .execute(new MyFutureTask<Bitmap>(new MyCallable<Bitmap>(),
                        new MyCallbackDispatcher<Bitmap>()));
    }
}
