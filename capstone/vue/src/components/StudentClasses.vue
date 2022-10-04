<template>
  <div class="box">
    <div>
      <p>List of Student's Classes:</p>
      <table>
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
.box {
  background-color: rgba(255, 255, 255, 0.657);
  padding-left: 50px;
  padding-right: 50px;
  margin-left: 200px;
}
p {
  align-items: center;
  justify-content: center;
}
</style>