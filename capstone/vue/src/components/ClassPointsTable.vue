<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Class</th>
          <th>Points</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="classPoint in classPoints" :key="classPoint.id">
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

<style>
</style>