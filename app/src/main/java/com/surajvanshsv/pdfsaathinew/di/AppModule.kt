package com.surajvanshsv.pdfsaathinew.di

import com.surajvanshsv.pdfsaathinew.data.repository.PdfRepositoryImpl
import com.surajvanshsv.pdfsaathinew.domain.repository.PdfRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePdfRepository(): PdfRepository {
        return PdfRepositoryImpl()
    }

}