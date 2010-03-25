package com.google.inject.scopes.annotations;

import com.google.inject.Provider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.ScopeAnnotation;

@ScopeAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {

    public Class<? extends Provider> value();

}
