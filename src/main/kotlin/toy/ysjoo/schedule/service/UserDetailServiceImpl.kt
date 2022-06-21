package toy.ysjoo.schedule.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import toy.ysjoo.schedule.repository.UserRepository

@Service
class UserDetailServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        return userRepository.findByEmail(username)
    }
}