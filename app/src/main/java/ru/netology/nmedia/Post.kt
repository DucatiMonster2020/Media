package ru.netology.nmedia.post

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var sharedByMe: Boolean,
    var countLikes: Long,
    var countShare: Long,
    var countView: Long
)
fun countFormat (count: Long): String {
    return when (count) {
        in 1000..1099 -> "${count / 100 / 10}K"
        in 1100..9999 -> "${count / 100 / 10.0}K"
        in 10000..999999 -> "${count / 100 / 10}K"
        in 1000000..1099999 -> "${count / 100000 / 10}M"
        in 1100000..Long.MAX_VALUE -> "${count / 100000 / 10.0}M"
        else -> count.toString()
    }
}