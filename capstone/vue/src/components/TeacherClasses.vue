<template>
  <div>
    <table class="classes">
      List of Teacher's Classes:
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
        staffId: Number
    },
    data(){
        return{
            teacherClasses: [],
        };
    },
    methods: {
        getClasses(){
            TeacherService.getTeacherClassesById(this.staffId).then((response) => {
                this.teacherClasses = response.data;
            });
        },
    },
    created() {
        this.getClasses();
    }

}
</script>
<style>
.classes{
  font-family: Arial, Helvetica, sans-serif;
  border: 2px solid black;
}
</style>