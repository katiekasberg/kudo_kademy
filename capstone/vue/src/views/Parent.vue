<template>
  <div class="home">
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
      <h2 class="leaderboard">Leaderboard</h2>
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

export default {
  components: { LatestAnnouncement, ClassPointsTable, GradePointsTable },
};
</script>

<style scoped>
.home {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "Welcome-User"
    "Announcements"
    "View-Report"
    "House-Cup";
  /* justify-items: center; */
  justify-content: space-evenly;
  align-content: center;
  text-align: center;
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
  padding: 200px;
}

.leaderboard{
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange
}

.Welcome-User {
  grid-area: Welcome-User;
}

.Announcements {
  grid-area: Announcements;
}

.View-Report {
  grid-area: View-Report;
}

.House-Cup {
  grid-area: House-Cup;
}

/* .container {
  display: flex;
  flex-direction: column;
   */

/* grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr 1fr; */
/* gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header "
    "Aside-nav Welcome-User"
    "Aside-nav Announcements"
    "Aside-nav View-Report"
    "Aside-nav House-Cup"; */

/* .Header {
  display: grid;
  justify-content: center;
} */

/* .app-name {
  grid-area: app-name;
  justify-items: center;
} */

/* .logo {
  grid-area: logo;
} */

/* img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
} */

/* h2 {
  color: darkorange;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: normal;
} */
/* h1 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
} */
/* p {
  display: grid;
  justify-content: center;
  align-content: center;
}

.House-Cup {
  display: grid;
  justify-content: center;
} */

/* ul > li {
  font-size: 20px;
  font-weight: bold;
  border-bottom: 1px solid;
} */

/* button {
  padding: 10px;
  margin-left: 20px;
  background-color: white;
  opacity: 100%;
  border-radius: 10%;
  border-color: orange;
  text-decoration: none;
} */
/* a {
  text-decoration: none;
  color: rgb(83, 40, 3);
  font-weight: bold;
} */
</style>