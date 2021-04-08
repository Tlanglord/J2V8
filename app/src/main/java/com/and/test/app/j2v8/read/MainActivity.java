package com.and.test.app.j2v8.read;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.ReferenceHandler;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.V8Runnable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        V8 v8Runtime = V8.createV8Runtime();

        v8Runtime.addReleaseHandler(new V8Runnable() {
            @Override
            public void run(V8 runtime) {

            }
        });
        V8Object v8Object = new V8Object(v8Runtime);
        v8Object.registerJavaMethod(new JavaCallback() {
            @Override
            public Object invoke(V8Object receiver, V8Array parameters) {
                return null;
            }
        }, "call");
        v8Runtime.add("UI", v8Object);
        v8Runtime.addReferenceHandler(new ReferenceHandler() {
            @Override
            public void v8HandleCreated(V8Value object) {

            }

            @Override
            public void v8HandleDisposed(V8Value object) {

            }
        });
    }
}