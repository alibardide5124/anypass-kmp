package io.spherelabs.data.local.repository

import io.spherelabs.accountdomain.repository.AccountRepository
import io.spherelabs.accountdomain.repository.AccountUserUi
import io.spherelabs.data.local.db.PasswordDao
import io.spherelabs.data.local.db.UserDao
import io.spherelabs.data.local.mapper.asDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DefaultAccountRepository(
    private val passwordDao: PasswordDao,
    private val userDao: UserDao,
) : AccountRepository {

    override fun getSizeOfStrongPasswords(): Flow<Int> {
        return passwordDao.getSizeOfStrongPasswords()
    }

    override fun getSizeOfWeakPasswords(): Flow<Int> {
        return passwordDao.getSizeOfWeakPasswords()
    }

    override fun getTotalPasswords(): Flow<Int> {
        return passwordDao.getTotalPasswords()
    }

    override fun getUser(): Flow<AccountUserUi> {
        return userDao.getUser().map { it.asDomain() }
    }
}
