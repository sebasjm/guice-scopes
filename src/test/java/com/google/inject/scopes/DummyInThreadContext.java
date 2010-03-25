package com.google.inject.scopes;

import com.google.inject.contexts.ThreadContext;
import com.google.inject.scopes.annotations.CustomScope;

@CustomScope(ThreadContext.class)
public class DummyInThreadContext {

}
