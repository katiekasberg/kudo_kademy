<template>
  <div>
    <h3>Class Details:</h3>
    <table>
      <thead>
        <tr>
          <th>Class Name</th>
          <th>Subject</th>
          <th>Description</th>
          <th>Teacher</th>
          <th>Period</th>
          <th>Start Time</th>
          <th>End Time</th>
          <th>School Year</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>{{ classDetail.name }}</td>
          <td>{{ classDetail.subject }}</td>
          <td>{{ classDetail.description }}</td>
          <td>{{ classDetail.firstName }} {{ classDetail.lastName }}</td>
          <td>{{ classDetail.period }}</td>
          <td>{{ classDetail.startTime }}</td>
          <td>{{ classDetail.endTime }}</td>
          <td>{{ classDetail.schoolYear }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import teacherService from "../services/TeacherService";

export default {
  props: { classInfoId: Number },
  data() {
    return {
      classDetail: {},
    };
  },
  methods: {
    getClassDetails() {
      teacherService
        .getClassDetailByClassId(this.classInfoId)
        .then((response) => {
          this.classDetail = response.data;
        });
    },
  },
  created() {
    if (this.classInfoId) {
      this.getClassDetails();
    } else {
      this.$watch("classInfoId", () => {
        this.getClassDetails();
      });
    }
  },
};
</script>

<style scoped>
</style>