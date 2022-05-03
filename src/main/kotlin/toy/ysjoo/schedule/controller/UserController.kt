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
        println("request to add user, data = $user")
        val id = userService.add(user)
        return when (id < 1) {
            true -> "fail to add user, already exist user id = ${user.id}"
            false -> "success to add user, id = $id"
        }
    }

    // Read User
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): String {
        println("request to get user, id = $id")
        val user = userService.get(id)
        return when (user != null) {
            true -> "success to get user, data = $user"
            false -> "don't exist user, id = $id"
        }
    }

    // Read User
    @GetMapping("/all")
    fun getUser(): String {
        println("request to get all user info!")
        val userList = userService.getAll()
        return when (userList.isNotEmpty()) {
            true -> "success to get all user info, total num = ${userList.size} \n >> user list = $userList"
            false -> "don't exist user info!"
        }
    }

    // Update User
    @PutMapping
    fun updateUser(@RequestBody user: UserDto): String {
        println("request to update user, data = $user")
        return when (userService.update(user)) {
            true -> "success to update user"
            false -> "fail to update user"
        }
    }

    // Delete User
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int): String {
        println("request to delete user, id = $id")
        return when (userService.delete(id)) {
            true -> "success to delete user"
            false -> "fail to delete user"
        }
    }
}