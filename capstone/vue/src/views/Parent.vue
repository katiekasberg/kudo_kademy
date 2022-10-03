<template>
  <div class="home">
    <div class="Header"></div>
    <div class="Welcome-User">
      <h1>Welcome Parent!</h1>
    </div>
    <div class="Announcements">
      <h2>See Announcements</h2>
    </div>
    <div class="View-Report">
      <h2>View Student Report</h2>
      <student-list />
    </div>
  </div>
</template>

<script>
import StudentList from "../components/StudentList.vue";
export default {
  components: { StudentList },
};
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
    "Aside-nav Announcements"
    "Aside-nav View-Report";
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

.Announcements {
  grid-area: Announcements;
}

.View-Report {
  grid-area: View-Report;
}

img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}

h2 {
  color: black;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: normal;
}
h1 {
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
  /* filter: invert(1); */
  float: right;
  overflow: auto;
  border-radius: 5px;
  border-width: 3px;
  /* border-radius: 20%; */
  border-color: darkorange;
  background-color: #ffc83c57;
  opacity: 100%;
}

ul {
  display: grid;
  align-items: center;
  color: darkorange;
  /* color is not showing up?? */
  justify-items: center;
  justify-content: center;
}

ul > li {
  font-size: 20px;
  font-weight: bold;
  border-bottom: 1px solid;
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
  background-color: white;
  opacity: 100%;
  border-radius: 10%;
  border-color: orange;
  text-decoration: none;
}
a {
  text-decoration: none;
  color: rgb(83, 40, 3);
  font-weight: bold;
}
</style>