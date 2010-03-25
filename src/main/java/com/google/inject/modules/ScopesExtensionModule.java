package com.google.inject.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.scopes.ExtendedScope;
import com.google.inject.scopes.annotations.ThreadLocal;

public class ScopesExtensionModule extends AbstractModule {

    private ExtendedScope scope;

    @Inject
    public ScopesExtensionModule(ExtendedScope scope) {
        this.scope = scope;
    }

    @Override
    protected void configure() {
        bindScope(ThreadLocal.class, scope);
    }


}
