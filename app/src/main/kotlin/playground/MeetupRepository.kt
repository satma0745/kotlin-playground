package playground

import java.util.UUID
import kotlin.collections.Collection
import kotlin.collections.MutableList

internal class MeetupRepository {
    val meetups: MutableList<Meetup> = mutableListOf()

    fun registerMeetup(newMeetup: Meetup) {
       if (meetups.any { meetup -> meetup.id == newMeetup.id }) {
         throw Exception("Meetup with such Id was already Registered.")
       }

       this.meetups.add(newMeetup)
    }

    fun retreiveById(id: UUID): Meetup {
      return meetups.singleOrNull { meetup -> meetup.id == id }
        ?: throw Exception("Meetup with the specified Id does not Exist.")
    }

    fun retreiveMeetups(): Collection<Meetup> {
        return meetups
    }
}
