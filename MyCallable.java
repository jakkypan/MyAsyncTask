package giant.mylibrary2;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * Created by panda on 2017/6/25.
 */
public class MyCallable<T> implements Callable<T> {

    @Override
    public T call() throws Exception {
        Log.e("tag", Thread.currentThread() + "  do subthread thing...");
        return null;
    }
}
