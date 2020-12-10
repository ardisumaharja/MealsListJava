package com.infogramtelemedia.foodlist.BaseAndContract;

public interface ActivityContract {

    interface BaseActivityView<T extends BasePresenter>{
        void setPresenter(T t);
    }

    public static abstract class BasePresenter<T extends BaseActivityView>{
        Object cancelSign = new Object();
        public T mActivity;
        public BasePresenter(T t) {
            this.mActivity = t;
        }
        public void onDetachActivity(){ // untuk melepaskan activity ?
            this.mActivity = null;
            this.cancelSign = null;
        }
    }

}
