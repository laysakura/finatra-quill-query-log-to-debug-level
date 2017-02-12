package com.github.laysakura.quilldebuglog.modules

import com.github.laysakura.quilldebuglog.annotations.VerboseServiceServer
import com.google.inject.{Provides, Singleton}
import com.twitter.inject.TwitterModule

object VerboseServerModule extends TwitterModule {

  @Singleton
  @Provides
  @VerboseServiceServer
  def provide: String = "localhost:4000"
}
