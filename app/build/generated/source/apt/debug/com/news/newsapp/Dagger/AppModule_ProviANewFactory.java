// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.news.newsapp.Dagger;

import com.news.newsapp.Data.New;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProviANewFactory implements Factory<New> {
  private final AppModule module;

  public AppModule_ProviANewFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public New get() {
    return Preconditions.checkNotNull(
        module.proviANew(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<New> create(AppModule module) {
    return new AppModule_ProviANewFactory(module);
  }
}
