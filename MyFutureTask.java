package giant.mylibrary2;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by panda on 2017/6/25.
 */
public class MyFutureTask<T> extends FutureTask<T> {

    private CallbackDispatcher callbackDispatcher;

    public MyFutureTask(@NonNull Callable<T> callable) {
        super(callable);
    }

    public MyFutureTask(@NonNull Runnable runnable, T result) {
        super(runnable, result);
    }

    public MyFutureTask(Callable<T> callable, CallbackDispatcher<T> dispatcher) {
        super(callable);
        this.callbackDispatcher = dispatcher;
    }

    /**
     * Task is done,include task status:finish、cancel、exception.
     */
    @Override
    protected void done() {
        super.done();
        Log.e("tag", Thread.currentThread() + "  task is done! thread-name:" + Thread.currentThread().getName());
    }

    @Override
    protected void set(T t) {
        super.set(t);
        MainThreadExecutor.postToMainThread(t, callbackDispatcher);
    }

    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        MainThreadExecutor.postToMainThread(null, callbackDispatcher);
    }
}
