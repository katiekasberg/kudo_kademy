<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Grade</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="gradePoint in gradePoints" :key="gradePoint.id">
          <td>{{ gradePoint.currentGradeLevel }}</td>
          <td>{{ gradePoint.value }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import pointService from "../services/PointService.js";

export default {
  name: "grade-points-table",
  data() {
    return {
      gradePoints: [],
    };
  },
  created() {
    pointService.getPointsForAllGrades().then((response) => {
      this.gradePoints = response.data;
    });
  },
};
</script>

<style>
</style>