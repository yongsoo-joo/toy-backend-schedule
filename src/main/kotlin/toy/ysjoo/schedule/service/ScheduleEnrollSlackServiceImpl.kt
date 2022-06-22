package toy.ysjoo.schedule.service

import com.slack.api.Slack
import com.slack.api.model.block.Blocks.asBlocks
import com.slack.api.model.block.Blocks.section
import com.slack.api.model.block.composition.BlockCompositions.markdownText
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service("ScheduleEnrollSlackService")
class ScheduleEnrollSlackServiceImpl() : SlackService {

    private val log = LoggerFactory.getLogger(javaClass)

    private val TEXT_NOTIFICATION: String = "일정이 등록되었습니다"

    @Value(value = "\${spring.slack.schedule.token}")
    lateinit var token: String

    @Value(value = "\${spring.slack.schedule.channel.monitor}")
    lateinit var channel: String

    override fun sendMessage(sectionText: String) {
        val client = Slack.getInstance().methods()
        kotlin.runCatching {
            val response = client.chatPostMessage { req ->
                req.token(token).channel(channel)
                    .text(TEXT_NOTIFICATION)
                    .blocks(
                        asBlocks(
                            section { section -> section.text(markdownText(sectionText)) }
                        )
                    )
            }
            if (response.isOk) {
                val postedMessage = response.message
                println("Slack Send Message: $postedMessage")
            } else {
                val errCode = response.error
                log.error("Slack Send Error: {}", errCode)
            }
        }.onFailure { e ->
            log.error("Slack Send Error: {}", e.message, e)
        }
    }
}