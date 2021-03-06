// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.news.newsapp.Dagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideNewsApplicationFactory implements Factory<NewsApplication> {
  private final AppModule module;

  public AppModule_ProvideNewsApplicationFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public NewsApplication get() {
    return Preconditions.checkNotNull(
        module.provideNewsApplication(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NewsApplication> create(AppModule module) {
    return new AppModule_ProvideNewsApplicationFactory(module);
  }

  /** Proxies {@link AppModule#provideNewsApplication()}. */
  public static NewsApplication proxyProvideNewsApplication(AppModule instance) {
    return instance.provideNewsApplication();
  }
}
