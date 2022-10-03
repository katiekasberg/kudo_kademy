<template>
  <div>
    <table>
      List of Student's Classes:
      <tr>
        <th>Name</th>
        <th>Subject</th>
        <th>Teacher</th>
        <th>Period</th>
        <th>Start Time</th>
        <th>End Time</th>
        <th>School Year</th>
      </tr>
      <tr
        v-for="course in this.studentClasses"
        v-bind:key="course.id"
        v-bind:value="course.id"
      >
        <td>{{ course.name }}</td>
        <td>{{ course.subject }}</td>
        <td>{{ course.firstName }} {{ course.lastName }}</td>
        <td>{{ course.period }}</td>
        <td>{{ course.startTime }}</td>
        <td>{{ course.endTime }}</td>
        <td>{{ course.schoolYear }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import StudentService from "../services/StudentService";
export default {
  name: "StudentClasses",
  props: {
    studentId: Number,
  },
  data() {
    return {
      studentClasses: [],
    };
  },
  methods: {
    getStudentClasses() {
      StudentService.getStudentClassesById(this.studentId).then((response) => {
        this.studentClasses = response.data;
      });
    },
  },
  created() {
    this.getStudentClasses();
  },
};
</script>

<style>
</style>