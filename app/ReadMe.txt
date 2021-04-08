
1.
Isolate* isolate = SETUP(env, v8RuntimePtr, 0)
展开为：
    Isolate *isolate = getIsolate(env, v8RuntimePtr);
    if (isolate == nullptr) {
        return errorReturnResult;
    }
    V8Runtime *runtime = reinterpret_cast<V8Runtime *>(v8RuntimePtr);
    Isolate::Scope isolateScope(isolate);
    HandleScope handle_scope(isolate);
    Local <Context> context = Local<Context>::New(isolate, runtime->context_);
    Context::Scope context_scope(context);