<template>
  <body class="container">
    <h1>Welcome Teacher!</h1>
    <latest-announcement />
    <student-points-table />
    <class-points-table />
    <grade-points-table />
  </body>
</template>

<script>
import ClassPointsTable from "../components/ClassPointsTable.vue";
import GradePointsTable from "../components/GradePointsTable.vue";
import LatestAnnouncement from "../components/LatestAnnouncement.vue";
import StudentPointsTable from "../components/StudentPointsTable.vue";
export default {
  components: {
    LatestAnnouncement,
    StudentPointsTable,
    ClassPointsTable,
    GradePointsTable,
  },
};
</script>

<style scoped>
.container {
  display: grid;
  align-content: center;
  justify-content: center;
  grid-row-gap: 20px;
  align-content: center;
  justify-content: center;
  margin: auto;
  padding-left: 300px;
  padding-right: 300px;
}

h1 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}
</style>