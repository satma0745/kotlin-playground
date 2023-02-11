package playground

import kotlin.collections.Collection
import kotlin.collections.MutableList

internal class MeetupRepository {
    val meetups: MutableList<Meetup> = mutableListOf()

    fun registerMeetup(newMeetup: Meetup) {
       this.meetups.add(newMeetup)
    }

    fun retreiveMeetups(): Collection<Meetup> {
        return meetups
    }
}
