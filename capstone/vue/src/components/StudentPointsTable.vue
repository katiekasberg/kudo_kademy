<template>
  <div class="container">
    <p>Top Kudos Earners</p>
    <table>
      <thead>
        <tr>
          <th>Rank</th>
          <th>Student</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="studentPoint in studentPoints" :key="studentPoint.id">
          <td>{{ studentPoints.indexOf(studentPoint) + 1 }}</td>
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

  border-color: black;
}
</style>