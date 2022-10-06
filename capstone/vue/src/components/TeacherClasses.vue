<template>
  <div>
    <table class="teacher-classes">
      <p>List of Teacher's Classes:</p>
      <tr>
        <th>Name</th>
        <th>Subject</th>
        <th>Period</th>
        <th>Start Time</th>
        <th>End Time</th>
        <th>School Year</th>
      </tr>
      <tr
        v-for="course in this.teacherClasses"
        v-bind:key="course.id"
        v-bind:value="course.id"
      >
        <td>{{ course.name }}</td>
        <td>{{ course.subject }}</td>
        <td>{{ course.period }}</td>
        <td>{{ course.startTime }}</td>
        <td>{{ course.endTime }}</td>
        <td>{{ course.schoolYear }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import TeacherService from "../services/TeacherService";

export default {
  name: "TeacherClasses",
  props: {
    staffId: Number,
  },
  data() {
    return {
      teacherClasses: [],
    };
  },
  methods: {
    getClasses() {
      TeacherService.getTeacherClassesById(this.staffId).then((response) => {
        this.teacherClasses = response.data;
      });
    },
  },
  created() {
    this.getClasses();
  },
};
</script>
<style scoped>
.teacher-classes {
  display: grid;
  align-items: center;
  justify-content: stretch;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.657);
  margin-bottom: 20px;
  margin-top: 100px;
}
th {
  font-family: Arial, Helvetica, sans-serif;
  font-size: large;
  font-weight: normal;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
  width: 150px;
  height: 30px;
  table-layout: fixed;
}
td {
  font-family: Arial, Helvetica, sans-serif;
  font-size: large;
  font-weight: normal;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
  width: 150px;
  height: 30px;
  table-layout: fixed;
}
p {
  display: flex;
  font-weight: bold;
  justify-items: center;
  align-content: center;
}
</style>