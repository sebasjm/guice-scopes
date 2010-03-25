
package com.google.inject.modules;

import com.google.inject.AbstractModule;
import com.google.inject.contexts.ContextManager;
import com.google.inject.contexts.ThreadContext;
import com.google.inject.scopes.ExtendedScope;
import com.google.inject.scopes.ContextBasedScope;

/**
 *
 * @author sebasjm at computer dot org
 */
public class ContextExtensionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ContextManager.class).to(ThreadContext.class);
        bind(ExtendedScope.class).to(ContextBasedScope.class);
    }

}
