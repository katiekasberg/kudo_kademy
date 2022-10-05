<template>
  <body class="grade-points">
    <div>
      <table>
        <thead>
          <p>Kudos By Grade</p>
          <tr>
            <th>Rank</th>
            <th>Grade</th>
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
  </body>
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
.grade-points {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.657);
}
tr,
th,
td {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
}
p {
  display: grid;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  color: black;
  padding-left: 50px;
}
</style>