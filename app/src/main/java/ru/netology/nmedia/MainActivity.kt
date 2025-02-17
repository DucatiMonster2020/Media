package ru.netology.nmedia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityPageBinding
import ru.netology.nmedia.post.Post
import ru.netology.nmedia.post.countFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ActivityPageBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val post = Post(
                id = 1,
                author = "Нетология. Университет интернет-профессий будущего",
                published = "21 мая в 18:36",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
                likedByMe = false,
                sharedByMe = false,
                countLikes = 1000000,
                countShare = 1100,
                countView = 1300000
            )
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                countLikes.text = countFormat(post.countLikes)
                countShare.text = countFormat(post.countShare)
                countView.text = countFormat(post.countView)

                heart.setOnClickListener {
                    post.likedByMe = !post.likedByMe
                    heart.setImageResource(
                        if (post.likedByMe) R.drawable.liked_heart else R.drawable.heart_outline
                    )
                    if (post.likedByMe) post.countLikes++ else post.countLikes--
                    countLikes.text = post.countLikes.toString()
                }
                share.setOnClickListener {
                    post.sharedByMe = !post.sharedByMe
                    post.countShare++
                    countShare.text = post.countShare.toString()
                }
            }
        }
    }