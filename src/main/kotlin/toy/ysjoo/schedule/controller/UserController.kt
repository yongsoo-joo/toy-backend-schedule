package toy.ysjoo.schedule.controller

import org.springframework.web.bind.annotation.*
import toy.ysjoo.schedule.dto.UserDto
import toy.ysjoo.schedule.service.UserServiceImpl

@RestController
@RequestMapping("/users")
class UserController {

    val userService = UserServiceImpl()

    // Create User
    @PostMapping
    fun addUser(@RequestBody user: UserDto): String {
        println(user)
        val uid = userService.add(user)
        return "add user, id = $uid"
    }

    // Read User
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): String {
        val user = userService.get(id)
        if (user != null) {
            return user.toString()
        }
        return "no user"
    }

    // Update User
    @PutMapping
    fun updateUser(): String {
        // TODO: 서비스 로직 연결
        return "update user"
    }

    // Delete User
    @DeleteMapping
    fun deleteUser(): String {
        // TODO: 서비스 로직 연결
        return "delete user"
    }
}