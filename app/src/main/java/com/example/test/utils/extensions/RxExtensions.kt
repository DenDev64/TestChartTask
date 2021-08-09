package com.example.test.utils.extensions

import io.reactivex.Single

fun <T : Any> T.asSingle(): Single<T> = Single.just(this)