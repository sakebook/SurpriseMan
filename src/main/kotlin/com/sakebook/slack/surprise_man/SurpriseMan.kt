package com.sakebook.slack.surprise_man

import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory

/**
 * Created by sakemotoshinya on 2017/08/27.
 */
fun main(args: Array<String>?) {
    val session = SlackSessionFactory.createWebSocketSlackSession(System.getenv("SURPRISE_MAN_TOKEN"))
    session.connect()
    session.addMessagePostedListener(MessagePostedListener())
}

