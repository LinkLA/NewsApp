// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.news.newsapp.Dagger;

import com.news.newsapp.Contracts.Repository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.inject.Provider;

public final class PersistenceModule_ProvidesNewRepositoryFactory implements Factory<Repository> {
  private final PersistenceModule module;

  private final Provider<Realm> realmProvider;

  public PersistenceModule_ProvidesNewRepositoryFactory(
      PersistenceModule module, Provider<Realm> realmProvider) {
    assert module != null;
    this.module = module;
    assert realmProvider != null;
    this.realmProvider = realmProvider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.providesNewRepository(realmProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      PersistenceModule module, Provider<Realm> realmProvider) {
    return new PersistenceModule_ProvidesNewRepositoryFactory(module, realmProvider);
  }
}
