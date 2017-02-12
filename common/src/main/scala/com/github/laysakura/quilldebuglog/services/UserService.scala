package com.github.laysakura.quilldebuglog.services

import com.github.laysakura.quilldebuglog.db.repositories.UserRepository
import com.google.inject.{Inject, Singleton}
import com.github.laysakura.quilldebuglog.domain.values.User
import com.twitter.util.Future

@Singleton
class UserService @Inject() (
  userRepo: UserRepository
) {
  def getSirName(userId: Long): Future[String] =
    userRepo.getUser(userId).map(User.fromModel(_).getSirName)

}
