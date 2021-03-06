package samples.comment

import bot.InstagramBot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main() {

    val username = "your_instagram_username"
    val password = "your_instagram_password"

    val bot = InstagramBot()
    bot.prepare(username)
    bot.login(username, password)

    val hashTagName = "enter_hashtag_name_here"
    val commentList = listOf("Comment 1", "Comment 2")
    val howManyMediasYouWantToComment = 10

    runBlocking {
        bot.commentMediasByHashTag(hashTagName, commentList, howManyMediasYouWantToComment).collect { println(it) }
    }
}