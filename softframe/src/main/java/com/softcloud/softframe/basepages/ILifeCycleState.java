package com.softcloud.softframe.basepages;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public interface ILifeCycleState {

    interface ICreate {
        boolean isPageCreated();
    }

    interface IStart {
        boolean isPageStarted();
    }

    interface IResume{
        boolean isPageResumed();
    }

    interface IPause {
        boolean isPagePaused();
    }

    interface IStop {
        boolean isPageStoped();
    }

    interface IDestroy {
        boolean isPageDestroyed();
    }

}
