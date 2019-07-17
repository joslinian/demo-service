package com.startech.demo.controller;

import com.startech.demo.persistence.Student;
import com.startech.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/get-students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
//
//    @RequestMapping("/insert-into-leaderboard")
//    public void insertIntoLeaderboard(@RequestParam(value = "name") String name, @RequestParam(value = "score") int score) {
//        jdbcTemplate.execute("insert into leaderboard values('" + name + "', " + score + ")");
//    }
//
//    @CrossOrigin
//    @RequestMapping(value = "/get-table", method = RequestMethod.GET, produces = "application/json")
//    public List<Map<String, Object>> getTable() {
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from  player_info order by max_streak desc");
//        return maps;
//    }
//
//    @CrossOrigin
//    @RequestMapping(value = "/store-username")
//    public void storeUsername(@RequestParam(value = "name") String name) {
//        jdbcTemplate.execute("insert into player_info values('" + name + "', 0, 0)");
//    }
//
//    @CrossOrigin
//    @RequestMapping("/up-streaks")
//    public void upStreaks(@RequestParam(value = "name") String playerName) {
//        int currStreak = jdbcTemplate.queryForInt("select current_streak from player_info WHERE name = '" + playerName + "'") + 1;
//        int maxStreak = jdbcTemplate.queryForInt("select max_streak from player_info WHERE name = '" + playerName + "'");
//        if (currStreak >= maxStreak) {
//            jdbcTemplate.execute("UPDATE player_info SET current_streak =" + currStreak + ", max_streak = " + currStreak + "WHERE name = '" + playerName + "'");
//        } else {
//            jdbcTemplate.execute("UPDATE player_info SET current_streak =" + currStreak + " WHERE name = '" + playerName + "'");
//        }
//    }
//
//    @CrossOrigin
//    @RequestMapping("/reset-current-streak")
//    public void resetCurrStreak(@RequestParam(value = "name") String playerName) {
//        jdbcTemplate.execute("UPDATE player_info SET current_streak = 0 WHERE name = '" + playerName + "'");
//    }
//
//    @CrossOrigin
//    @RequestMapping(value = "/get-current-streak", method = RequestMethod.GET, produces = "application/json")
//    public int getCurrStreak(@RequestParam(value = "name") String playerName) {
//        int currStreak = jdbcTemplate.queryForInt("select current_streak from player_info WHERE name = '" + playerName + "'");
//        return currStreak;
//    }
//
//    @CrossOrigin
//    @RequestMapping(value = "/get-num-entries", method = RequestMethod.GET, produces = "application/json")
//    public int getNumEntries() {
//        int numEntries = jdbcTemplate.queryForInt("select count (name) from player_info");
//        return numEntries;
//    }

}
