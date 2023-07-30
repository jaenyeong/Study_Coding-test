package com.jaenyeong.programmers.book.ch05_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// [Lv2] 메뉴 리뉴얼
// https://school.programmers.co.kr/learn/courses/30/lessons/72411
public class Solution29 {

    public String[] solution(String[] orders, int[] course) {
        final List<Set<String>> orderList = Arrays.stream(orders)
            .map(String::chars)
            .map(charStream -> charStream.mapToObj(
                    menu -> String.valueOf((char) menu))
                .collect(Collectors.toSet())
            )
            .collect(Collectors.toList());

        final Map<Integer, List<Course>> courses = new HashMap<>();

        for (int length : course) {
            final List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }

        getCourses('A', new HashSet<>(), orderList, courses);

        return courses.values().stream()
            .filter(list -> list.get(0).occurrences > 0)
            .flatMap(List::stream)
            .map(c -> c.course)
            .sorted()
            .toArray(String[]::new);
    }

    private void getCourses(
        char nextMenu,
        Set<String> selectedMenus,
        List<Set<String>> orderList,
        Map<Integer, List<Course>> courses
    ) {

        final int occurrences = (int) orderList.stream().filter(order -> order.containsAll(selectedMenus)).count();

        if (occurrences < 2) {
            return;
        }

        final int size = selectedMenus.size();

        if (courses.containsKey(size)) {
            final List<Course> courseList = courses.get(size);
            final Course course = new Course(selectedMenus.stream().sorted().collect(Collectors.joining("")),
                occurrences);

            final Course original = courseList.get(0);

            if (original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrences == occurrences) {
                courseList.add(course);
            }
        }

        if (size >= 10) {
            return;
        }

        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            final String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }

    private static class Course {
        private final String course;
        private final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }
}
