package toy.ysjoo.schedule.domain

import javax.persistence.*

@Entity
@Table(name = "schedule_schedule")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "contents")
    var contents: String? = null,

    @Column(name = "location")
    var location: String? = null,

    @Column(name = "start_date")
    var startDate: String? = null,

    @Column(name = "end_date")
    var endDate: String? = null,

    @Column(name = "owner")
    var owner: Long = 0,

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "attendees")
    var attendees: MutableList<Long>
)