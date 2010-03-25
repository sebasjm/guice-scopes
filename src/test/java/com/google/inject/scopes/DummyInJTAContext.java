package com.google.inject.scopes;

import com.google.inject.contexts.JTAContext;
import com.google.inject.scopes.annotations.CustomScope;

@CustomScope(JTAContext.class)
public class DummyInJTAContext {

}
