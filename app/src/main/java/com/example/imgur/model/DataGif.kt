package com.example.imgur.model

data class DataGif(
    val data: List<Data>?,
)

data class Data(
    val images: List<Image>?,
    val images_count: Int,
)

data class Image(
    val account_id: Any,
    val account_url: Any,
    val ad_type: Int,
    val ad_url: String,
    val animated: Boolean,
    val bandwidth: Long,
    val comment_count: Any,
    val datetime: Int,
    val description: String,
    val downs: Any,
    val edited: String,
    val favorite: Boolean,
    val favorite_count: Any,
    val gifv: String,
    val has_sound: Boolean,
    val height: Int,
    val hls: String,
    val id: String,
    val in_gallery: Boolean,
    val in_most_viral: Boolean,
    val is_ad: Boolean,
    val link: String,
    val mp4: String,
    val mp4_size: Int,
    val nsfw: Any,
    val points: Any,
    val score: Any,
    val section: Any,
    val size: Int,
    val tags: List<Any>,
    val title: Any,
    val type: String,
    val ups: Any,
    val views: Int,
    val vote: Any,
    val width: Int
)
