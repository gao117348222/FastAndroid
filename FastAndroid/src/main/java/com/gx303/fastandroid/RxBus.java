package com.gx303.fastandroid;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * 使用RxJava来做总线通知
 * 使用方法
通知: _rxBus.send(new TapEvent());
监听:
 _rxBus.toObserverable()
     .subscribe(new Action1<Object>() {
        @Override
        public void call(Object event) {
            if(event instanceof TapEvent) {
            _showTapText();
        }else if(event instanceof SomeOtherEvent)
            {
              _doSomethingElse();
            }
        }
    });



 */
public class RxBus {
    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return _bus;
    }
}
