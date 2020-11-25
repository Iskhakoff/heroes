package com.iskhakoff.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class Hero(val id: Int, val img: String, val localized_name: String, val primary_attr: String, val attack_type: String)