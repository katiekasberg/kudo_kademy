<template>
  <div class="home">
    <!-- <div class="container"> -->
    <div class="Welcome-User">
      <h1>Welcome Parent!</h1>
    </div>
    <div class="components">
      <div class="Announcements">
        <h2>
          <latest-announcement />
        </h2>
      </div>
      <div class="View-Report">
        <student-list />
      </div>
      <div class="House-Cup">
        <h2>Leaderboards</h2>
        <class-points-table />
        <grade-points-table />
      </div>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import LatestAnnouncement from "../components/LatestAnnouncement.vue";
import StudentList from "../components/StudentList.vue";
import ClassPointsTable from "../components/ClassPointsTable.vue";
import GradePointsTable from "../components/GradePointsTable.vue";

export default {
  components: {
    StudentList,
    LatestAnnouncement,
    ClassPointsTable,
    GradePointsTable,
  },
};
</script>

<style scoped>
.home {
  display: grid;

  justify-content: space-evenly;
  align-content: center;
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
  padding: 200px;
}

.Welcome-User {
  display: grid;
  justify-content: center;
  align-content: center;
}

.Announcements {
  display: grid;
  justify-content: center;
  align-content: center;
}

.View-Report {
  display: grid;
  justify-content: center;
  align-content: center;
}

.House-Cup {
  display: grid;
  justify-content: center;
  align-content: center;
}
.components {
  background-color: rgba(255, 255, 255, 0.657);
  padding-bottom: 200px;
}
</style>