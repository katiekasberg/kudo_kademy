<template>
  <body>
    <div class="container">
      <div class="Welcome-User">
        <h1>Welcome {{ this.$store.state.activeStudentProfile.firstName }}</h1>
      </div>
      <div class="Announcements">
        <latest-announcement />
        <p>Leaderboard</p>
        <student-points-table />
        <class-points-table />
        <grade-points-table />
      </div>

      <div class="Class-points">
        <h3>Latest Kudos Recognitions in your grade:</h3>
        <grade-kudos />
      </div>
    </div>
  </body>
</template>

<script>
import ClassPointsTable from "../components/ClassPointsTable.vue";
import GradePointsTable from "../components/GradePointsTable.vue";
import GradeKudos from "../components/GradeKudos.vue";
import LatestAnnouncement from "../components/LatestAnnouncement.vue";
import StudentPointsTable from "../components/StudentPointsTable.vue";
export default {
  components: {
    ClassPointsTable,
    GradePointsTable,
    GradeKudos,
    LatestAnnouncement,
    StudentPointsTable,
  },
};
</script>

<style scoped>

.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
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