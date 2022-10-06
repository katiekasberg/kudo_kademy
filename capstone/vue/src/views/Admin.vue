<template>
  <body class="admin-home">
    <div class="Welcome-User">
      <h2>Welcome Administrator!</h2>
    </div>
    <div class="announcement-component">
      <latest-announcement />
    </div>
    <div class="rewards-component">
      <rewards />
    </div>
  </body>
</template>

<script>
import LatestAnnouncement from "../components/LatestAnnouncement.vue";
import Rewards from "../components/Rewards.vue";

export default {
  components: { Rewards, LatestAnnouncement },
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
  /* padding-left: 600px;
  padding-right: 600px; */
  padding-bottom: 200px;
  /* padding: 200px; */
  padding-right: 400px;
  padding-left: 400px;
}

.rewards-component{
  background-color: white;
}

/* .container {
  display: grid;
  align-content: center;
  justify-content: center;
} */

.admin-home {
  display: grid;
}

.Welcome-User {
  display: grid;
  justify-content: center;
  align-content: center;
  padding-left: 00px;
}
/* .submitBtn {
  margin: auto;
  display: block;
} */

/* .search {
  grid-area: search;
} */

/* img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
} */

h2 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}

/* p {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(216, 150, 69);
} */

body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
/* button {
  padding: 10px;
  margin-left: 20px;
  background-color: white;
  border-radius: 10%;
  border-color: orange;
} */

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

/* #makeAnnouncement {
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
} */
</style>