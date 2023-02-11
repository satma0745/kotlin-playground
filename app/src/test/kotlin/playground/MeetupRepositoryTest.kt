package playground

import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith

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

    @Test fun registerMeetupFailsOnReRegistrationOfTheSameMeetup() {
        val meetup = Meetup("Meetup", "Description")

        val repository = MeetupRepository()
        repository.registerMeetup(meetup)

        assertFailsWith<Exception>() {
            repository.registerMeetup(meetup)
        }
    }

    @Test fun getMeetupById() {
        val meetup = Meetup("Meetup", "Meetup Description")
      
        val repository = MeetupRepository()
        repository.registerMeetup(meetup)

        val meetupById = repository.retreiveById(meetup.id)
        assertEquals(meetup, meetupById)
    }

    @Test fun getMeetupByIdFailsOnNonRegisteredId() {
        val repository = MeetupRepository()
        val nonRegisteredMeetupId = UUID.randomUUID()

        assertFailsWith<Exception>() {
            repository.retreiveById(nonRegisteredMeetupId)
        }
    }
}
