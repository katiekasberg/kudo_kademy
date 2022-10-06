<template>
  <div class="container">
    <table class="tableClass">
      <thead>
        <tr class="header">
<<<<<<< HEAD
          <p colspan="3">Classroom Leaderboard</p>
=======
          <th colspan="3">Classroom Rank</th>
>>>>>>> 6dc6b99f8f63e718e9b975b5fac06ce26a9d6ea0
        </tr>
        <tr>
          <th>Rank</th>
          <th class="middle">Class</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="classPoint in classPoints" :key="classPoint.id">
          <td>{{ classPoints.indexOf(classPoint) + 1 }}</td>
          <td>{{ classPoint.className }}</td>
          <td>{{ classPoint.value }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import pointService from "../services/PointService.js";

export default {
  name: "class-points-table",
  data() {
    return {
      classPoints: [],
    };
  },
  created() {
    pointService.getPointsForAllClasses().then((response) => {
      this.classPoints = response.data;
    });
  },
};
</script>

<style scoped>
.container {
  display: grid;
  align-items: center;
  justify-content: stretch;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.657);
  margin-bottom: 20px;
  /* padding-left: 200px;
  padding-right: 200px; */
}
.header {
  border: 0px solid white;
}
th {
  font-weight: bold;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
}
tr,
td {
  font-family: Arial, Helvetica, sans-serif;
  font-size: large;
  font-weight: normal;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black;
  width: 1500px;
  height: 30px;
  table-layout: fixed;
}
p {
  font-weight: bold;
  font-size: large;
  align-items: center;
  justify-content: center;
}
</style>