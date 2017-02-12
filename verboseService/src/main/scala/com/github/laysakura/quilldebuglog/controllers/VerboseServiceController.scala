package com.github.laysakura.quilldebuglog.controllers

import com.github.laysakura.quilldebuglog.idl
import com.github.laysakura.quilldebuglog.idl.VerboseService.Echo
import com.github.laysakura.quilldebuglog.services.UserService
import com.google.inject.{Inject, Singleton}
import com.twitter.finatra.thrift.Controller
import com.twitter.inject.Logging

@Singleton
class VerboseServiceController @Inject() (
  userService: UserService
)
  extends Controller
    with idl.VerboseService.BaseServiceIface
    with Logging
{
  override val echo = handle(Echo) { args =>
    info(s"""info!\n\tyou said "${args.message}"""")

    userService.getSirName(args.userId).map(sirName =>
      s"Hi $sirName, you said: ${args.message}"
    )
  }
}
