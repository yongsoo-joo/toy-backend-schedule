package toy.ysjoo.schedule.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*
import toy.ysjoo.schedule.dto.ScheduleDto
import toy.ysjoo.schedule.service.ScheduleServiceImpl

@RestController
@RequestMapping("/schedule")
class ScheduleController(
    private val scheduleService: ScheduleServiceImpl
) {

    // Create Schedule
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @PostMapping
    fun addSchedule(@RequestBody schedule: ScheduleDto): String {
        println("request to add schedule, data = $schedule")
        val id = scheduleService.add(schedule)
        return when (id > 0) {
            true -> "success to add schedule, id = $id"
            false -> "fail to add schedule, already exist schedule id = ${schedule.id}"
        }
    }

    // Read Schedule
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    @GetMapping("/{id}")
    fun getSchedule(@PathVariable id: Long): String {
        println("request to get schedule, id = $id")
        val schedule = scheduleService.get(id)
        return when (schedule != null) {
            true -> "success to get schedule, data = $schedule"
            false -> "don't exist schedule, id = $id"
        }
    }

    @GetMapping("/title/{title}")
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    fun getSchedule(@PathVariable title: String): String {
        println("request to get schedule, title = $title")
        val schedule = scheduleService.get(title)
        return when (schedule != null) {
            true -> "success to get schedule, data = $schedule"
            false -> "don't exist schedule, title = $title"
        }
    }

    // Read Schedule
    @GetMapping("/all")
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    fun getScheduleAll(): String {
        println("request to get all schedule info!")
        val scheduleList = scheduleService.getAll()
        return when (scheduleList.isNotEmpty()) {
            true -> "success to get all schedule info, total num = ${scheduleList.size}" +
                    "\n >> schedule list = $scheduleList"
            false -> "don't exist schedule info!"
        }
    }

    // Update Schedule
    @PutMapping
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    fun updateSchedule(@RequestBody schedule: ScheduleDto): String {
        println("request to update schedule, data = $schedule")
        return when (scheduleService.update(schedule)) {
            true -> "success to update schedule"
            false -> "fail to update schedule"
        }
    }

    // Delete Schedule
    @DeleteMapping("/{id}")
    @Operation(security = [SecurityRequirement(name = "Authorization")])
    fun deleteSchedule(@PathVariable id: Long): String {
        println("request to delete schedule, id = $id")
        return when (scheduleService.delete(id)) {
            true -> "success to delete schedule, id = $id"
            false -> "fail to delete schedule, id = $id"
        }
    }
}