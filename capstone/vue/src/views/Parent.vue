<template>
  <div class="container">
    <!-- <div class="container"> -->
    <div class="Welcome-User">
      <h1>Welcome Parent!</h1>
    </div>
    <div class="Announcements">
      <h2>
        <latest-announcement />
      </h2>
    </div>
    <!-- <div class="View-Report">
        <h2>View Student Report</h2>
        
      </div> -->
    <div class="House-Cup">
      <h2 class="leaderboard">Leaderboards</h2>
      <student-points-table />
      <class-points-table />
      <grade-points-table />
    </div>
    <!-- </div> -->
  </div>
  <!-- </div> -->
</template>

<script>
import LatestAnnouncement from "../components/LatestAnnouncement.vue";
import ClassPointsTable from "../components/ClassPointsTable.vue";
import GradePointsTable from "../components/GradePointsTable.vue";
import StudentPointsTable from "../components/StudentPointsTable.vue";

export default {
  components: {
    LatestAnnouncement,
    ClassPointsTable,
    GradePointsTable,
    StudentPointsTable,
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
h2 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: black;
  letter-spacing: 2px;
}
</style>