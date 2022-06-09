package toy.ysjoo.schedule.domain

import toy.ysjoo.schedule.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "schedule_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "address")
    var address: String? = null,

    @Column(name = "phone_number")
    var phoneNumber: String? = null,

    @Column(name = "role")
    var role: String? = null
) {
    fun toUserDto(): UserDto {
        return UserDto(id, name, address, phoneNumber, role)
    }

    fun update(u: UserDto): Boolean {
        this.name = u.name
        this.address = u.address
        this.phoneNumber = u.phoneNumber
        this.role = u.role
        return true
    }
}