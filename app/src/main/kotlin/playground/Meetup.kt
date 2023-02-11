package playground

import java.util.UUID

internal class Meetup {
    val id: UUID
    val title: String
    val description: String

    constructor(title: String, description: String) {
        this.id = UUID.randomUUID()
        this.title = title
        this.description = description
    }
}
