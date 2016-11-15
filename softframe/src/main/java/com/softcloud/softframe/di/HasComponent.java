package com.softcloud.softframe.di;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2016/11/15.
 */

public interface HasComponent<C extends BaseComponent> {
    C getComponent();
}
