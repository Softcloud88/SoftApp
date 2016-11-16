package com.softcloud.softframe.basepages;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/16.
 */

public interface ILifeCycleState {

    interface ICreate {
        boolean isCreated();
    }

    interface IStart {
        boolean isStarted();
    }

    interface IResume{
        boolean isResumed();
    }

    interface IPause {
        boolean isPaused();
    }

    interface IStop {
        boolean isStoped();
    }

    interface IDestroy {
        boolean isDestroyed();
    }

}
