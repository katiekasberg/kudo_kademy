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
          <td>
            <router-link
              v-bind:to="{
                name: 'TeacherProfile',
                params: { id: course.teacherId },
              }"
            >
              {{ course.firstName }} {{ course.lastName }}
            </router-link>
          </td>
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

<style scoped>
.kudo-list {
  border: 1px solid black;
  font-size: large;
  border-radius: 5px;
  display: block;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  background-color: rgba(255, 255, 255, 0.25);
  padding-left: 100px;
  padding-right: 100px;
  padding-bottom: 100px;
  font-size: medium;
  font-weight: normal;
}
p {
  text-align: center;
}
th {
  border: 1px solid black;
  border-radius: 5px;
  background-color: white;
  text-align: center;
  padding-left: 50px;
  padding-right: 50px;
}
td {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid black;
  text-align: center;
  background-color: white;
}
</style>