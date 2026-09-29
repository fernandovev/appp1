package org.ucb.appp1.di

import org.koin.dsl.module
import org.ucb.appp1.crypto.data.datasource.CryptoRemoteDataSource
import org.ucb.appp1.crypto.data.repository.CryptoRepositoryImpl
import org.ucb.appp1.crypto.data.service.CryptoApiService
import org.ucb.appp1.crypto.domain.repository.CryptoRepository
import org.ucb.appp1.userinformation.data.datasource.GithubRemoteDataSource
import org.ucb.appp1.userinformation.data.repository.GithubRepositoryImpl
import org.ucb.appp1.userinformation.data.service.GitHubApiService
import org.ucb.appp1.userinformation.domain.repository.GithubRepository

val dataModule = module {
    single<GithubRemoteDataSource> { GitHubApiService() }
    single<GithubRepository> { GithubRepositoryImpl(get()) }

    single<CryptoRemoteDataSource> { CryptoApiService() }
    single<CryptoRepository> { CryptoRepositoryImpl(get()) }
}