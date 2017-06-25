package giant.mylibrary2;

import android.util.Log;

/**
 * Created by panda on 2017/6/25.
 */

public class MyCallbackDispatcher<T> implements CallbackDispatcher<T> {
    @Override
    public void dispatch(T t) {
        Log.e("tag", Thread.currentThread() + "  subthread is worked ok, return back\n\r");
    }
}
