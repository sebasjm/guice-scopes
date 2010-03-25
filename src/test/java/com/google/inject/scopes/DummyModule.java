package com.google.inject.scopes;

import com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionImple;
import org.junit.Ignore;

import com.google.inject.AbstractModule;
import javax.transaction.Transaction;

@Ignore
public class DummyModule extends AbstractModule {

    protected void configure() {
        bind(DummyInJTAContext.class);
        bind(DummyInThreadContext.class);
    }
}
