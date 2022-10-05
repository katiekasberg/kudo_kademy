<template>
  <body>
    <div>
      <table>
        <thead>
          <tr>
            <th>Rank</th>
            <th>Class</th>
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
  </body>
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
body {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.657);
  padding-left: 200px;
  padding-right: 200px;
}
tr,
th,
td {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
  border-radius: 5px;
  border: 2px solid black
}
</style>