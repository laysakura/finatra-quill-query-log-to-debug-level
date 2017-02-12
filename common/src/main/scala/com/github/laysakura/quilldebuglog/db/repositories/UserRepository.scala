package com.github.laysakura.quilldebuglog.db.repositories

import com.github.laysakura.quilldebuglog.db.dao.UserDao
import com.github.laysakura.quilldebuglog.db.models.User
import com.google.inject.{Inject, Singleton}
import com.twitter.util.Future

@Singleton
class UserRepository @Inject() (
  userDao: UserDao
) {
  def getUser(userId: Long): Future[User] = userDao.find(userId)
}
