/*
 * Copyright (c) Ashish , 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.repository.ClanRepository
import com.example.unidirectionalstateflow.domain.ErrorHandler
import com.example.unidirectionalstateflow.domain.ErrorHandlerImpl
import com.example.unidirectionalstateflow.domain.usecase.ClanListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun providesFetchClanUseCase(clanRepository: ClanRepository): ClanListUseCase =
        ClanListUseCase(clanRepository)

    @Provides
    fun providesErrorHandler(): ErrorHandler = ErrorHandlerImpl()
}