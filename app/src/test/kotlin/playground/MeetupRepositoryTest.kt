package playground

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertContentEquals

class MeetupTest {
    @Test fun retreiveZeroMeetups() {
        val repository = MeetupRepository()
        val meetups = repository.retreiveMeetups()

        assertTrue(meetups.isEmpty())
    }

    @Test fun registerMeetups() {
        val newMeetups = arrayListOf<Meetup>(
            Meetup("Meetup #1", "Meetup #1 Description"),
            Meetup("Meetup #2", "Meetup #2 Description"),
        )

        val repository = MeetupRepository()
        newMeetups.forEach { meetup ->
            repository.registerMeetup(meetup)
        }

        val savedMeetups = repository.retreiveMeetups()
        assertContentEquals(newMeetups, savedMeetups)
    }
}
