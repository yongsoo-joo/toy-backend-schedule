package toy.ysjoo.schedule.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import toy.ysjoo.schedule.domain.User
import toy.ysjoo.schedule.dto.LoginDto
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.jwt.JwtTokenProvider
import toy.ysjoo.schedule.mapper.UserMapper
import toy.ysjoo.schedule.repository.UserRepository

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val jwtTokenProvider: JwtTokenProvider
) : RestService<UserDto> {

    fun findUser(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun existsUser(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }

    fun createUser(userDto: UserDto): UserDto {
        val user = User(0, userDto.name, userDto.email, userDto.password)
        userRepository.save(user)

        return UserDto(user.id, user.email)
    }

    fun login(loginDto: LoginDto): ResponseEntity<String> {
        val token: String = jwtTokenProvider.createToken(loginDto.email)
        return ResponseEntity.ok(token)
    }

    /**
     *
     */
    override fun add(e: UserDto): Long {
        val res = userRepository.save(userMapper.toDomain(e))
        return res.id
    }

    /**
     *
     */
    override fun update(e: UserDto): Boolean {
        val res = userRepository.findByIdOrNull(e.id)
        return when (res != null) {
            true -> {
                userMapper.update(e, res)
                true
            }
            false -> false
        }
    }

    /**
     *
     */
    @Transactional(readOnly = true)
    override fun get(id: Long): UserDto? {
        val res = userRepository.findByIdOrNull(id)
        return when (res != null) {
            true -> userMapper.toDto(res)
            false -> null
        }
    }

    @Transactional(readOnly = true)
    override fun getAll(): List<UserDto> {
        val userDtoList = mutableListOf<UserDto>()
        val res = userRepository.findAll()
        res.forEach {
            userDtoList.add(userMapper.toDto(it))
        }
        return userDtoList
    }

    /**
     *
     */
    override fun delete(id: Long): Boolean {
        val res = userRepository.findByIdOrNull(id)
        return when (res != null) {
            true -> {
                userRepository.delete(res)
                true
            }
            false -> false
        }
    }
}