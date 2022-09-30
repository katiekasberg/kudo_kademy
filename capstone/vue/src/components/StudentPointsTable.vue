<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Student</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="studentPoint in studentPoints" :key="studentPoint.id">
          <td>{{ studentPoint.fullName }}</td>
          <td>{{ studentPoint.value }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import pointService from "../services/PointService.js";

export default {
  name: "student-points-table",
  data() {
    return {
      studentPoints: [],
    };
  },
  created() {
    pointService.getPointsForAllStudents().then((response) => {
      this.studentPoints = response.data;
    });
  },
};
</script>

<style>
</style>