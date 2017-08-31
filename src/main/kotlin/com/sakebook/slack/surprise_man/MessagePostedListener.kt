package com.sakebook.slack.surprise_man

import com.ullink.slack.simpleslackapi.SlackPreparedMessage
import com.ullink.slack.simpleslackapi.SlackSession
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener

/**
 * Created by sakemotoshinya on 2017/08/30.
 */
class MessagePostedListener: SlackMessagePostedListener {

    override fun onEvent(event: SlackMessagePosted, session: SlackSession) {
        val postedUserName = event.sender.userName
        if (event.channel.name == "test" && !event.sender.isBot) {
            session.sendMessage(event.channel, SlackPreparedMessage.Builder()
                    .withMessage("Hey <@$postedUserName>. I'm a ${session.bots.firstOrNull { it.userName == "surprise_man" }?.userName}")
                    .withLinkNames(true)
                    .build())
        }
    }
}
