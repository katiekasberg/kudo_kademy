<template>
  <body class="admin-home">
    <div class="Welcome-User">
      <h2>Welcome Administrator!</h2>
    </div>
    <div class="announcement-component">
      <latest-announcement />
      <student-points-table />
      <class-points-table />
      <grade-points-table />
    </div>
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
  name: "home",
};
</script>
    

<style scoped>
.announcement-component {
  display: grid;
  grid-row-gap: 20px;
  align-content: center;
  justify-content: center;
  margin: auto;

  padding-bottom: 200px;
}

.Welcome-User {
  display: grid;
  justify-content: center;
  align-content: center;
  padding-left: 00px;
}

h2 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}
</style>