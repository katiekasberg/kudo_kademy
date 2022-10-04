<template>
  <body>
    <div class="home">
      <div class="container">
        <div class="Welcome-User">
          <h1>
            Welcome {{ this.$store.state.activeStudentProfile.firstName }}
          </h1>
        </div>
        <div class="Announcements">
          <h2>
            <latest-announcement/>
          </h2>
        </div>
        <div class="House-Cup">
          <h2>Leaderboards</h2>
          <class-points-table />
          <grade-points-table />
        </div>
        <div class="Class-points"></div>
        <div>
          <h2>Latest Kudos Recognitions in your grade:</h2>
          <grade-kudos />
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import ClassPointsTable from "../components/ClassPointsTable.vue";
import GradePointsTable from "../components/GradePointsTable.vue";
import GradeKudos from "../components/GradeKudos.vue";
import LatestAnnouncement from '../components/LatestAnnouncement.vue';
export default {
  components: { ClassPointsTable, GradePointsTable, GradeKudos, LatestAnnouncement },
};
</script>

<style scope>
.container {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 0.7fr 0.2fr 0.7fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "Aside-nav Header"
    "Aside-nav Welcome-User"
    "Aside-nav Announcements"
    "Aside-nav House-Cup";
}

/* .Header {
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
} */

.Class-points {
  grid-area: Class-points;
  justify-items: center;
}

.app-name {
  grid-area: app-name;
  justify-items: center;
}

.logo {
  grid-area: logo;
}

.Welcome-User {
  grid-area: Welcome-User;
}

.House-Cup {
  grid-area: House-Cup;
  justify-items: center;
}

.Announcements {
  grid-area: Announcements;
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
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
}
p {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
}

aside {
  position: fixed;
  margin-left: 0.5%;
  margin-right: 0.5%;
  padding-top: 100%;
  padding: 10px;
  width: 15%;
  float: right;
  overflow: auto;
  border-radius: 5px;
  border-width: 3px;
  border-color: darkorange;
  background-color: #ffc83c57;
  opacity: 100%;
  height: 100%;
}

ul {
  display: grid;
  align-items: center;
  color: darkorange;
  justify-items: center;
  justify-content: center;
  margin: 0;
  padding: 0;
}

li {
  font-size: 20px;
  font-weight: bold;
  display: block;
  text-align: center;
  text-transform: uppercase;
  font-family: Arial, Helvetica, sans-serif;
  border-color: darkorange;
  padding: 15px;
  border-bottom: 1px solid;
  width: 95%;
}

.home {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
  display: 100%;
}
button {
  padding: 10px;
  margin-left: 20px;
  background-color: rgb(253, 223, 158);
  border-radius: 10%;
  border-color: orange;
}
a {
  text-decoration: none;
  color: rgb(83, 40, 3);
  font-weight: bold;
}
</style>