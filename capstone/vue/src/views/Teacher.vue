<template>
  <body>
    <h1>Welcome Teacher!</h1>
    <latest-announcement/>
    <student-points-table/>
    <class-points-table/>
    <grade-points-table/>
  </body>
</template>

<script>
import ClassPointsTable from '../components/ClassPointsTable.vue'
import GradePointsTable from '../components/GradePointsTable.vue'
import LatestAnnouncement from '../components/LatestAnnouncement.vue'
import StudentPointsTable from '../components/StudentPointsTable.vue'
export default {
  components: { LatestAnnouncement, StudentPointsTable, ClassPointsTable, GradePointsTable },
}

</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header "
    "Aside-nav Welcome-User"
    "Aside-nav Announcements "
    "Aside-nav search";
}

.Header {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "app-name app-name app-name"
    "logo logo logo"
    "logo logo logo";
  grid-area: Header;
  justify-content: center;
}

.app-name {
  grid-area: app-name;
  justify-items: center;
  text-decoration: underline;
  color: darkorange;
}

.logo {
  grid-area: logo;
}

.Welcome-User {
  grid-area: Welcome-User;
}

.Announcements {
  grid-area: Announcements;
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}

#makeAnnouncement {
  margin: auto;
  display: block;
  width: 50%;
  height: 50%;
  text-align: center;
  padding-bottom: 100px;
  margin-bottom: 5px;
}

#searchStudent {
  margin: auto;
  display: block;
}

.submitBtn {
  margin: auto;
  display: block;
}

.search {
  grid-area: search;
}

img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}
h1,
h2 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}

body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
</style>