package toy.ysjoo.schedule.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import toy.ysjoo.schedule.domain.User
import toy.ysjoo.schedule.dto.LoginDto
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.service.UserServiceImpl

@RestController
@RequestMapping
class UserController(
    private val userService: UserServiceImpl,
    private val passwordEncoder: PasswordEncoder
) {
    // Register User
    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<String> {

        return when (userDto.email != null) {
            true -> {
                if (userService.existsUser(userDto.email!!)) {
                    ResponseEntity.badRequest().body("duplicate email!")
                }
                userDto.password = passwordEncoder.encode(userDto.password)

                ResponseEntity.ok(userService.createUser(userDto).toString())
            }
            false -> {
                ResponseEntity.badRequest().body("email is empty")
            }
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<String> {
        if (!userService.existsUser(loginDto.email)) {
            ResponseEntity.internalServerError().body("not exist user email!")
        }

        val user: User? = userService.findUser(loginDto.email)

        return when (user != null) {
            true -> {
                if (!passwordEncoder.matches(loginDto.password, user.password)) {
                    ResponseEntity.badRequest().body("not eqaul password")
                } else {
                    userService.login(loginDto)
                }
            }
            false -> {
                ResponseEntity.badRequest().body("not exist user!")
            }
        }
    }


    // Create User
//    @PostMapping
//    fun addUser(@RequestBody user: UserDto): String {
//        println("request to add user, data = $user")
//        val id = userService.add(user)
//        return when (id > 0) {
//            true -> "success to add user, id = $id"
//            false -> "fail to add user, already exist user id = ${user.id}"
//        }
//    }

    // Read User
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @GetMapping("/user/{id}")
    fun getUser(@PathVariable id: Long): String {
        println("request to get user, id = $id")
        val user = userService.get(id)
        return when (user != null) {
            true -> "success to get user, data = $user"
            false -> "don't exist user, id = $id"
        }
    }

    // Read User
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @GetMapping("/user/all")
    fun getUserAll(): String {
        println("request to get all user info!")
        val userList = userService.getAll()
        return when (userList.isNotEmpty()) {
            true -> "success to get all user info, total num = ${userList.size}" +
                    "\n >> user list = $userList"
            false -> "don't exist user info!"
        }
    }

    // Update User
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @PutMapping("/user")
    fun updateUser(@RequestBody user: UserDto): String {
        println("request to update user, data = $user")
        return when (userService.update(user)) {
            true -> "success to update user"
            false -> "fail to update user"
        }
    }

    // Delete User
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        println("request to delete user, id = $id")
        return when (userService.delete(id)) {
            true -> "success to delete user, id = $id"
            false -> "fail to delete user, id = $id"
        }
    }
}