package me.moallemi.kmpshowcase.shared.di

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import me.moallemi.kmpshowcase.shared.network.api.KmpShowcaseApi
import org.koin.dsl.module
import me.moallemi.kmpshowcase.shared.utils.log as kmpLog

internal val networkModule = module {
    single {
        HttpClient(this@single.get()) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(this@single.get())
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        kmpLog(message = message, tag = "ktor")
                    }
                }
                level = LogLevel.INFO
            }
        }
    }
    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
    single {
        KmpShowcaseApi(get())
    }
}