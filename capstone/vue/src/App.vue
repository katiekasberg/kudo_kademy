<template>
  <body>
    <div class="nav">
      <nav-bar />
    </div>
    <div id="app">
      <h1>School Communication</h1>
      <img
        class="logo"
        src="../resources/school-icon-9.png"
        alt="school-logo"
      />
      <router-view />
    </div>
  </body>
</template>

<script>
import NavBar from "./components/NavBar.vue";

export default {
  components: { NavBar },
};
</script>

<style>
#app {
  background-color: white;
  display: grid;
  align-content: center;
  justify-content: center;
}
h1 {
  display: grid;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  align-content: center;
  justify-content: center;
}
/* img {
  display: grid;
  padding-left: 550px;
  height: 150px;
  width: auto;
} */

/* .nav {
  display: inline-flex;
  float: left;
  align-content: flex-start;
  align-items: flex-start;
  justify-content: flex-start;
  justify-items: flex-start;
} */
a {
  text-decoration: none;
  color: black;
  opacity: 100%;
  font-weight: bold;
}
.logo{
  display: grid;
  justify-content: center;
  height: 150px;
  width: auto;
  margin:auto;
}
body{
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white);
}
</style>
