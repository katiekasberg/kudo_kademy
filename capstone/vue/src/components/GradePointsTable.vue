<template>
  <div class="container">
    <p colspan="3">Grade Rank</p>
    <table>
      <thead>
        <tr class="header"></tr>
        <tr>
          <th>Rank</th>
          <th class="middle">Grade</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="gradePoint in gradePoints" :key="gradePoint.id">
          <td>{{ gradePoints.indexOf(gradePoint) + 1 }}</td>
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

<style scoped>
.container {
  font-size: large;
  border-radius: 5px;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.25);
  font-size: medium;
  font-weight: normal;
}

th {
  font-family: Arial, Helvetica, sans-serif;
  font-size: large;
  font-weight: bold;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
}
td {
  padding: 10px;
  border-radius: 5px;
  border: 2px solid black;
  text-align: left;
  background-color: white;
  width: 1500px;
  height: 30px;
  table-layout: fixed;
}
p {
  text-align: center;
  font-weight: bold;
  font-size: large;
  border-radius: 5px;
  background: white;
  border-color: black;
}
</style>